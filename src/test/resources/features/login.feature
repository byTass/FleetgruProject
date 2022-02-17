Feature: As a user i should be able to login

  Background:
    When user navigates to Fleetgru login page

  Scenario Outline: All users can login with valid credentials

    When user enters "<username>" and "<password>"
    And clicks login button
    Then user lands on "<subtitle>" page successfully

    Examples:
    |username        |password    |subtitle        |
    |user1           |UserUser123 |Quick Launchpad |
    |user13          |UserUser123 |Quick Launchpad |
    |user167         |UserUser123 |Quick Launchpad |
    |storemanager51  |UserUser123 |Dashboard       |
    |storemanager75  |UserUser123 |Dashboard       |
    |storemanager100 |UserUser123 |Dashboard       |
    |salesmanager101 |UserUser123 |Dashboard       |
    |salesmanager145 |UserUser123 |Dashboard       |
    |salesmanager276 |UserUser123 |Dashboard       |
@wip
    Scenario Outline: Invalid username and valid password
      When user enters "<username>" and "<password>"
      And clicks login button
      Then "Invalid user name or password." message should be displayed

      Examples:
        |username        |password    |
        |useruser        |UserUser123 |
        |useryusuf       |UserUser123 |
        |yusuf           |UserUser123 |
        |onur Bey        |UserUser123 |
        |$newOmer        |UserUser123 |
        |john_stone      |UserUser123 |
        |whoAmI          |UserUser123 |
        |us1234us        |UserUser123 |
        |12us34we        |UserUser123 |



