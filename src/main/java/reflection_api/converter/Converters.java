package reflection_api.converter;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Converters {

    public String convertMethod(String s) {
        log.info("convertMethod(String s) - the place where converting of the property value is done");
        return s.toUpperCase();
    }
}