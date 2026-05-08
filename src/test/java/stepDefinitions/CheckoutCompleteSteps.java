package stepDefinitions;

import io.cucumber.java.en.When;
import pages.CheckoutCompletePage;

public class CheckoutCompleteSteps {

    public CheckoutCompletePage checkoutCompletePage;
    public CheckoutCompleteSteps(){
        checkoutCompletePage = new pages.CheckoutCompletePage();
    }


@When("user clicks on BackHome")
    public void userClicksOnBackHome() {
 checkoutCompletePage.clickBackHome();

    }
}
