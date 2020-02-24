package reflection_api.converter;

import lombok.extern.log4j.Log4j2;
import reflection_api.annotation.PropertyConverter;
import reflection_api.proxy.RuntimeHandler;

import java.lang.reflect.Method;

@Log4j2
public class PropertyConverterHandler implements RuntimeHandler {

    @Override
    public PropertyConverterMetadata process(Object parameter) {
        log.info("PropertyConverterHandler - handler of the custom annotation");
        PropertyConverter annotation;

        for (Method method : ((Class) parameter).getMethods()) {
            if (method.isAnnotationPresent(PropertyConverter.class)) {
                annotation = method.getAnnotation(PropertyConverter.class);
                return new PropertyConverterMetadata(annotation.converterClass(), annotation.converterMethod());
            }
        }
        return null;
    }
}