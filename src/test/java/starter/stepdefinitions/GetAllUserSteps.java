package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.GetAllUser;

public class GetAllUserSteps {

    @Steps
    GetAllUser getAllUser;

    @Given("I set valid API endpoint and method")
    public void setValidApiEndpointAndMethod(){
        getAllUser.setValidApiEndpointAndMethod();
    }
    @When("I send a request to get all user")
    public void sendARequestToGetAllUser(){
        getAllUser.sendARequestToGetAllUser();
    }
    @Then("I receive the status code 200 OK")
    public void receiveTheStatusCode200(){
        getAllUser.receiveTheStatusCode200();
    }
    @And("I get all user with valid")
    public void getAllUserWithValid(){
        getAllUser.getAllUserWithValid();
    }
    @Given("I set valid API endpoint and wrong method")
    public void setValidApiEndpointAndWrongMethod(){
        getAllUser.setValidApiEndpointAndWrongMethod();
    }
    @When("I send request to get all user with invalid method")
    public void sendRequestToGetAllUserWithInvalidMethod(){
        getAllUser.sendRequestToGetAllUserWithInvalidMethod();
    }
    @Then("I receive the status code 404 not found")
    public void receiveTheStatusCode404(){
        getAllUser.receiveTheStatusCode404();
    }
}
