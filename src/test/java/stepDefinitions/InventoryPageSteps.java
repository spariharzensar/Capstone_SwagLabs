package stepDefinitions;

import configReader.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryPageSteps {
    InventoryPage inventoryPage;
    public InventoryPageSteps(){
       inventoryPage = new InventoryPage();
    }

    @Then("user should be redirected to the inventory page")
    public void userShouldRedirectedToInventoryPage() {

        Assert.assertTrue(inventoryPage.validateUserIsOnProductsPage(),
                "User in not on the product inventory page");
    }

    @Then("all {int} products should be visible")
    public void allProductsShouldBeVisible(int numberOfProducts) {
        Assert.assertTrue(inventoryPage.validateProductsAreVisible(numberOfProducts),
                "Products are not visible");
    }

    @Then("all {int} products should display name and price details")
    public void validateProductDetails(int numberOfProducts) {
        Assert.assertTrue(inventoryPage.validateProductDetails(numberOfProducts),
                "Product details are missing");
    }

    @When("user clicks on Add to Cart button for {string} product")
    public void userAddsProductToCart(String productName) {
        inventoryPage.addProductToCart(productName);
    }

    @Then("the product should be added to the cart")
    public void productShouldBeAddedToCart() {
        Assert.assertTrue(inventoryPage.validateProductAddedToCart(),
                "Product not added to cart");
    }

    @Then("cart badge count should be updated to {int}")
    public void cartBadgeShouldBeUpdated(int expected) {
        int actual = inventoryPage.validateCartBadge();
        Assert.assertEquals(actual, expected, "Cart badge not updated");
    }

    @When("user clicks on Remove button for {string} product")
    public void userRemovesProduct(String productName) {
        inventoryPage.removeProductFromCart(productName);
    }

    @Then("product should be removed from the cart")
    public void productShouldBeRemoved() {
        Assert.assertTrue(inventoryPage.validateProductRemoved(),
                "Product not removed from cart");
    }

    @When("user clicks on {string} product")
    public void userClicksOnProductName(String productName) {
        inventoryPage.clickProduct(productName);
    }

    @Then("user should be navigated to the product detail page")
    public void userNavigatedToProductDetailPage() {
        Assert.assertTrue(inventoryPage.validateProductDetailPage(),
                "User not on product detail page");
    }

    @When("user selects {string} from sort dropdown")
    public void userSortsProducts(String option) {
        inventoryPage.sortBy(option);
    }

    @Then("products should be sorted in ascending alphabetical order")
    public void validateSortingByName() {
        Assert.assertTrue(inventoryPage.validateSortByName(),
                "Products are not sorted by name");
    }

    @Then("products should be sorted in ascending price order")
    public void validateSortingByPrice() {
        Assert.assertTrue(inventoryPage.validateSortByPrice(),
                "Products are not sorted by price");
    }

    @When("user clicks on the cart icon")
    public void userClicksCartIcon() {
        inventoryPage.clickCart();
    }

    @Then("user should be redirected to the cart page")
    public void userRedirectedToCartPage() {
        Assert.assertTrue(inventoryPage.validateCartPage(),
                "User not redirected to cart page");
    }
//sindhu
    @When("user clicks on the menu button on the left")
    public void userClicksOnTheMenuButtonOnTheLeft(){
        inventoryPage.clickMenu();

    }

    @Then("user clicks on the logout button and successfully loggedout")
    public void userClicksOnTheLogoutButtonAndSuccessfullyLoggedout() {

        inventoryPage.clickLogout();
    }

    @When("user enter firstname , lastname and postalcode")
    public void userEnterFirstnameLastnameAndPostalcode() {
        String firstname =  ConfigReader.getProperty("firstName");
        String lastname =  ConfigReader.getProperty("lastName");
        String postalcode = ConfigReader.getProperty("postalcode");

        inventoryPage.enterDetailsAtCheckout(firstname,lastname,postalcode);
    }

    @Then("user should redirected to the checkout page")
    public void userShouldRedirectedToTheCheckoutPage() {
        inventoryPage.clickContinue();
    }

    @When("user clicks on checkout")
    public void userClicksOnCheckout() {
        inventoryPage.clickCheckout();

    }
}
