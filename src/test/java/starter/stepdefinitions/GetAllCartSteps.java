package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.GetAllCart;

public class GetAllCartSteps {

    @Steps
    GetAllCart getAllCart;

    @Given("I set the valid endpoint and method")
    public void setTheValidEndpointAndMethod(){
        getAllCart.setTheValidEndpointAndMethod();
    }
    @When("I send a request to get all cart")
    public void sendARequestToGetAllCart(){
        getAllCart.sendARequestToGetAllCart();
    }
    @Then("I receive in status code 200 OK")
    public void receiveInStatusCode200(){
        getAllCart.receiveInStatusCode200();
    }
    @And("I get all cart with valid")
    public void getAllCartWithValid(){
        getAllCart.getAllCartWithValid();
    }
    @Given("I set the valid endpoint and wrong method")
    public void setValidEndpointAndWrongMethod(){
        getAllCart.setValidEndpointAndWrongMethod();
    }
    @When("I send request to get all cart with invalid method")
    public void sendRequestToGetAllCartWithInvalidMethod(){
        getAllCart.sendRequestToGetAllCartWithInvalidMethod();
    }
    @Then("I receive in status code 404 not found")
    public void receiveInStatusCode404(){
        getAllCart.receiveInStatusCode404();
    }
}
