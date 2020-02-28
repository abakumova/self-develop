package design_patterns.factory;

import design_patterns.SupportedBrowsers;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public WebDriver newWebDriver() {
        SupportedBrowsers browser = ConfigFactory.create(Browsers.class).getBrowser();
        switch (browser.toString()) {
            case "REMOTE_CHROME":
                return SupportedBrowsers.REMOTE_CHROME.getWebDriver();
            case "REMOTE_FIREFOX":
                return SupportedBrowsers.REMOTE_FIREFOX.getWebDriver();
            case "LOCAL_CHROME":
                return SupportedBrowsers.LOCAL_CHROME.getWebDriver();
            default:
                return null;
        }
    }
}