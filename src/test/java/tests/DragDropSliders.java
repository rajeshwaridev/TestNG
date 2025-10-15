package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseTest;

public class DragDropSliders extends BaseTest {

    @Test
    public void testSliderValue() {
        driver.get("https://www.lambdatest.com/selenium-playground");
        driver.findElement(By.linkText("Drag & Drop Sliders")).click();

        WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
        WebElement rangeValue = driver.findElement(By.id("rangeSuccess"));

        Actions act = new Actions(driver);
        while (!rangeValue.getText().equals("95")) {
            act.dragAndDropBy(slider, 10, 0).perform();
        }

        Assert.assertEquals(rangeValue.getText(), "95");
    }
}
