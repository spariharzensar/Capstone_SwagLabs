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

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    @FindBy(className = "title")
    WebElement pageTitle;

    @FindBy(className = "product_sort_container")
    WebElement sortDropdown;

    By cartBadgeAfterRemove = By.className("shopping_cart_badge");
    By removeAll = By.xpath("//button[contains(@name,'remove')]");

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
        return isElementDisappeared(cartBadgeAfterRemove);
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

    public void removeAllProductsFromTheCartIfAny(){
        while (!driver.findElements(removeAll).isEmpty()){
                driver.findElements(removeAll).getFirst().click();
        }
        }
    }