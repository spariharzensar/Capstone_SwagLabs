package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutInformationPage extends BasePage{
    //sindhu

    @FindBy(id="checkout")
    WebElement Checkout;

    @FindBy(id="first-name")
    WebElement firstnameInput;

    @FindBy(id="last-name")
    WebElement lastnameInput;

    @FindBy(id="postal-code")
    WebElement postalcodeInput;

    @FindBy(id="continue")
    WebElement Continue;

    //

    public boolean verifyCheckoutPage(){
        return currentUrlContains("checkout-step-one.html");
    }

    public void enterDetailsAtCheckout(String firstname, String lastname, String postalcode){
        enterText(firstnameInput, firstname);
        enterText(lastnameInput, lastname);
        enterText(postalcodeInput,postalcode);
    }
    public void  clickContinue(){
        wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();
    }

}
