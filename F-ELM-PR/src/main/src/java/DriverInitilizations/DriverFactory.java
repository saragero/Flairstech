package DriverInitilizations;
import io.appium.java_client.android.AndroidDriver;


public class DriverFactory {
        private static AndroidDriver driver;

        public static AndroidDriver getDriver() {
            return driver;
        }

        public static void setDriver(AndroidDriver driverInstance) {
            driver = driverInstance;
        }
    }
