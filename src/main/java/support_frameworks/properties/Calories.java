package support_frameworks.properties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:calories.properties")
public interface Calories extends Config {

    @DefaultValue("45")
    @Key("calories")
    int getCaloriesValue();
}