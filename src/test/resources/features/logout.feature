Feature: Logout function
  Background:
    Given user navigates to Fleetgru login page


  Scenario Outline: User logout successfully
    When user enters "<username>" and "<password>"
    And clicks login button
    Then user lands on "<subtitle>" page successfully
    When user clicks profile menu dropdown
    And clicks "Logout"
    Then user should land on login page successfully

    Examples:
      |username        |password    |subtitle        |
      |user1           |UserUser123 |Quick Launchpad |
      |storemanager51  |UserUser123 |Dashboard       |
      |salesmanager101 |UserUser123 |Dashboard       |


    Scenario Outline: Step Back Button Function
      When user enters "<username>" and "<password>"
      And clicks login button
      Then user lands on "<subtitle>" page successfully
      When user clicks profile menu dropdown
      And clicks "Logout"
      Then user should land on login page successfully
      And user clicks step back button
      Then user should not be able to go to home page again

      Examples:
        |username        |password    |subtitle        |
        |user1           |UserUser123 |Quick Launchpad |
        |storemanager51  |UserUser123 |Dashboard       |
        |salesmanager101 |UserUser123 |Dashboard       |


    Scenario Outline: Closing Window Function
      When user enters "<username>" and "<password>"
      And clicks login button
      Then user lands on "<subtitle>" page successfully
      And user close the window
      And user navigates to Fleetgru website
      Then user should land on login page


      Examples:
        |username        |password    |subtitle        |
        |user1           |UserUser123 |Quick Launchpad |
        |storemanager51  |UserUser123 |Dashboard       |
        |salesmanager101 |UserUser123 |Dashboard       |

      @wip
  Scenario Outline: Closing All Window Function
    When user enters "<username>" and "<password>"
    And clicks login button
    Then user lands on "<subtitle>" page successfully
    And user opens new tabs
    And user close the window
    And user navigates to Fleetgru website
    Then user should land on login page


    Examples:
      |username        |password    |subtitle        |
      |user1           |UserUser123 |Quick Launchpad |
      |storemanager51  |UserUser123 |Dashboard       |
      |salesmanager101 |UserUser123 |Dashboard       |
