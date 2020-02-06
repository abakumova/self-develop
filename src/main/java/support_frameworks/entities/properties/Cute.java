package support_frameworks.entities.properties;

import org.aeonbits.owner.Config;
import support_frameworks.entities.enums.CuteLevel;

@Config.Sources("classpath:cute.properties")
public interface Cute extends Config {

    @Key("cuteLevel")
    @ConverterClass(CuteConverter.class)
    CuteLevel getCuteLevel();
}