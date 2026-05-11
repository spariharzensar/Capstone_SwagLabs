package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletePage extends BasePage{
@FindBy(id="back-to-products")
    WebElement backHome;

    public void  clickBackHome(){
        wait.until(ExpectedConditions.elementToBeClickable(backHome)).click();
    }

}
