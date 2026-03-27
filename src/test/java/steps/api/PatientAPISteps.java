package steps.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import pojo.CreatePatientRequest;
import utils.ApiUtils;
import utils.ConfigurationReader;

public class PatientAPISteps extends ApiUtils {

    @Given("base URL")
    public void base_url() {
        request = RestAssured.given().baseUri(ConfigurationReader.getProperty("apiBaseURL"))
                .contentType(ContentType.JSON);
    }

    @Given("{string} has valid authorization")
    public void user_has_valid_authorization(String userType) {
        request = request.header("Authorization", "Bearer " + getToken(userType));
    }

    @Given("{string} has invalid authorization")
    public void has_invalid_authorization(String userType) {
        request = request.header("Authorization", getToken(userType));
    }


    @When("user hits POST {string}")
    public void user_hits_post(String endPoint) {
        Faker faker = new Faker();

        CreatePatientRequest patientRequest = new CreatePatientRequest();
        patientRequest.setFirst_name(faker.name().firstName());
        patientRequest.setLast_name(faker.name().lastName());

        patientRequest.setDob("1980-03-24");
        patientRequest.setGender("Male");
        patientRequest.setPhone("3230000099");
        patientRequest.setEmail("candy99@gmail.com");
        patientRequest.setAddress("1 candy st");
        patientRequest.setEmergency_contact_name("John");
        patientRequest.setEmergency_contact_phone("1234567890");
        patientRequest.setInsurance_provider("Aetna");
        patientRequest.setInsurance_policy_number("POL12345");

        response = request.body(patientRequest).post(endPoint);
    }
  
    }

    @When("user hits POST {string} with missing required filed")
    public void user_hits_post_with_missing_required_filed(String endPoint) {
        Faker faker = new Faker();

        CreatePatientRequest patientRequest = new CreatePatientRequest();
        patientRequest.setFirst_name(faker.name().firstName());
        patientRequest.setLast_name(faker.name().lastName());

        patientRequest.setDob("1980-03-24");
        patientRequest.setGender("Male");
        //patientRequest.setPhone("3230000099");
        //patientRequest.setEmail("candy99@gmail.com");
        patientRequest.setAddress("1 candy st");
        patientRequest.setEmergency_contact_name("John");
        patientRequest.setEmergency_contact_phone("1234567890");
        patientRequest.setInsurance_provider("Aetna");
        patientRequest.setInsurance_policy_number("POL12345");

        response = request.body(patientRequest).post(endPoint);
    }


    @Then("verify status code is {int}")
    public void verify_status_code_is(Integer statusCode) {
        int actualStatusCode = response.statusCode();
        Assertions.assertEquals(statusCode, actualStatusCode);
        System.out.println("response.asPrettyString() = " + response.asPrettyString());
    }


}
