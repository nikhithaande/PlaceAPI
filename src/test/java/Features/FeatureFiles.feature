
Feature: Validating GoogleMap API

  @AddPlace
  Scenario Outline: Verify if place can be successfully added
    Given having a payload with "<name>" "<address>" "<language>"
    When user calls "addPlaceAPI" API with "post" Http request
    Then The request got success with statusCode 200
    And  The "status" in the response body is "OK"
    And The "scope" in the response body is "APP"
    And verify place ID created maps to "<name>" using "getPlaceAPI"

    Examples:
      | name        | address       | language |
      | White house | White street  | Indian |
      | Pink house | Pink street  | Indian |
      | Blue house | Blue street  | Indian |

  @DeletePlace
  Scenario: Verify if deletePlace functionality is working
    Given user is having delete place payload
    When user calls "deletePlaceAPI" API with "post" Http request
    Then The request got success with statusCode 200
    And  The "status" in the response body is "OK"