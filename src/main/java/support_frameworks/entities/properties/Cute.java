package support_frameworks.entities.properties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import support_frameworks.entities.enums.CuteLevel;

@Sources("classpath:cute.properties")
public interface Cute extends Config {

    @Key("cuteLevel")
    @ConverterClass(CuteConverter.class)
    CuteLevel getCuteLevel();
}