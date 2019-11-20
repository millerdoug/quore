# quore
##Login Page
This app tests the quore login
Tests:

1.Loads as Https

2.Title of Page

3. Text 'Log Into Quore' exists

4. Text 'Qure', 'Quote', 'Quite', 'Hostel' does not exist anywhere on page (verifying common typos don't exist)

5. Id/Password text boxes exist and accept characters

6. Login button not clickable until id/password filled in

## Forgot Password
1. 'Forgot Password' link exists and works when clicked

## Forgot ID
1. 'Forgot Quore Id' link exists and works when clicked

## Info
1. 'Learn what Quore can do for your hotel.' link exists and works

# Notes on Running
1. Created with Java 8
1. ChromeDriver should be run from a dependency in the POM, but is currently a static download, see https://stackoverflow.com/questions/35867102/how-to-work-with-selenium-chrome-driver-in-maven-without-chromedriver-exe
1. Unused GroovyTestSuite Reference https://www.tutorialspoint.com/groovy/groovy_unit_testing.htm
