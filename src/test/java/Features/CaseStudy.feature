Feature: Nesine Case Study

  Scenario: Login to nesine with a valid user and get popular football bets
    Given Get nesine main page
    When Login as a valid user
    Then Check login correctly
    And Visit 'popular bets' page
    And Check at 'popular bets' page
    And Click 'futbol' tab
    And Check at 'futbol' tab
    And Get 'popular bets' via api call
    And Logout the system

  Scenario: Login to nesine with a valid user and get popular basketball bets
    Given Get nesine main page
    When Login as a valid user
    Then Check login correctly
    And Visit 'popular bets' page
    And Check at 'popular bets' page
    And Click 'basketball' tab
    And Check at 'basketball' tab
    And Get 'popular bets' via api call
    And Logout the system
