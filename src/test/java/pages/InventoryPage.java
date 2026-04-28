package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    WebElement buttonMenu;

    @FindBy(xpath="//a[text()='Logout']")
    WebElement logout;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    @FindBy(className = "title")
    WebElement pageTitle;

    @FindBy(className = "product_sort_container")
    WebElement sortDropdown;

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


    @FindBy(className = "inventory_item")
    List<WebElement> products;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;

    @FindBy(className = "inventory_item_price")
    List<WebElement> productPrices;


    public WebElement addToCartButton(String productName) {
        return driver.findElement(By.xpath(
                "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button"
        ));
    }

    public boolean validateUserIsOnProductsPage() {
        return currentUrlContains("inventory") &&
                getText(pageTitle).equals("Products");
    }

    public boolean validateProductsAreVisible(int numProducts) {
        return products.size() == numProducts;
    }

    public boolean validateProductDetails(int numProducts) {
        return productNames.size() == numProducts &&
                productPrices.size() == numProducts;
    }


    public boolean validateProductAddedToCart() {
        return isElementDisplayed(cartBadge);
    }

    public int validateCartBadge() {
        return Integer.parseInt(getText(cartBadge));
    }

    public boolean validateProductRemoved() {
        return isElementDisappeared(cartBadge);
    }

    public boolean validateProductDetailPage() {
        return currentUrlContains("inventory-item");
    }

    public boolean validateCartPage() {
        return currentUrlContains("cart");
    }

    public void addProductToCart(String productName) {
        addToCartButton(productName).click();
    }

    public void removeProductFromCart(String productName) {
        addToCartButton(productName).click();
    }

    public void clickProduct(String productName) {
        driver.findElement(By.xpath("//div[text()='" + productName + "']")).click();
    }

    public void clickCart() {
        cartIcon.click();
    }
//sindhu
    public void clickMenu(){
         wait.until(ExpectedConditions.elementToBeClickable(buttonMenu)).click();
        }

        public void clickLogout() {
            wait.until(ExpectedConditions.elementToBeClickable(logout)).click();

    }
    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(Checkout)).click();

    }
    public void enterDetailsAtCheckout(String firstname, String lastname, String postalcode){
        enterText(firstnameInput, firstname);
        enterText(lastnameInput, lastname);
        enterText(postalcodeInput,postalcode);
    }
    public void  clickContinue(){
        wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();
    }
//sindhu

    public void sortBy(String option) {
        selectByVisibleText(sortDropdown, option);
    }

    public boolean validateSortByName() {
        List<String> actual = new ArrayList<>();
        for (WebElement e : productNames) {
            actual.add(e.getText());
        }

        List<String> sorted = new ArrayList<>(actual);
        Collections.sort(sorted);

        return actual.equals(sorted);
    }

    public boolean validateSortByPrice() {
        List<Double> actual = new ArrayList<>();

        for (WebElement e : productPrices) {
            actual.add(Double.parseDouble(e.getText().replace("$", "")));
        }

        List<Double> sorted = new ArrayList<>(actual);
        Collections.sort(sorted);

        return actual.equals(sorted);
    }
}