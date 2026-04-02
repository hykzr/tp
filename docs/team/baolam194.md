# Tran Bao Lam's Project Portfolio Page

### Project: InternTrack

## Overview

InternTrack streamlines the internship application chaos. It provides a fast CLI interface to log company contacts and application deadlines, ensuring students never miss a follow-up in a high-volume application season.

## Summary of Contributions

### Code Contributed

- [RepoSense link](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=baolam&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2026-02-20T00%3A00%3A00&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=BaoLam194&tabRepo=AY2526S2-CS2113-W10-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

### Enhancements Implemented

#### New Features:

- **List command**: Integrate new code into existing Parser/InternTrack class to handle the listing support.
    - **What it does:** Users can list all applications using the format `list`.
    - **Justification:** This feature is critical for the core functionality of InternTrack, allowing users to see all logged applications with relevant details while maintaining data integrity.
    - **Highlights:** The format of the application is printed, E.g.normal description first, then deadline, then contact 

- **Sort command with some flags for flexibility**: Implemented sorting command to list all the application within the criteria in order.
    - **What it does:** Users can sort the current list of applications based on a specified criteria using the format `sort by/[CRITERIA]`. Supported criteria include `COMPANY`, `ROLE`, `STATUS`, and `DEADLINE`. The command sorts the existing application list in ascending alphabetical order according
    - **Justification:** This feature improves usability by allowing users to quickly organize and view applications based on different attributes, making it easier to track applications when the list becomes large.
    - **Highlights:** The implementation parses the user input to determine the sorting criteria and applies a comparator to sort the existing application list accordingly without modifying the stored data structure permanently. Invalid criteria are handled with error messages to guide the user
#### Other Enhancements:

- **Comprehensive Unit Testing**: Wrote extensive test cases covering ApplicationList functions such as `add`, `list`, and `sort`, including edge cases and invalid inputs

- **Exception and Error Handling**: Implemented input validation and error handling for invalid commands, incorrect formats, and edge cases to prevent crashes and ensure smooth execution.

- **Output Formatting Improvements**: Standardized display format for `UI` class to ensure clarity and consistency.

- **Bug squashing**: Have fixed a lots of bugs of the whole application during smoke test, notably the null parsing from storage to application.

### Contributions to the UG

- Added comprehensive documentation for the `list `and `sort` command, including format, parameters, and usage examples with expected output

### Contributions to the DG

- **Architecture** : Documented the high-level architecture of the whole application
    - Describe the lifecycle and components for the architecture itself
    - Draw the diagram to illustrate the interaction between different components in the application architecture.
- **ApplicationList Component**: Documented the architecture and responsibilities of the ApplicationList logic middleware, including:
    - Component design and stateless architecture
    - Class diagram and interaction with other components
    - Explanation of core operations (add, edit, filter, sort)
  
- **Sort Feature Implementation**: Documented the 5-step pipeline for the sort command with detailed walkthrough covering:
    - Parsing user input to extract sorting criteria and flags
    - Criteria and flag validation against application fields
    - Sorting logic using comparator construction
    - Returning a new sorted list without mutating original data
    - User feedback through formatted output
    - Sequence diagram illustrating the complete workflow
- **Use cases**: Describe some standard/common use cases of this application and the expected workflow.

### Contributions to Team-Based Tasks

- Manage issue trackers by creating the issues at the start of v1.0 and v2.0
- Review and approve other team members pull request to ensure good standard.

### Review/Mentoring Contributions

- PRs reviewed:[#7](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/7), [#11](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/11), [#12](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/12), [#14](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/14), [#15](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/15), [#24](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/24), [#33](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/33), [#42](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/42), [#45](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/45), [#49](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/49), [#50](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/50), [#51](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/51) , [#52](https://github.com/AY2526S2-CS2113-W10-1/tp/pull/52)

