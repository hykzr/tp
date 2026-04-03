# Saayuj Ion's Project Portfolio Page

## Project: InternTrack

## Overview
InternTrack is a command-line application designed to help users efficiently track and manage internship applications. It allows users to add, edit, filter, and manage applications through a streamlined CLI interface.

The application is built using Java and follows a modular architecture with components such as UI, Parser, Model, and Storage.

---

## Summary of contributions

### Code contributed
[RepoSense Link](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=W10&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2026-02-20T00%3A00%3A00&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=SIONMATHEW&tabRepo=AY2526S2-CS2113-W10-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=functional-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

My contributions span multiple components including command handling, parsing, model updates, storage handling, and UI output, primarily supporting the implementation of the `edit` and `undo` features.

---

### Enhancements implemented

**Edit Command**
- Implemented the `edit` command to update application status.
- Integrated across Parser, Logic, Model, and UI components.
- Added validation, assertions, logging, and improved storage robustness.
- Included unit tests for correctness.

**Highlights:**
- Required cross-component integration.
- Strengthened with defensive programming for reliability.

**PRs:**
- https://github.com/AY2526S2-CS2113-W10-1/tp/pull/14
- https://github.com/AY2526S2-CS2113-W10-1/tp/pull/22

---

**Undo Command**
- Implemented `undo` to revert the most recent modifying command (add/edit/delete).
- Designed using snapshot-based state restoration with deep copying.
- Integrated with all modifying commands.

**Highlights:**
- Required state management using a stack.
- Ensured data consistency through deep copy.
- Included handling for edge cases (e.g., no history).

**PR:**
- https://github.com/AY2526S2-CS2113-W10-1/tp/pull/34

---

### Documentation

**Developer Guide**
- Wrote Introduction and contributed to overall DG structure.
- Authored documentation for:
    - Parser component
    - Application & ApplicationList components
    - Edit feature implementation
    - Undo feature implementation
- Added UML and sequence diagrams for edit and undo.

**PRs:**
- https://github.com/AY2526S2-CS2113-W10-1/tp/pull/24
- https://github.com/AY2526S2-CS2113-W10-1/tp/pull/40
- https://github.com/AY2526S2-CS2113-W10-1/tp/pull/51

---

### Contributions to team-based tasks
- Set up team GitHub repository workflow using forks.
- Guided team members on branching and collaboration process.
- Generated and uploaded executable JAR files for both v1.0 and v2.0 releases.
- Managed release assets including JAR and documentation files.

---

### Review/mentoring contributions
- Reviewed and approved multiple team pull requests, including:
    - Summary feature implementation (#46)
    - DG and code documentation updates (#43)
    - Test cases for sort command (#38)
    - User Guide updates (#23)
    - Delete feature implementation (#19)
    - Test additions for add command (#17)
    - List command and UI test implementation (#16)

Provided feedback to ensure code quality, correctness, and consistency across the project.
