# Instructor Notes

This project contains the completed reference implementation and an expanded JUnit test suite. The solution uses Java 17 and Maven. Open the folder containing `pom.xml` in IntelliJ IDEA and run `DeckTest`.

The separate Gradescope autograder is worth 100 points. GitHub evidence is 10 points; all Java functionality is 90 points. The grader accepts repository folders and recursively locates the required files.

Before distributing the student starter, set the assignment's Gradescope submission options to permit GitHub submissions. Students should connect their GitHub account, select their repository and `main` branch, and include the completed `GITHUB_SUBMISSION.txt` committed to that repository.

Important limitation: an autograder container cannot independently contact private student repositories. Gradescope may expose GitHub submission metadata, but this varies by configuration. The committed manifest is therefore used as fallback evidence. It verifies that the student supplied a plausible matching GitHub identity and repository URL; it is not cryptographic proof of a push. Instructors can spot-check the repository link when academic-integrity verification is required.
