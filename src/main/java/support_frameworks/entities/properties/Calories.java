package support_frameworks.entities.properties;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:calories.properties")
public interface Calories extends Config {

    @DefaultValue("45")
    @Key("calories")
    int getCaloriesValue();
}