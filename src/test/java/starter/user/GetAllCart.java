package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllCart {
    private static String url = "https://fakestoreapi.com/";

    @Step("I set the valid endpoint and method")
    public String setTheValidEndpointAndMethod() {
        return url + "carts";
    }

    @Step("I send a request to get all cart")
    public void sendARequestToGetAllCart() {
        SerenityRest.given()
                .get(setTheValidEndpointAndMethod());
    }

    @Step("I receive in status code 200 OK")
    public void receiveInStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get all cart with valid")
    public void getAllCartWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CART_SCHEMA);

        restAssuredThat(response -> response.body("id", notNullValue()));
        restAssuredThat(response -> response.body("userId", notNullValue()));
        restAssuredThat(response -> response.body("date", notNullValue()));
        restAssuredThat(response -> response.body("products", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set the valid endpoint and wrong method")
    public String setValidEndpointAndWrongMethod() {
        return url + "carts";
    }

    @Step("I send request to get all cart with invalid method")
    public void sendRequestToGetAllCartWithInvalidMethod() {
        SerenityRest.given()
                .patch(setValidEndpointAndWrongMethod());
    }

    @Step("I receive in status code 404 not found")
    public void receiveInStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
