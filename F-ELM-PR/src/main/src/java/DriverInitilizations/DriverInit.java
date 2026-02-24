package DriverInitilizations;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverInit {

        @BeforeEach
        public void setUp() throws MalformedURLException {
            if (PropReader.get("plaform.properties","platform").equals("android")) {
                UiAutomator2Options options = new UiAutomator2Options()
                        .setDeviceName(PropReader.get("plaform.properties","deviceName"))
                        .setPlatformName("Android")
                        .setAutomationName("UiAutomator2")
                        .setApp(System.getProperty("user.dir") + "/apps/General-Store.apk");

                AndroidDriver driver = new AndroidDriver(
                        new URL(PropReader.get("plaform.properties","appium.url")),
                        options);

                DriverFactory.setDriver(driver);
            }
        }
        @AfterEach
        public void tearDown() {
            if (DriverFactory.getDriver() != null) {
                DriverFactory.getDriver().quit();
            }
        }
    }