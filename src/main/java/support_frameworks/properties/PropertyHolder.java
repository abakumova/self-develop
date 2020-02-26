package support_frameworks.properties;

import org.aeonbits.owner.ConfigFactory;

public class PropertyHolder {

    public static Cute cute = ConfigFactory.create(Cute.class);
    public static Calories calories = ConfigFactory.create(Calories.class);
}