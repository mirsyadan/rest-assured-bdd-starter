package starter.user;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllProduct {
    private static String url = "https://fakestoreapi.com/";

    @Step("I set valid endpoint and method")
    public String setValidEndpointAndMethod() {
        return url + "products";
    }

    @Step("I send a request to get all product")
    public void sendARequestToGetAllProduct() {
        SerenityRest.given()
                .get(setValidEndpointAndMethod());
    }

    @Step("I receive on status code 200 OK")
    public void receiveOnStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get all product with valid")
    public void getAllProductWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PRODUCT_SCHEMA);

        restAssuredThat(response -> response.body("id", notNullValue()));
        restAssuredThat(response -> response.body("title", notNullValue()));
        restAssuredThat(response -> response.body("price", notNullValue()));
        restAssuredThat(response -> response.body("description", notNullValue()));
        restAssuredThat(response -> response.body("category", notNullValue()));
        restAssuredThat(response -> response.body("rating", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set valid endpoint and wrong method")
    public String setValidEndpointAndWrongMethod() {
        return url + "products";
    }

    @Step("I send request to get all product with invalid method")
    public void sendRequestToGetAllProductWithInvalidMethod() {
        SerenityRest.given()
                .patch(setValidEndpointAndWrongMethod());
    }

    @Step("I receive on status code 404 not found")
    public void receiveOnStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
