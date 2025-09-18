package stepdefs;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

import java.time.Duration;

public class ConverterSteps {

    private AndroidDriver driver;

    public ConverterSteps() {
        this.driver = (AndroidDriver) DriverFactory.getDriver();
    }

    // Handle popup if present
    private void dismissOldVersionPopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
            WebElement okButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.id("android:id/button1")));
            okButton.click();
            System.out.println(" Old version popup dismissed");
        } catch (Exception e) {
            System.out.println(" No old version popup displayed");
        }
    }

    // -------------------- App Launch --------------------
    @Given("the app is launched")
    public void the_app_is_launched() {
        System.out.println("App launched successfully.");
    }

    @Then("the home screen is displayed")
    public void the_home_screen_is_displayed() {
        dismissOldVersionPopup(); // dismiss popup if it appears

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("com.androiddev2015.cfconverter:id/editTextC")));
    }

    // -------------------- Celsius → Fahrenheit --------------------
    @When("I enter {string} in the Celsius field")
    public void i_enter_in_the_celsius_field(String value) {
        WebElement celsiusField = driver.findElement(By.id("com.androiddev2015.cfconverter:id/editTextC"));
        celsiusField.clear();
        celsiusField.sendKeys(value);
    }

    @When("I tap on the Convert button")
    public void i_tap_on_the_convert_button() {
        WebElement convertButton = driver.findElement(By.id("com.androiddev2015.cfconverter:id/btncnvCF"));
        convertButton.click();
    }

    @Then("I should see the Fahrenheit result {string}")
    public void i_should_see_the_fahrenheit_result(String expectedValue) {
        WebElement fahrenheitField = driver.findElement(By.id("com.androiddev2015.cfconverter:id/editTextF"));
        String actualValue = fahrenheitField.getText();
        if (!actualValue.equals(expectedValue)) {
            throw new AssertionError("Expected: " + expectedValue + " but found: " + actualValue);
        }
    }

    @When("I clear the Celsius field")
    public void i_clear_the_celsius_field() {
        WebElement celsiusField = driver.findElement(By.id("com.androiddev2015.cfconverter:id/editTextC"));
        celsiusField.clear();
    }

    // -------------------- Fahrenheit → Celsius --------------------
    @When("I enter {string} in the Fahrenheit field")
    public void i_enter_in_the_fahrenheit_field(String value) {
        WebElement fahrenheitField = driver.findElement(By.id("com.androiddev2015.cfconverter:id/editTextF"));
        fahrenheitField.clear();
        fahrenheitField.sendKeys(value);
    }

    @When("I tap on the Convert F-C button")
    public void i_tap_on_the_convert_fc_button() {
        WebElement convertFCButton = driver.findElement(By.id("com.androiddev2015.cfconverter:id/btncnvFC"));
        convertFCButton.click();
    }

    @Then("I should see the Celsius result {string}")
    public void i_should_see_the_celsius_result(String expectedValue) {
        WebElement celsiusField = driver.findElement(By.id("com.androiddev2015.cfconverter:id/editTextC"));
        String actualValue = celsiusField.getText();
        if (!actualValue.equals(expectedValue)) {
            throw new AssertionError("Expected: " + expectedValue + " but found: " + actualValue);
        }
    }

    @When("I clear the Fahrenheit field")
    public void i_clear_the_fahrenheit_field() {
        WebElement fahrenheitField = driver.findElement(By.id("com.androiddev2015.cfconverter:id/editTextF"));
        fahrenheitField.clear();
    }

    // -------------------- Reset Button --------------------
    @When("I tap on the Reset button")
    public void i_tap_on_the_reset_button() {
        WebElement resetButton = driver.findElement(By.id("com.androiddev2015.cfconverter:id/btnreset"));
        resetButton.click();
        System.out.println(" Reset button clicked");
    }

   @Then("both fields should be cleared")
public void both_fields_should_be_cleared() {
    String celsiusValue = driver.findElement(By.id("com.androiddev2015.cfconverter:id/editTextC")).getText();
    String fahrenheitValue = driver.findElement(By.id("com.androiddev2015.cfconverter:id/editTextF")).getText();

    if (!(celsiusValue.equals("") || celsiusValue.equals("0")) ||
        !(fahrenheitValue.equals("") || fahrenheitValue.equals("0"))) {
        throw new AssertionError("Fields were not cleared properly. Celsius: '" + celsiusValue +
                "', Fahrenheit: '" + fahrenheitValue + "'");
    }
    System.out.println("✅ Both fields cleared (reset to empty or 0).");
}
}
