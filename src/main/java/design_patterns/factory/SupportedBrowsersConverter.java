package design_patterns.factory;

import design_patterns.SupportedBrowsers;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class SupportedBrowsersConverter implements Converter {

    @Override
    public SupportedBrowsers convert(Method method, String s) {
        return SupportedBrowsers.valueOf(s.toUpperCase());
    }
}