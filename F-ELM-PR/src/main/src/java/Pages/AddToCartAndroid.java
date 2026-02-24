package Pages;

import DriverInitilizations.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import DriverInitilizations.PropReader;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToCartAndroid extends AddToCartAbstract {
    AndroidDriver driver;

    public AddToCartAndroid() {
        this.driver = DriverFactory.getDriver();
    }

    By countryList = By.id("com.androidsample.generalstore:id/spinnerCountry");
    By nameField = By.id("com.androidsample.generalstore:id/nameField");
    By gender = By.id("com.androidsample.generalstore:id/radioFemale");
    By letsShopBtn = By.id("com.androidsample.generalstore:id/btnLetsShop");
    By shopTitle = By.id("com.androidsample.generalstore:id/toolbar_title");
    By listItems = By.id("com.androidsample.generalstore:id/productName");
    By cartIcon = By.id("com.androidsample.generalstore:id/counterText");

    @Override
    public void addGuestData() {
        driver.findElement(countryList).click();
        driver.findElement(getDynamicXpath(PropReader.get("env.properties", "country")));
        driver.findElement(nameField).sendKeys(PropReader.get("env.properties", "name"));
        driver.findElement(gender).click();
        driver.findElement(letsShopBtn).click();
        assertEquals("Products", driver.findElement(shopTitle).getText());
    }

    @Override
    public void addProductToCart() {
        List<WebElement> productTitle = driver.findElements(listItems);
        for (int i = 1; i < productTitle.size(); i++) {
            if (productTitle.get(i).getText().equals(PropReader.get("env.properties", "productName"))) {
                driver.findElement(getDynamicXpathByIndex(i)).click();
            }
        }

    }

    @Override
    public void validateCartContent() {
        driver.findElement(cartIcon).click();
        assertTrue(driver.findElement(getDynamicXpath(PropReader.get("env.properties", "productName"))).isDisplayed());
    }


    public By getDynamicXpath(String country) {
        By countryOption = By.xpath(
                "//android.widget.TextView[@text='" + country + "']"
        );
        return countryOption;
    }

    public By getDynamicXpathByIndex(int index) {
        By addToCartBtn = By.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])["+index+"]");
        return addToCartBtn;
    }
}

