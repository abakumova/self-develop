package design_patterns.strategy;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.openqa.selenium.Platform.WIN10;

public class RemoteChromeInvoker implements WebDriverInvoker {

    @SneakyThrows
    @Override
    public WebDriver invokeWebDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(WIN10);
        return new RemoteWebDriver(new URL("http://192.168.80.49:5558/wd/hub"), capabilities);
    }
}