package design_patterns.factory;

import design_patterns.SupportedBrowsers;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:browser.properties")
public interface Browsers extends Config {

    @ConverterClass(SupportedBrowsersConverter.class)
    @Key("browser")
    SupportedBrowsers getBrowser();
}