Feature: say hello with cucumber
  Scenario: Say Hello
    When i call GET on /hello
    Then the response body is :
      """
      {
        "label" : "Hello Crafts"
      }
      """
    And http status is 200