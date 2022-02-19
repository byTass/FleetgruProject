
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


  Scenario Outline: Valid username and invalid password
    When user enters "<username>" and "<password>"
    And clicks login button
    Then "Invalid user name or password." message should be displayed

    Examples:
      |username         |password      |
      |user1            |UserUser12    |
      |user13           |UserUser      |
      |user167          |User123       |
      |storemanager51   |Userme123     |
      |storemanager75   |UserUser1234  |
      |storemanager100  |UserUser_123  |
      |salesmanager101  |User$User123  |
      |salesmanager145  |User.User.123 |
      |salesmanager276  |X             |

    Scenario Outline: Empty username
      When user enters "<username>" and "<password>"
      And clicks login button
      Then "Please fill out this field." warning should be displayed under Username Box

      Examples:
        |username         |password      |
        |                 |UserUser123   |
        |                 |UserUser123   |
        |                 |UserUser123   |


  Scenario Outline: Empty password
    When user enters "<username>" and "<password>"
    And clicks login button
    Then "Please fill out this field." warning should be displayed under Password Box

    Examples:
      |username         |password      |
      |user1            |              |
      |storemanager51   |              |
      |salesmanager101  |              |

  Scenario: Forgot Password link function
    When user clicks Forgot Your Password link
    Then user lands on Forgot Password page

  Scenario: Remember Me Link Function
    When user sees Remember me on this computer link
    Then user should be able to click

  Scenario Outline: Bullet Sign Password
    When user enters "<username>" and "<password>"
    Then user should see password in bullet sign

    Examples:
      |username        |password    |
      |user1           |UserUser123 |
      |salesmanager101 |UserUser123 |
      |storemanager51  |UserUser123 |

  Scenario Outline: Keyboard Enter Key Function on Login Page
    When user enters "<username>" and "<password>" clicks Enter via keyboard
    Then user lands on "<subtitle>" page successfully

    Examples:
      |username        |password    |subtitle        |
      |user1           |UserUser123 |Quick Launchpad |
      |storemanager51  |UserUser123 |Dashboard       |
      |salesmanager101 |UserUser123 |Dashboard       |

    Scenario Outline: User Sees Their Names in the profile menu
      Given user enters "<username>" and "<password>"
      And clicks login button
      And user lands on "<subtitle>" page successfully
      Then users see their own "<name>" in the profile menu

      Examples:
        |username        |password    |subtitle        |name          |
        |user1           |UserUser123 |Quick Launchpad |John Doe      |
        |storemanager51  |UserUser123 |Dashboard       |Patrick Home  |
        |salesmanager101 |UserUser123 |Dashboard       |Sam Winchester|





