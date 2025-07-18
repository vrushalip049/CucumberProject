Feature: This is for Registration test

  Scenario: Successful Registration feature test
    Given User is on Register Home page
    When User enter "Vrushali" "Patil" "vrush" "Vrush@123" and "true"
    Then click on login page and captcha
    And Register successful

  Scenario Outline: Unsuccessful Registration feature test
    Given User is on Register Home page
    When User enter "<firstname>" "<lastname>" "<username>" "<password>" and "<captcha>"
    Then click on login page and captcha
    And Register Unsuccessful

    Examples:
      | firstname | lastname | username | password | captcha |
      | Seeta     | Patil    | seeta    | Seeta    | true    |
     # | Seeta     |          | seeta    | Seeta    | true    |
   	 #  |           | Patil    | seeta    | Seeta    | true    |
   	 #  | seeta     | Patil    |          | Seeta    | true    |
     #  | seeta     | Patil    |          | Seeta    | true    |
     # | Seeta     | Patil    | seeta    | Seeta    | false   |
