package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;

import java.util.InputMismatchException;

public class ApiUtils {
    public String getToken(String userType){

        String email;

        switch (userType.toLowerCase()){
            case "doctor" :
                email = ConfigurationReader.getProperty("doctorLevinskaiaEmail");
                break;
            case "nurse":
                email = ConfigurationReader.getProperty("nurseEmail");
                break;
            case "office manager":
                email = ConfigurationReader.getProperty("officeManagerEmail");
                break;
            default:
                throw new InputMismatchException("Error! Provide valid type of user: doctor, nurse, office manager");
        }


        JSONObject requestBody = new JSONObject();
        requestBody.put("email", email);
        requestBody.put("password", ConfigurationReader.getProperty("validPassword"));

        String responseBody = RestAssured.given()
                .baseUri(ConfigurationReader.getProperty("apiBaseURL"))
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post("/api-auth/login")
                .getBody().asString();

        JSONObject jsonObject = new JSONObject(responseBody);

        return jsonObject.getString("token");
    }
}
