package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetPostSteps {
//GetUserList Operation Java file.

RequestSpecification request;
private static Response responsee;

    @Given("Perform GET Request on {string}")
    public void performGETRequestOn(String arg0) {

        RestAssured.baseURI = "https://reqres.in/";
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
        responsee= given().param("page", "1").when()
                .get("/api/users")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .and()
                .statusCode(200).extract().response();

        List<Integer> ids = responsee.jsonPath().getList("data.id");
        List<Integer> email = responsee.jsonPath().getList("data.email");
        List<Integer> first_name = responsee.jsonPath().getList("data.first_name");
        List<Integer> last_name = responsee.jsonPath().getList("data.last_name");
        List<Integer> avatar = responsee.jsonPath().getList("data.avatar");


        for(int i = 0; i < ids.size(); i++)
        {

            System.out.println("id: " + (i+1) + "\n" + " email: " + email.get(i) +
                    "\n"  +  " first_name: " + first_name.get(i) +
                    "\n"  +  " last_name: " + last_name.get(i) +
                    "\n"  +  " avatar: " + avatar.get(i));

            System.out.println("-------");

        }

    }

    @When("GET URL on {string}")
    public void getURLOn(String arg0) {


    }

    @Then("Status Code as {int}")
    public void statusCodeAs(int arg0) {
    }
}
