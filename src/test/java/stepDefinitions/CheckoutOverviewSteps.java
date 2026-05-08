package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckoutOverviewPage;

public class CheckoutOverviewSteps {
    CheckoutOverviewPage checkoutOverviewPage;

    public CheckoutOverviewSteps(){
        checkoutOverviewPage = new CheckoutOverviewPage();
    }



    @When("user clicks on Finish")
    public void userClicksOnFinish() {
        checkoutOverviewPage.clickFinish();
    }

    @Then("user should be redirected to checkout complete page")
    public void userShouldBeRedirectedToCheckoutCompletePage() {
        Assert.assertTrue(checkoutOverviewPage.verifyChekoutCompletePage());

    }


    @When("user clicks on Cancel")
    public void userClicksOnCancel() {
        checkoutOverviewPage.clickCancel();
    }

}
