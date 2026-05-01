package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;

import static base.DriverSetup.driver;

public class CartPageSteps {

    public CartPage cartPage;

    public CartPageSteps(){
        cartPage = new CartPage();
    }

    @Then("cart page title should be {string}")
    public void verify_cart_title(String expectedTitle) {
        Assert.assertEquals(expectedTitle, cartPage.getCartTitle());
    }

    @Then("cart should contain item {string}")
    public void verify_item_present(String itemName) {
        Assert.assertTrue(cartPage.isItemPresent(itemName));
    }

    @Then("item {string} should have a valid price")
    public void verify_item_price(String itemName) {
        Assert.assertTrue(cartPage.getItemPrice(itemName).startsWith("$"));
    }

    @When("user removes item {string}")
    public void remove_item(String itemName) {
        cartPage.removeItemByName(itemName);
    }

    @Then("cart should not contain item {string}")
    public void verify_item_not_present(String itemName) {
        Assert.assertFalse(cartPage.isItemPresent(itemName));
    }

    @Then("cart item count should be {int}")
    public void verify_item_count(int count) {
        Assert.assertEquals(count, cartPage.getCartItemCount());
    }

    @When("user clicks on continue shopping")
    public void click_continue_shopping() {
        cartPage.clickContinueShopping();
    }

    @When("user clicks on checkout")
    public void click_checkout() {
        cartPage.clickCheckout();
    }

    @When("user removes all items")
    public void remove_all_items() {
        cartPage.removeAllItems();
    }

    @Then("cart should be empty")
    public void verify_cart_empty() {
        Assert.assertEquals(cartPage.getCartItemCount(), 0);
    }

    @Then("cart badge should show {int}")
    public void verify_cart_badge(int expected) {
        Assert.assertEquals(cartPage.getCartBadgeCount(), expected);
    }

    @When("user refreshes the page")
    public void refreshThePage() {
        cartPage.refreshPage();
    }

}
