package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Login;

public class LoginSteps {
    @Steps
    Login login;

    @Given("I set the API endpoint for login")
    public void setAPIEndpointLogin(){
        login.setAPIEndpointLogin();
    }

    @When("I submit a request to the API endpoint with a valid email and password")
    public void sendRequestLoginValidEmailAndPass(){
        login.sendRequestLoginValidEmailAndPass();
    }

    @And("I should receive a status code of 200")
    public void receiveStatusCode200(){
        login.receiveStatusCode200();
    }

    @Then("I should receive a token indicating successful login")
    public void receiveTokenLoginSuccess(){
        login.receiveTokenLoginSuccess();
    }

    @When("I send a request to the API endpoint with a empty data")
    public void sendRequestLoginEmptyData(){
        login.sendRequestLoginEmptyData();
    }

    @Then("I should receive a status code of 400 Bad Request")
    public void receiveStatusCode400(){
        login.receiveStatusCode400();
    }
}
