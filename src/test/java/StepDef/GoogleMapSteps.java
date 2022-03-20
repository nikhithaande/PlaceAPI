package StepDef;

import Resources.APIResources;
import Resources.ResourcePath;
import Resources.TestData;
import Resources.Utils;
import io.cucumber.java.en.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GoogleMapSteps extends Utils {
    RequestSpecification res;
    ResponseSpecification resSpec;
    Response response;
    TestData testData = new TestData();
    static String placeID;

    @Given("having a payload with {string} {string} {string}")
    public void having_a_payload_with(String name, String address, String language) throws IOException {
        res = given().spec(requestSpecification()).body(testData.addPlacePayload(name, address, language));
    }

    @Given("user is having delete place payload")
    public void user_is_having_delete_place_payload() throws IOException {
        res = given().spec(requestSpecification()).body(testData.deletePayLoad(placeID));
    }

    @When("user calls {string} API with {string} Http request")
    public void user_calls_api_with_http_request(String resource, String method) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());

        if(method.equalsIgnoreCase("POST"))
            response = res.when().post(resourceAPI.getResource());
        else if(method.equalsIgnoreCase("GET"))
            response = res.when().get(resourceAPI.getResource());
        else if(method.equalsIgnoreCase("UPDATE"))
            response = res.when().get(resourceAPI.getResource());

               // then().spec(resSpec).log().all().extract().response();
    }

    @Then("The request got success with statusCode {int}")
    public void the_request_got_success_with( int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());;
    }

    @Then("The {string} in the response body is {string}")
    public void the_in_the_response_body_is(String key, String value) {
        String actualStatus = getJsonPath(response, key);
        Assert.assertEquals(value, actualStatus);
    }

    @Then("verify place ID created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedName, String resourceName) throws IOException {
        placeID = getJsonPath(response, "place_id");
        res = given().spec(requestSpecification()).queryParam("place_id", placeID);
        user_calls_api_with_http_request(resourceName, "GET");
        String actualName = getJsonPath(response, "name");
        Assert.assertEquals(expectedName, actualName);
    }
}
