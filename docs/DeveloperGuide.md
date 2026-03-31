# Design & Implementation

## Architecture

The architecture of InternTrack follows a layered design pattern with the following main components:

* UI (Ui): Handles user input and output via the command-line interface
* Logic (Parser, InternTrack): Processes user commands and orchestrates the application flow
* Model (Application, ApplicationList): Maintains the in-memory data structure for applications
* Storage (Storage): Manages persistence of application data to disk

The sequence of interaction follows a clear flow: User input → UI → Logic (Parser) → Model manipulation → Storage persistence.

---

## Application Initialization: Loading Persisted Data

Before any user interaction occurs, the application must load previously saved data from disk. This initialization step is critical for demonstrating how the storage mechanism works bidirectionally (save and load).

When `InternTrack.main()` is invoked at startup:

1. An empty `userApplications` ArrayList is created in memory
2. Immediately, `Storage.loadApplications(userApplications)` is called
3. This method checks if the data directory (`./data/`) and file (`./data/applications.txt`) exist
4. If either is missing, they are created automatically (graceful initialization)
5. The file is read line by line; each line is passed to `Storage.parseFileString()`
6. `parseFileString()` deserializes the pipe-delimited format back into `Application` objects
7. Each deserialized `Application` is added to the in-memory `userApplications` list

By the time the user sees the welcome prompt, all previously saved applications are already in memory. This design ensures:

* No data loss — All previous applications are restored at startup
* Consistency — The in-memory state matches the on-disk state at launch
* Error resilience — Malformed lines are logged and skipped rather than crashing the app

---

## Implementation of Add Feature

The add command follows a 5-step pipeline:

1. Parsing — User input is tokenized and validated
2. Object Creation — A new `Application` entity is instantiated with default status
3. Model Update — The application is added to the in-memory list
4. Storage Persistence — The updated model is serialized to disk
5. User Feedback — Confirmation is displayed to the user

---

## Detailed Walkthrough of Add Command

### Step 1: Parsing User Input

When a user enters
`add c/Google r/Software Engineer d/2024-03-31 ct/John Doe`,
the input is received by `Ui.readCommand()` and passed to `InternTrack.handleCommand()`.

This method inspects the command prefix and dispatches to `handleAddCommand()`.

The `Parser.createApplication()` method processes the raw input string:

* Uses a regex split pattern `(?=c/|r/|ct/|d/)` to tokenize by command prefixes
* Extracts mandatory fields: `c/` (Company) and `r/` (Role)
* Extracts optional fields: `d/` (Deadline in YYYY-MM-DD format) and `ct/` (Contact)
* Validates that mandatory fields are non-empty; if missing or empty, throws `InternTrackException`
* If a deadline is provided, parses it using `LocalDate.parse()`; invalid dates trigger an exception

---

### Step 2: Object Creation and Default Initialization

Once parsing is successful, `Parser.createApplication()` instantiates a new `Application` object with the extracted data.

Critically, the `Application` constructor automatically assigns a default status of "Pending" to all newly created applications. This ensures every new application has a well-defined initial state.

---

### Step 3: Model Update

The newly created `Application` object is returned to `ApplicationList.addApplications()`, which performs final validation:

* Adds the application to the internal `userApplications` ArrayList
* Returns the newly added `Application`

---

### Step 4: Storage Persistence

Immediately after the successful model update, `InternTrack.handleAddCommand()` calls `Storage.saveApplications(userApplications)` to persist the updated list to disk.

This ensures in-memory and on-disk states remain synchronized.

The `Storage.saveApplications()` method:

1. Opens a `FileWriter` to `./data/applications.txt`
2. Iterates through all applications in the list
3. Converts each `Application` to a pipe-delimited string:
   `company|role|deadline|contact|status`
4. Writes all serialized applications to disk in a single operation
5. Null fields are represented as the string `"null"`

---

### Step 5: User Feedback

Finally, `Ui.printAddApplication()` displays a confirmation message showing the added application details and the updated total count.

---

### Sequence Diagram illustrating the 5 steps above

![add\_sequence\_diag.png](diagrams/add_sequence_diag.png)

---

## Implementation of Edit Feature

The `edit` command allows users to modify the status of an existing application.

Command format:

edit INDEX s/STATUS

Example:

edit 2 s/Accepted

Implementation steps:

1. `Parser.parseEditCommand()` extracts the index and new status.
2. The index is validated to ensure it exists in the application list.
3. `ApplicationList.editApplicationStatus()` retrieves the application.
4. The application’s `setStatus()` method updates the status value.
5. `Storage.saveApplications()` persists the updated list.
6. `Ui.printEditSuccess()` displays confirmation to the user.

The `Application.setStatus()` method also performs validation to ensure that the status value is not null or empty.

This approach keeps validation within the model while command interpretation remains in the logic layer.

---

### Sequence Diagram: Edit Command

![edit\_sequence\_diag.png](diagrams/edit_sequence_diag.png)

---

## Implementation of Undo Feature

The `undo` command allows users to revert the most recent modification made to the application list.

Supported commands:

* add
* edit
* delete

Undo is implemented using a snapshot-based state restoration mechanism.

---

### Snapshot Mechanism

Before executing any modifying command:

1. A deep copy of the current `userApplications` list is created.
2. The snapshot is pushed onto an undo history stack.

When the user executes `undo`:

1. The most recent snapshot is popped from the stack.
2. The application list is replaced with the snapshot.
3. The restored state is written to storage.

This guarantees the system returns to the exact state before the most recent change.

---

### Example Workflow

add c/Google r/SWE Intern
delete 1
undo

Execution flow:

1. `add` stores a snapshot of the empty list then adds the application.
2. `delete` stores a snapshot then removes the application.
3. `undo` restores the previous snapshot.

The deleted application reappears in the list.

---

### Sequence Diagram: Undo Command

![undo\_sequence\_diag.png](diagrams/undo_sequence_diag.png)

---

## Design Considerations

### Aspect 1: Where the Application Object is Instantiated

**Alternative 1 (Current Choice):** Instantiate the complete `Application` object inside the `Parser.createApplication()` method.

Pros:

* Parsing logic is centralized and reusable across commands
* `ApplicationList` is insulated from parsing concerns; it only knows about domain objects
* Clear separation of concerns between input parsing and model management
* Validation happens at a single point, reducing the risk of inconsistency

Cons:

* Parser is tightly coupled to the `Application` class structure
* Changes to the `Application` constructor signature require updating the parser
* If multiple ways to create `Application` objects are needed, code duplication may occur

**Alternative 2:** Instantiate inside model layer.

Pros:

* Reduces coupling between parser and model
* Gives model more control over object creation

Cons:

* Violates Single Responsibility Principle
* Duplicates validation logic
* Harder testing
* Reduced reusability

**Rationale:** Centralizing instantiation in parser improves maintainability and consistency.

---

### Aspect 2: When to Persist Data to Storage

**Alternative 1 (Current Choice):** Auto-save after every command.

Pros:

* Prevents data loss
* Guarantees consistency
* Simplifies error handling
* No user dependency

Cons:

* Increased disk I/O
* Less efficient for batch operations
* Slight latency

**Alternative 2:** Manual save.

Pros:

* Better performance
* User-controlled

Cons:

* High risk of data loss
* User burden
* Inconsistent state

**Rationale:** Data safety outweighs performance cost.

---

### Aspect 3: File Format for Persistent Storage

**Alternative 1 (Current Choice):** Pipe-delimited format.

Pros:

* Human-readable
* No dependencies
* Simple logic
* Fast I/O
* Small file size

Cons:

* Not scalable
* Delimiter conflicts
* Fragile format

**Alternative 2:** JSON

Pros:

* Structured
* Extensible
* Standard format

Cons:

* Requires libraries
* Larger size
* Overkill

**Alternative 3:** Database

Pros:

* Scalable
* Powerful queries

Cons:

* Complex
* Heavy
* Overkill

**Rationale:** Pipe format is sufficient for current scope.

---

### Aspect 4: Undo Implementation

**Alternative 1 (Current Choice): Snapshot-based restoration**

Pros:

* Simple and reliable
* Independent of command logic
* Guarantees correct state restoration

Cons:

* Increased memory usage

**Alternative 2: Command-based reversal**

Pros:

* More memory efficient

Cons:

* Significantly more complex
* Each command requires custom undo logic

**Rationale:** Snapshot approach chosen for simplicity and reliability.

---
