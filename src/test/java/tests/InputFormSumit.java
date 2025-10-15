package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseTest;

public class InputFormSubmit extends BaseTest {

    @Test
    public void testFormSubmission() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground");
        driver.findElement(By.linkText("Input Form Submit")).click();

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        String validationMessage = driver.findElement(By.id("name")).getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.contains("Please fill out this field"));

        driver.findElement(By.id("name")).sendKeys("Amirthaa G");
        driver.findElement(By.id("inputEmail4")).sendKeys("amirthaa@example.com");
        driver.findElement(By.id("inputPassword4")).sendKeys("Test@123");
        driver.findElement(By.id("company")).sendKeys("My Company");
        driver.findElement(By.id("websitename")).sendKeys("https://example.com");

        Select country = new Select(driver.findElement(By.name("country")));
        country.selectByVisibleText("United States");

        driver.findElement(By.id("inputCity")).sendKeys("New York");
        driver.findElement(By.id("inputAddress1")).sendKeys("123 Main Street");
        driver.findElement(By.id("inputAddress2")).sendKeys("Apt 5");
        driver.findElement(By.id("inputState")).sendKeys("NY");
        driver.findElement(By.id("inputZip")).sendKeys("10001");

        submit.click();
        Thread.sleep(2000);

        WebElement success = driver.findElement(By.xpath("//p[contains(text(),'Thanks for contacting us')]"));
        Assert.assertTrue(success.isDisplayed());
    }
}
