package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;
import org.testng.annotations.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;

    public static final String username = "rajeshwarim2@hexaware.com";
    public static final String accesskey = "927438";

    @Parameters({"browser", "version", "platform"})
    @BeforeMethod
    public void setup(String browser, String version, String platform) throws Exception {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserName", browser);
        caps.setCapability("browserVersion", version);

        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("platformName", platform);
        ltOptions.put("build", "Selenium101-Certification");
        ltOptions.put("name", "LambdaTest Selenium 101 Automation");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("video", true);
        ltOptions.put("visual", true);
        ltOptions.put("network", true);
        ltOptions.put("console", "true");

        caps.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(new URL(
                "https://" + username + ":" + accesskey + "@hub.lambdatest.com/wd/hub"), caps);

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
