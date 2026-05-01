package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    @FindBy(className = "error-button")
    private WebElement errorCloseBtn;

    @FindBy(className = "login_logo")
    private WebElement loginLogo;

    @FindBy(id = "react-burger-menu-btn")
    WebElement buttonMenu;

    @FindBy(xpath="//a[text()='Logout']")
    WebElement logout;

    public boolean validateUserOnLoginPage(){
        return currentUrlContains("saucedemo");
    }

    public void enterLoginDetails(String username, String password){
    enterText(usernameInput, username);
    enterText(passwordInput, password);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

    public String validateErrorOnLoginPage(){
        System.out.println(getText(errorMessage));
        return getText(errorMessage);
    }

    //sindhu
    public void clickMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonMenu)).click();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();

    }

}
