package stepDefinitions;

import configReader.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

public class LoginPageSteps {

    LoginPage loginPage;

    @Given("user is on the login page")
    public void userIsOnTheLoginPage(){
        loginPage = new LoginPage();
        boolean flag = loginPage.validateUserOnLoginPage();
        Assert.assertTrue(flag);
    }

    @When("user enters username and password")
    public void userEntersUsernameAndPassword(){
       String username =  ConfigReader.getProperty("validUserName");
       String password =  ConfigReader.getProperty("validPassword");

       loginPage.enterLoginDetails(username,password);
    }

    @When("user enters invalid username and password")
    public void userEntersInvalidUsernameAndPassword(){
        String username =  ConfigReader.getProperty("invalidUserName");
        String password =  ConfigReader.getProperty("invalidPassword");

        loginPage.enterLoginDetails(username,password);
    }

    @When("user enters username and leaves password empty")
    public void userEntersUsernameAndLeavesPasswordEmpty(){
        String username =  ConfigReader.getProperty("validUserName");
        String password =  "";

        loginPage.enterLoginDetails(username,password);
    }

    @When("user enters locked user credentials")
    public void userEntersLockedUserCredentials(){
        String username =  ConfigReader.getProperty("lockedUserName");
        String password =  ConfigReader.getProperty("validPassword");

        loginPage.enterLoginDetails(username,password);
    }

    @And("clicks on the login button")
    public void clicksOnTheLoginButton(){
        loginPage.clickLoginButton();
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedMessage){
        String errorText = loginPage.validateErrorOnLoginPage();
        Assert.assertEquals(expectedMessage, errorText);
    }

}
