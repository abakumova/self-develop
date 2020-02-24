package reflection_api.proxy;

import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.Config;
import reflection_api.annotation.PropertyConverter;
import reflection_api.converter.PropertyConverterHandler;
import reflection_api.converter.PropertyConverterMetadata;
import reflection_api.propreties.StringValue;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Log4j2
public class DynamicProxy {

    private DynamicProxy(){}

    public static <T extends Config> T getProxy(Class<? extends T> clazz, final T createdProxy) {
        log.info("getProxy - dynamic proxy was created");
        final PropertyConverterMetadata metadata = new PropertyConverterHandler().process(StringValue.class);

        Object proxy = Proxy.newProxyInstance(createdProxy.getClass().getClassLoader(), new Class<?>[]{clazz}, (proxy1, method, args) -> {
            try {
                if (method.isAnnotationPresent(PropertyConverter.class)) {
                    Class convertClass = metadata.getConverterClass();
                    Method concertMethod = convertClass.getMethod(metadata.getConverterMethod(), String.class);
                    return concertMethod.invoke(Class.forName(convertClass.getName()).getDeclaredConstructor().newInstance(), method.invoke(createdProxy));
                } else {
                    return method.invoke(createdProxy);
                }
            } catch (Exception e) {
                log.warn(String.format("Error using reflection %s", e.getMessage()));
            }
            return null;
        });
        return (T) proxy;
    }
}