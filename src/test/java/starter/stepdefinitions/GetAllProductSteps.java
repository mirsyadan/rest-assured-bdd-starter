package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.GetAllProduct;

public class GetAllProductSteps {

    @Steps
    GetAllProduct getAllProduct;

    @Given("I set valid endpoint and method")
    public void setValidEndpointAndMethod(){
        getAllProduct.setValidEndpointAndMethod();
    }
    @When("I send a request to get all product")
    public void sendARequestToGetAllProduct(){
        getAllProduct.sendARequestToGetAllProduct();
    }
    @Then("I receive on status code 200 OK")
    public void receiveOnStatusCode200(){
        getAllProduct.receiveOnStatusCode200();
    }
    @And("I get all product with valid")
    public void getAllProductWithValid(){
        getAllProduct.getAllProductWithValid();
    }
    @Given("I set valid endpoint and wrong method")
    public void setValidEndpointAndWrongMethod(){
        getAllProduct.setValidEndpointAndWrongMethod();
    }
    @When("I send request to get all product with invalid method")
    public void sendRequestToGetAllProductWithInvalidMethod(){
        getAllProduct.sendRequestToGetAllProductWithInvalidMethod();
    }
    @Then("I receive on status code 404 not found")
    public void receiveOnStatusCode404(){
        getAllProduct.receiveOnStatusCode404();
    }
}
