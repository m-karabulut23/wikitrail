# 2.3 Chunked Build Plan

Each step should produce one testable Git commit.

1. Initialize the Java/Maven project, Git repository, README, and folder structure.
2. Implement a terminal menu with search and quit options; test valid and invalid input.
3. Write a Wikipedia HTTP GET helper and verify it handles success and API/network errors.
4. Parse Wikipedia JSON into article titles, introductions, and related article links.
5. Implement article search and display an introduction in the terminal.
6. Show numbered related links and let the user open one by its number.
7. Track visited articles in an `ArrayList` and print the ordered research trail.
8. Implement returning to an earlier article and test an end-to-end multi-link session.
9. Add tests for invalid links, missing articles, empty results, and network failures; finalize usage instructions.
