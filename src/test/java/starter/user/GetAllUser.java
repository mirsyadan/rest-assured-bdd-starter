package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllUser {
    private static String url = "https://fakestoreapi.com/";

    @Step("I set valid API endpoint and method")
    public String setValidApiEndpointAndMethod() {
        return url + "users";
    }

    @Step("I send a request to get all user")
    public void sendARequestToGetAllUser() {
        SerenityRest.given()
                .get(setValidApiEndpointAndMethod());
    }

    @Step("I receive the status code 200 OK")
    public void receiveTheStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get all user with valid")
    public void getAllUserWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_USER_SCHEMA);

        restAssuredThat(response -> response.body("address", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set valid API endpoint and wrong method")
    public String setValidApiEndpointAndWrongMethod() {
        return url + "users";
    }

    @Step("I send request to get all user with invalid method")
    public void sendRequestToGetAllUserWithInvalidMethod() {
        SerenityRest.given()
                .patch(setValidApiEndpointAndWrongMethod());
    }

    @Step("I receive the status code 404 not found")
    public void receiveTheStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
