Feature: Go to the and control comments count for chosen store

  Scenario: Go website and control comments
    Given User go to the stores page
    And All stores write to excel
    When User select on "s" at 2nd store from excel
    Then user go to the chosen store page and control comments