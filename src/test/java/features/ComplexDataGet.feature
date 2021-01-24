
Feature: ComplexDataGet
  Verify complex data

  @Successful
  Scenario: Verify Post Operation for Successful Register
    Given Check URL is working
    When POST URL "https://reqres.in/api/register"
    Then Response Code 200


  @Unsuccessful
  Scenario: Verify POST operation for unsuccessful register
    Given perform unsuccessful Registration
      | email              | password  |
      | eve.holt@reqres.in |  null |
    When Provide different combinations to "<email>""<password>"
    Then I should see the status code as 400
    Examples:
      |email     		    |password    | statuscode
      | eve.holt@reqres.in  |            |   400
      | eva.holt@reqres.in	|  pistol    |   400


