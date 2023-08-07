package APIStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class GenerateTokenStep {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    // value of token should be same as postman
    public static String token;
    RequestSpecification request;

    @Given("a JWI is generated")
    public void a_jwi_is_generated() {

        request = given().
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"email\": \"adminsarah@test.com\",\n" +
                        "  \"password\": \"admin@123\"\n" +
                        "}");
        Response response = request.when().post("/generateToken.php");
        response.prettyPrint();
        token = "Bearer " + response.jsonPath().getString("token");

        System.out.println(token);

    }

}
