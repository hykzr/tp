# Chua Yong Liang's Project Portfolio Page

### Project: InternTrack

## Overview

InternTrack streamlines the internship application chaos. It provides a fast CLI interface to log company contacts and application deadlines, ensuring students never miss a follow-up in a high-volume application season.

## Summary of Contributions

### Code Contributed

- [RepoSense link](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=chuayongliang6&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2026-02-20T00%3A00%3A00&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&filteredFileName=)

### Enhancements Implemented

**New Features:**

- **Add Command with Flexible Parsing**: Implemented a command parser that allows users to add internship applications with multiple optional parameters.
  - **What it does:** Users can add applications using the format `add c/COMPANY r/ROLE [d/DEADLINE] [ct/CONTACT]`, where company and role are required fields, and deadline (in YYYY-MM-DD format) and contact are optional. The parser handles extra spaces and validates date formats.
  - **Justification:** This feature is critical for the core functionality of InternTrack, allowing users to quickly log applications with relevant details while maintaining data integrity through validation.
  - **Highlights:** The Parser class includes comprehensive error handling with custom `InternTrackException` messages. Tests cover edge cases including valid/invalid dates, missing prefixes, and extra spacing. The implementation required careful regex pattern matching and field validation logic.

- **Remind Command with Deadline Filtering**: Implemented a reminder system that filters and displays applications with upcoming deadlines.
  - **What it does:** Users can run `remind [DAYS]` to see all applications due within a specified number of days (defaults to 7 days if no argument provided). The system calculates a cutoff date and filters applications accordingly.
  - **Justification:** This feature helps users track time-sensitive deadlines and prevents missing application submissions, which is essential for managing high-volume application seasons.
  - **Highlights:** The implementation includes flexible input parsing (supporting single digits, multi-digit numbers, and default values) with validation for zero and negative inputs. The `ApplicationList.filterApplicationsOnOrBefore()` method efficiently filters applications while excluding those without deadlines.

- **Persistent Storage System**: Implemented file-based persistence for storing and retrieving application data.
  - **What it does:** Applications are automatically saved to a local text file (`./data/applications.txt`) using a pipe-delimited format. The system loads applications on startup and handles file creation if it doesn't exist.
  - **Justification:** Persistence ensures users don't lose their application data between sessions, which is critical for a tracking application.
  - **Highlights:** The Storage class includes robust error handling, automatic directory creation, and file validation. The implementation handles null values gracefully (representing missing optional fields) and includes logging for debugging.

**Other Enhancements:**

- **Comprehensive Unit Testing**: Wrote extensive test suites covering parsing logic, application management, and filtering functionality (ParserTest.java with 13 test cases, ApplicationListTest.java with 5 test cases).
  - Tests validate happy paths, edge cases (extra spaces, decimal numbers, special characters), and error conditions (missing required fields, invalid date formats, zero/negative values).
  - Increased code reliability through boundary testing and integration with JUnit 5.

- **Logging and Error Handling**: Integrated Java logging throughout the application with appropriate log levels (INFO, WARNING, SEVERE) for debugging and monitoring application behavior.
  - Implemented custom `InternTrackException` for application-specific error handling with descriptive user-facing error messages.

- **Application Model with Status Tracking**: Created the core `Application` class representing an internship application with fields for company, role, deadline, contact, and status (defaulting to "Pending").
  - Includes assertions for data validation and a `toString()` method for user-friendly display.

- **Command Dispatch System**: Implemented command routing in the main `InternTrack` class that handles multiple commands (`add`, `remind`, `summary`, `bye`) with appropriate error handling and state management.

### Contributions to the UG

- Added comprehensive documentation for the `add `and `remind` command, including format, parameters, and usage examples with expected output

### Contributions to the DG

- **Storage Component**: Documented the complete design and implementation of the persistence layer, including:
  - Class diagram
  - Detailed explanation of load/save operation sequences
  - File format specification with examples (pipe-delimited format)
  - Comprehensive error handling and corruption resilience strategies
  - Design considerations comparing auto-save vs. explicit save, and file format alternatives (plain-text vs. JSON vs. database)

- **Add Feature Implementation**: Documented the 5-step pipeline for the add command with detailed walkthrough covering:
  - Parsing user input with regex pattern matching
  - Object creation and default initialization
  - Model update and validation
  - Storage persistence
  - User feedback
  - Sequence diagram illustrating the complete workflow

- **Remind Feature**: Documented the full implementation of the deadline reminder system, including:
  - Detailed walkthrough of how the remind command works with example usage scenarios
  - Error handling for edge cases (invalid days, non-integer input, no matches)
  - Design considerations for default behavior (7-day default) and deadline inclusivity logic
  - Integration between Parser, ApplicationList, Ui, and InternTrack components

### Contributions to Team-Based Tasks

- Manage issue trackers by creating the issues at the start of v1.0 and v2.0
- Provided comprehensive testing guide in the DG including: (1) Launch and shutdown procedures and (2) Testing the data saving on the app

### Review/Mentoring Contributions

- PRs reviewed: [#9](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/9), [#18](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/18), [#20](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/20), [#25](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/25), [#31](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/31), [#34](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/34), [#38](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/38), [#39](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/39), [#40](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/40)

### Contributions Beyond the Project Team

**Evidence of Helping Others:**

**Evidence of Technical Leadership:**
