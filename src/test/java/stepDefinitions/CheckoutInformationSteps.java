package stepDefinitions;

import configReader.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckoutInformationPage;

public class CheckoutInformationSteps {

    public CheckoutInformationPage checkoutInformationPage;

    public CheckoutInformationSteps() {
        checkoutInformationPage = new CheckoutInformationPage();
    }

    @Then("user should be redirected to checkout page")
    public void userShouldBeRedirectedToCheckoutPage() {
        Assert.assertTrue(checkoutInformationPage.verifyCheckoutPage());
    }

    @Then("user should redirected to the checkout page")
    public void userShouldRedirectedToTheCheckoutPage() {
        checkoutInformationPage.clickContinue();
    }

    @When("user enters firstname, lastname and postalcode")
    public void userEntersFirstnameLastnameAndPostalcode() {
        String firstname = ConfigReader.getProperty("firstName");
        String lastname = ConfigReader.getProperty("lastName");
        String postalcode = ConfigReader.getProperty("postalcode");

        checkoutInformationPage.enterDetailsAtCheckout(firstname, lastname, postalcode);
    }


    @And("clicks on Continue")
    public void clicksOnContinue() {
        checkoutInformationPage.clickContinue();
    }

    @Then("user should be redirected to the checkoutOverview Page")
    public void userShouldBeRedirectedToTheCheckoutOverviewPage() {
        Assert.assertTrue(checkoutInformationPage.verifyChekoutOverviewPage());
    }

    @When("user enters only firstname")
    public void userEntersOnlyFirstname() {
        String firstname = ConfigReader.getProperty("firstName");


        checkoutInformationPage.enterOnlyFirstName(firstname);
    }


    @When("user enters only lastname")
    public void userEntersOnlyLastname() {
        String lastname = ConfigReader.getProperty("lastName");
        checkoutInformationPage.enterOnlyLastName(lastname);
    }

    @When("user enters only postalcode")
    public void userEntersOnlyPostalcode() {
        String postalcode = ConfigReader.getProperty("postalcode");
        checkoutInformationPage.enterOnlyPostalCode(postalcode);
    }

    @When("user enters only firstname and lastname")
    public void userEntersOnlyFirstnameAndLastname() {
        String firstname = ConfigReader.getProperty("firstName");
        String lastname = ConfigReader.getProperty("lastName");
        checkoutInformationPage.enterOnlyFirstNameLastName(firstname,lastname);
    }

    @When("user enters only firstname and postalcode")
    public void userEntersOnlyFirstnameAndPostalcode() {
        String firstname = ConfigReader.getProperty("firstName");
        String postalcode = ConfigReader.getProperty("postalcode");
        checkoutInformationPage.enterOnlyFirstNamePostalCode(firstname,postalcode);
    }

    @When("user enters only lastname and postalcode")
    public void userEntersOnlyLastnameAndPostalcode() {
        String lastname = ConfigReader.getProperty("lastName");
        String postalcode = ConfigReader.getProperty("postalcode");
        checkoutInformationPage.enterOnlyLastNamePostalCode(lastname,postalcode);
    }
}

