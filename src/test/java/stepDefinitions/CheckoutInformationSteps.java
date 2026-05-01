package stepDefinitions;

import configReader.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckoutInformationPage;

public class CheckoutInformationSteps {

    public CheckoutInformationPage checkoutInformationPage;
    public CheckoutInformationSteps(){
        checkoutInformationPage = new CheckoutInformationPage();
    }

    @Then("user should be redirected to checkout page")
    public void userShouldBeRedirectedToCheckoutPage() {
        Assert.assertTrue(checkoutInformationPage.verifyCheckoutPage());
    }

    @When("user enter firstname , lastname and postalcode")
    public void userEnterFirstnameLastnameAndPostalcode() {
        String firstname =  ConfigReader.getProperty("firstName");
        String lastname =  ConfigReader.getProperty("lastName");
        String postalcode = ConfigReader.getProperty("postalcode");

        checkoutInformationPage.enterDetailsAtCheckout(firstname,lastname,postalcode);
    }

    @Then("user should redirected to the checkout page")
    public void userShouldRedirectedToTheCheckoutPage() {
        checkoutInformationPage.clickContinue();
    }

}
