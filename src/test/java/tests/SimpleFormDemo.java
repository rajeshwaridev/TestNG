package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseTest;

public class SimpleFormDemo extends BaseTest {

    @Test
    public void testSimpleFormDemo() {
        driver.get("https://www.lambdatest.com/selenium-playground");
        driver.findElement(By.linkText("Simple Form Demo")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("simple-form-demo"));

        String message = "Welcome to LambdaTest";
        driver.findElement(By.id("user-message")).sendKeys(message);
        driver.findElement(By.id("showInput")).click();

        String output = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(output, message);
    }
}
