package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConverterPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public ConverterPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Always check popup
    public void dismissOldVersionPopup() {
        try {
            WebElement okBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1"))
            );
            okBtn.click();
            System.out.println("Old version popup dismissed");
        } catch (Exception e) {
            System.out.println("No popup found, continuing...");
        }
    }

    // ✅ Celsius field
    public void enterCelsius(String value) {
        WebElement celsiusInput = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.id("com.androiddev2015.cfconverter:id/editTextC")
            )
        );
        celsiusInput.clear();
        celsiusInput.sendKeys(value);
    }

    // ✅ Fahrenheit field
    public String getFahrenheitValue() {
        WebElement fahrenheitInput = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.id("com.androiddev2015.cfconverter:id/editTextF")
            )
        );
        return fahrenheitInput.getText();
    }

    // ✅ Buttons
    public void tapConvertCtoF() {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.id("com.androiddev2015.cfconverter:id/btncnvCF")
        )).click();
    }

    public void tapConvertFtoC() {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.id("com.androiddev2015.cfconverter:id/btncnvFC")
        )).click();
    }

    public void tapReset() {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.id("com.androiddev2015.cfconverter:id/btnreset")
        )).click();
    }
}
