package reflection_api.propreties;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Factory;
import org.aeonbits.owner.loaders.Loader;
import reflection_api.proxy.DynamicProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;

@Log4j2
public class PropertyFactory {

    PropertyFactory propertyFactory;

    {
        try {
            propertyFactory = (PropertyFactory) Class.forName(ConfigFactory.class.getName())
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }

    public static Factory newInstance() {
        return ConfigFactory.newInstance();
    }

    public static <T extends Config> T create(Class<? extends T> clazz, Map<?, ?>... imports) {
        return ConfigFactory.create(clazz, imports);
    }

    public static String setProperty(String key, String value) {
        return ConfigFactory.setProperty(key, value);
    }

    public static Properties getProperties() {
        return ConfigFactory.getProperties();
    }

    public static void setProperties(Properties properties) {
        ConfigFactory.setProperties(properties);
    }

    public static String getProperty(String key) {
        return ConfigFactory.getProperty(key);
    }

    public static String clearProperty(String key) {
        return ConfigFactory.clearProperty(key);
    }

    public static void registerLoader(Loader loader) {
        ConfigFactory.registerLoader(loader);
    }

    public static <T extends Config> Object createProperty(Class<? extends T> clazz) {
        log.info("the logic of creating an object to work with the perpendicular file is determined and our annotation is processed");
        return DynamicProxy.getProxy(clazz,create(clazz));
    }

    @SneakyThrows
    public void removeAnnotationFromMethod(Method annotatedMethod, Class<? extends Annotation> annotationType) {
        boolean annotatedMethodAccessible;
        boolean annotationsFieldAccessible;

        annotatedMethodAccessible = annotatedMethod.isAccessible();
        annotatedMethod.setAccessible(true);
        annotatedMethod.getDeclaredAnnotations();

        Field annotations = annotatedMethod.getClass().getSuperclass().getDeclaredField("declaredAnnotations");
        annotationsFieldAccessible = annotations.isAccessible();
        annotations.setAccessible(true);

        ((Map<Class<? extends Annotation>, Annotation>) annotations.get(annotatedMethod)).remove(annotationType);

        annotations.setAccessible(annotationsFieldAccessible);
        annotatedMethod.setAccessible(annotatedMethodAccessible);
    }
}