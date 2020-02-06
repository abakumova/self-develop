package support_frameworks.entities.properties;

import org.aeonbits.owner.Converter;
import support_frameworks.entities.enums.CuteLevel;

import java.lang.reflect.Method;

public class CuteConverter implements Converter<CuteLevel> {

    @Override
    public CuteLevel convert(Method method, String s) {
        return CuteLevel.valueOf(s.toUpperCase());
    }
}