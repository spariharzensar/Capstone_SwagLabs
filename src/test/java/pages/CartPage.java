package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{

    // ======= LOCATORS =======

    @FindBy(className = "title")
    WebElement cartTitle;

    @FindBy(className = "cart_item")
    List<WebElement> cartItems;

    @FindBy(className = "inventory_item_name")
    List<WebElement> itemNames;

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPrices;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    List<WebElement> removeButtons;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingBtn;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    // ======= ACTION METHODS =======

    public String getCartTitle() {
        return cartTitle.getText();
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public List<String> getAllItemNames() {
        List<String> items = new ArrayList<>();
        for(WebElement c : itemNames){
            items.add(c.getText());
        }
        return items;
    }

    public void removeItemByName(String itemName) {
        for (int i = 0; i < itemNames.size(); i++) {
            if (itemNames.get(i).getText().equalsIgnoreCase(itemName)) {
                removeButtons.get(i).click();
                break;
            }
        }
    }

    public void clickContinueShopping() {
        click(continueShoppingBtn);
    }

    public void clickCheckout() {
        click(checkoutBtn);
    }

    public boolean isItemPresent(String itemName) {
        for (WebElement item : itemNames) {
            if (item.getText().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public String getItemPrice(String itemName) {
        for (int i = 0; i < itemNames.size(); i++) {
            if (itemNames.get(i).getText().equalsIgnoreCase(itemName)) {
                return itemPrices.get(i).getText();
            }
        }
        return "";
    }

    public void removeAllItems() {
        for (WebElement btn : removeButtons) {
            btn.click();
        }
    }

    public int getCartBadgeCount() {
        try {
            return Integer.parseInt(cartBadge.getText());
        } catch (Exception e) {
            return 0; // if badge not visible
        }
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

}
