package design_patterns;

import design_patterns.factory.Browsers;
import design_patterns.factory.WebDriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

    @Test
    public void checkGettingBrowserValueFromPropertyFileForFactoryMethod() { 
        SupportedBrowsers browser = ConfigFactory.create(Browsers.class).getBrowser();
        Assert.assertEquals(browser.toString(), "LOCAL_CHROME");
    }

    @Test
    public void checkGettingWebDriver(){
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        WebDriver webDriver = webDriverFactory.newWebDriver();
        Assert.assertEquals(SupportedBrowsers.LOCAL_CHROME.getWebDriver(), webDriver);
    }
}