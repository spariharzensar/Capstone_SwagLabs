package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

//public class CheckoutOverviewPage extends basePage {
    public class CheckoutOverviewPage extends BasePage{

    @FindBy(id="finish")
    WebElement finish;

    @FindBy(id="cancel")
    WebElement cancel;

    public void  clickFinish() { wait.until(ExpectedConditions.elementToBeClickable(finish)).click();
    }

    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancel)).click();
    }


    public boolean verifyChekoutCompletePage() { return currentUrlContains("checkout-complete.html"); }

}

