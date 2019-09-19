Feature: Manage users consumer
  Scenario: Get all users
    When i call GET on /api/users
    Then the response body is :
      """
      [
         {
            "firstName":"ANASS",
            "lastName":"IBNOU ALI",
            "email":"Email@email.com",
            "age":25
         },
         {
            "firstName":"HAMZA",
            "lastName":"IBNOU ALI",
            "email":"Email@email.com",
            "age":22
         },
         {
            "firstName":"IKHLASS",
            "lastName":"IBNOU ALI",
            "email":"Email@email.com",
            "age":6
         }
      ]
      """
    And http status is 200


  Scenario: Get user by ID
    When i call GET on /api/users/123456789
    Then the response body is :
      """
       {
          "firstName":"ANASS",
          "lastName":"IBNOU ALI",
          "email":"Email@email.com",
          "age":25
       }
      """
    And http status is 200


  Scenario: Create new user
    Given i set the following request body :
        """
         {
            "firstName":"ANASS",
            "lastName":"IBNOU ALI",
            "email":"Email@email.com",
            "age":25
         }
      """
    When i call POST on /api/users with the request body
    Then http status is 201


  Scenario: Delete user
    When i call DELETE on /api/users/123456789 with the request body
    Then http status is 204


  Scenario: Update user
    Given i set the following request body :
      """
       {
          "firstName":"ANASS",
          "lastName":"IBNOU ALI",
          "email":"Email@email.com",
          "age":26
       }
      """
    And i call PUT on /api/users/123456789 with the request body
    Then http status is 200