# GitHub Setup and Submission

## One-time account setup

1. Go to https://github.com and select **Sign up**.
2. Create your account and verify the email address GitHub sends you.
3. Sign in and create a **new repository** named `comp1050-lab3-deck`.
4. Choose **Private** unless your instructor says otherwise. Leave the README, `.gitignore`, and license boxes unchecked, then create the empty repository.

## Connect this IntelliJ project

Extract and open the starter folder in IntelliJ. Edit `GITHUB_SUBMISSION.txt` first. Then open IntelliJ's **Terminal** and run these commands, replacing `USERNAME`:

```text
git init
git add .
git commit -m "Initial Lab 3 setup"
git branch -M main
git remote add origin https://github.com/USERNAME/comp1050-lab3-deck.git
git push -u origin main
```

GitHub may open a browser so you can sign in. Do not put a password or access token in any assignment file.

## Save later work

After completing or revising the lab, run:

```text
git add .
git commit -m "Complete Lab 3 deck of cards"
git push
```

Visit the repository webpage and confirm the newest files and commit are visible.

## Submit from GitHub to Gradescope

1. Open Lab 3 in Gradescope and select **Submit Assignment**.
2. Select **GitHub** as the submission method and authorize access if prompted.
3. Choose `comp1050-lab3-deck` and the `main` branch.
4. Submit the repository. If Gradescope asks which files to include, select `Card.java`, `Deck.java`, `Main.java`, and `GITHUB_SUBMISSION.txt`.
5. Confirm that the autograder ran on the newest commit. You may resubmit after pushing corrections.

The autograder reserves 10 points for GitHub submission evidence. A normal file upload without GitHub metadata or a completed manifest loses those points.
