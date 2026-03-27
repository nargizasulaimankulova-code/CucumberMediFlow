package steps.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import utils.ApiUtils;
import utils.ConfigurationReader;

public class UserAPISteps extends ApiUtils {

    @When("user hits GET {string}")
    public void user_hits_get(String endPoint) {
        response = request.get(endPoint);
    }

    @Given("{string} has invalid authorization")
    public void has_invalid_authorization(String userType) {
        request = request.header("Authorization", "Bearer " + getToken(userType));
    }

    @Given("user has invalid authorization")
    public void userHasInvalidAuthorization() {
        request = request.header("Authorization", "Bearer invalidTokenihasdhfjhadfhjdfav");
    }
}
