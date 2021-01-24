package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class MyStepdefs {

    String email = "eve.holt@reqres.in";
    String password = "pistol";
    public static ResponseOptions<Response> response;
    Map<String, Object> postContent = new HashMap<>();
    RequestSpecification request;
    private static Response responsee;
    private static String jsonString;

    @Given("Check URL is working")
    public void checkURLIsWorking() throws Throwable {
        RestAssured.baseURI = "https://reqres.in";


        //language=JSON
        String jsonBody = "{\n" +
                "  \"email\": \"eve.holt@reqres.in\",\n" +
                "  \"password\": \"pistol\"\n}";

        System.out.println(jsonBody);

        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }



    @When("POST URL {string}")
    public void postURL(String arg0) {

        String yagmur = "{\n" +
                "  \"email\": \"eve.holt@reqres.in\",\n" +
                "  \"password\": \"pistol\"\n}";
        //RestAssured.expect().statusCode(200).with().body(postContent).when().get("https://reqres.in/api/register").then().statusCode(200);
        responsee = request.body(yagmur)
                .post("/api/register");
    }

    @Then("Response Code {int}")
    public void responseCode(int arg) {

        Assert.assertEquals(arg, responsee.statusCode());

    }


    @Given("perform unsuccessful Registration")
    public void performUnsuccessfulRegistration(List<List<String>> dTable) {

        DataTable data = DataTable.create(dTable);
        RestAssured.baseURI = "https://reqres.in";
        request = RestAssured.given();
        request.header("Content-Type", "application/json");

    }
    @When("Provide different combinations to {string}{string}")
    public void provideDifferentCombinationsTo(String email, String password) {

        String yagmur = "{\n" +
                "  \"email\": \"" +email +"\",\n" +
                "  \"password\": \""+password + "\"\n}";
        //RestAssured.expect().statusCode(200).with().body(postContent).when().get("https://reqres.in/api/register").then().statusCode(200);
        responsee = request.body(yagmur)
                .post("/api/register");
    }

    @Then("I should see the status code as {int}")
    public void iShouldSeeTheStatusCodeAs(int arg) {
        Assert.assertEquals(arg, responsee.statusCode());

    }


    @Given("Perform GET on {string}")
    public void performGETOn(String url) {
            given().contentType(ContentType.JSON);

    }


}


