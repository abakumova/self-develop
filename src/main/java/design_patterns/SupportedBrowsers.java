package design_patterns;

import design_patterns.strategy.LocalChromeInvoker;
import design_patterns.strategy.RemoteChromeInvoker;
import design_patterns.strategy.RemoteFirefoxInvoker;
import design_patterns.strategy.WebDriverInvoker;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public enum SupportedBrowsers {
    REMOTE_CHROME(new RemoteChromeInvoker()) {
        public WebDriver getWebDriver() {
            return new RemoteChromeInvoker().invokeWebDriver();
        }
    },
    REMOTE_FIREFOX(new RemoteFirefoxInvoker()) {
        public WebDriver getWebDriver() {
            return new RemoteFirefoxInvoker().invokeWebDriver();
        }
    },
    LOCAL_CHROME(new LocalChromeInvoker()) {
        public WebDriver getWebDriver() {
            return new LocalChromeInvoker().invokeWebDriver();
        }
    };

    SupportedBrowsers(WebDriverInvoker webDriverInvoker) {
    }

    public WebDriver getWebDriver() {
        return null;
    }
}