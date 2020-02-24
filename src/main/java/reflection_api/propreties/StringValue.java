package reflection_api.propreties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import reflection_api.annotation.PropertyConverter;
import reflection_api.converter.Converters;

@Sources("classpath:reflectionApi.properties")
public interface StringValue extends Config{

    @PropertyConverter(converterClass = Converters.class, converterMethod = "convertMethod")
    @Key("stringValue")
    String getStringValue();
}
