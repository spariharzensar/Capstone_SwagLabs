package pages;

import base.DriverSetup;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    Alert alert;

    public BasePage() {
        this.driver = DriverSetup.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisappeared(By element) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

        } catch (TimeoutException e) {
            return false;
        }
    }

        public boolean currentUrlContains(String value) {
        return driver.getCurrentUrl() != null && driver.getCurrentUrl().toLowerCase().contains(value.toLowerCase());
    }

    public void selectByVisibleText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void acceptAlertIfPresent(){
        try {
            alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        }
        catch(Exception e){
            System.out.println("No Alert Present");
        }
    }

}
