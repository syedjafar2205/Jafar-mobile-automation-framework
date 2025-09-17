package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class DriverFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "emulator-5554");
                caps.setCapability("automationName", "UiAutomator2");
                caps.setCapability("app", System.getProperty("user.dir") + "/app/Celsius Fahrenheit Converter_v1.0.1_apkpure.com.apk");
                caps.setCapability("newCommandTimeout", 300);
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create Appium driver", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
