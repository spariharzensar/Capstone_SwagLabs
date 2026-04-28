package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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




}
