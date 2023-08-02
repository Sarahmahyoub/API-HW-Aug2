package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    //baseURI = baseURL + endpoint
    //given - preparation
    //when - hitting the endpoint
    //base URI = base URL

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    // value of token should be same as postman
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2OTA5MzQ4NDQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY5MDk3ODA0NCwidXNlcklkIjoiNTY3MyJ9.D1sIgybPbw6bkhF3Al4k9UoS1uAHDFXkV8xjZe6UArw";

    static String employee_id;

    //in this method we are going to create an employee
    //we need headers, body to prepare the request
    @Test
    public void acreateEmployee() {
        //preparing the request
        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"emp_firstname\": \"Amy\",\n" +
                        "  \"emp_lastname\": \"Smith\",\n" +
                        "  \"emp_middle_name\": \"G\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2005-08-25\",\n" +
                        "  \"emp_status\": \"happy\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");
        //hitting the endpoint
        Response response = request.when().post("/createEmployee.php");
        //verifying the response
        response.then().assertThat().statusCode(201);
        //  System.out.println(response);
        //this method we use to print the response of API in console
        response.prettyPrint();

        response.then().assertThat().body("Employee.emp_firstname", equalTo("Amy"));
        response.then().assertThat().body("Employee.emp_middle_name", equalTo("G"));
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().header("Server", equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));
        employee_id = response.jsonPath().getString("Employee.employee_id");

        System.out.println(employee_id);

    }

    @Test
    public void bgetCreatedEmployee() {
        RequestSpecification request = given().header("Authorization", token)
                .queryParam("employee_id", employee_id);
        Response response = request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(employee_id, tempEmpId);

    }

    @Test
    public void cUpdateEmployee() {

        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Emma\",\n" +
                        "  \"emp_lastname\": \"Black\",\n" +
                        "  \"emp_middle_name\": \"F\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2023-04-01\",\n" +
                        "  \"emp_status\": \"Vacationing\",\n" +
                        "  \"emp_job_title\": \"Life Time Vacation\"\n" +
                        "}");

        Response response = request.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));

    }

    @Test
    public void dPartiallyUpdateEmployee() {

        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Emmy\",\n" +
                        "  \"emp_lastname\": \"Black\",\n" +
                        "  \"emp_middle_name\": \"K\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2023-04-01\",\n" +
                        "  \"emp_status\": \"Vacationing\",\n" +
                        "  \"emp_job_title\": \"LifeTime Vacation\"\n" +
                        "}");

        Response response = request.when().put("/updatePartialEmplyeesDetails.php");
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Message", equalTo("Employee record updated successfully"));

    }
}
