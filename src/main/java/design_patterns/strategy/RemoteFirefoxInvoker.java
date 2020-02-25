package design_patterns.strategy;

import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.openqa.selenium.Platform.WIN10;

public class RemoteFirefoxInvoker implements WebDriverInvoker {

    @SneakyThrows
    @Override
    public RemoteWebDriver invokeWebDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(WIN10);
        return new RemoteWebDriver(new URL("http://192.168.80.49:5556/wd/hub"), capabilities);
    }
}