package stepdefs;

import DriverInitilizations.PropReader;
import Pages.AddToCartAbstract;
import Pages.AddToCartAndroid;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import DriverInitilizations.PropReader;


public class AddToCartStepdef{
    private AddToCartAbstract addToCartAbstract;

    public AddToCartStepdef() {
        String platform = PropReader.get("platform.properties", "platform");

        if (platform.equalsIgnoreCase("android")) {
            addToCartAbstract = new AddToCartAndroid();
        }
    }

    @Given("I enter guest data")
    public void iEnterGuestData() {
        addToCartAbstract.addGuestData();

    }

    @And("add a product to cart")
    public void addProductToCard() {

    }

    @Then("I validate the added product is displayed in the cart")
    public void validateProductDisplayed() {

    }

}
