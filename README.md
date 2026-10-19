# ST10513367-JAVAPOE-PART2
# Programming Assignment -  Registration, Login and QuickChat

## Description
This console-based Java application implements the Registration and Login Feature from Part 1 and the QuickChat messaging functionality developed in Part 2.

# Java #Registration #Login #QuickChat #ConsoleApplication

## Features
- Username validation
- Password complexity validation
- South African cellphone validation using a regular expression
- User registration
- User login
- QuickChat menu with options to send messages, display recently sent messages and quit
- Message validation
= Message ID generation
- Message hash generation
- Sending, disregarding and storing messages
- Displaying recently sent messages
- Storing message information in a JSON file
- JUnit unit tests
- Automated testing using GitHub Actions

## Test data from the assignment
- Valid username: `kyl_1`
- Invalid username: `kyle!!!!!!!`
- Valid password: `Ch&!!sec@ke99!`
- Invalid password: `password`
- Valid cell phone: `+27838968976`
- Invalid cell phone: `08966553`

## Running
Run `ProgrammingAssignment.java` as a console application.

Run `LoginTest.java` using JUnit 5 in NetBeans.

To run the automated tests using Maven, open a terminal in the project directory and execute:

mvn test

## GitHub Actions

The project is intended to use GitHub Actions to run automated tests when changes are pushed to the repository or a pull request is created.

Check the Actions tab in the GitHub repository to confirm that the workflow runs successfully.

## Technologies used
- Java
- Apache NetBeans
- Apache Maven
- JUnit 4.13.2
- GitHub Actions

## Note

The application was developed in stages as part of the programming assignment. It uses console input only and does not use a graphical user interface or JOptionPane. Features and tests should be checked against the relevant assignment requirements before submission.

## References

1. Oracle. 2026. *Java SE 21 API Documentation: String Class.*  
   Available at: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html  
   Accessed: 17 September 2026.

2. Oracle. 2026. *Java SE 21 API Documentation: java.util.regex Package.*  
   Available at: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/package-summary.html  
   Accessed: 17 September 2026.

3. Oracle. 2026. *Java Tutorials: Characters.*  
   Available at: https://docs.oracle.com/javase/tutorial/java/data/characters.html  
   Accessed: 17 September 2026.

4. JUnit. 2026. *JUnit 4 API: Assert.*  
   Available at: https://junit.org/junit4/javadoc/latest/org/junit/Assert.html  
   Accessed: 17 September 2026.

5. JUnit. 2026. *JUnit 4 API: Test Annotation.*  
   Available at: https://junit.org/junit4/javadoc/4.13.2/org/junit/Test.html  
   Accessed: 17 September 2026.

6. GitHub. 2026. *About repositories.*  
   Available at: https://docs.github.com/en/repositories/creating-and-managing-repositories/about-repositories  
   Accessed: 17 September 2026.

7. GitHub. 2026. *About the repository README file.*  
   Available at: https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-readmes  
   Accessed: 17 September 2026.

# ProgrammingAssignment #SoftwareDevelopment #JavaProject #JUnit #GitHubActions
