Feature:
  Verify different Get and Post operations using REST-assured


  @Get_Request
  Scenario: Verify GET Request on User List
    Given Perform GET Request on "https://reqres.in"
    When GET URL on "/api/users"
    Then Status Code as 200
    Examples:
      | Response | Total  |
      | 200      | 12     |



