package design_patterns.strategy;

import org.openqa.selenium.WebDriver;

public class LocalChromeInvoker implements WebDriverInvoker {

    private static final ThreadLocal<WebDriver> DRIVER_INSTANCES = new ThreadLocal<>();

    @Override
    public WebDriver invokeWebDriver() {
        return DRIVER_INSTANCES.get();
    }
}