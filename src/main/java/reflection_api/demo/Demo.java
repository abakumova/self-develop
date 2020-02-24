package reflection_api.demo;

import reflection_api.propreties.PropertyFactory;
import reflection_api.propreties.StringValue;

public class Demo {

    public static void main(String[] args) {
        StringValue propertyFile = (StringValue) PropertyFactory.createProperty(StringValue.class);
        System.out.println("Converted value: " +  propertyFile.getStringValue());
    }
}