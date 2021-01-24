package steps;

import io.cucumber.java.en.Given;

public class GetRequest {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/";

        Response res  = given()
                .param("page", "2")
                .when()
                .get("/api/users")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .and()
                .statusCode(200).extract().response();
    }

}
