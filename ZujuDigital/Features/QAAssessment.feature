Feature: Zuju Digital QA Assessment

  Scenario: Mark a team as Favourite
    Given I navigate to ZujuDigital Reputation page
    When I login and search for "Manchester City" and add as Favourite
    Then I logout from site
