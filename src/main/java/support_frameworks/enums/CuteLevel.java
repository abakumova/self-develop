package support_frameworks.enums;

import org.apache.commons.lang3.StringUtils;

public enum CuteLevel {
    SMALL_DOG,
    MIDDLE_DOG,
    BIG_DOG;

    @Override
    public String toString() {
        String s = StringUtils.replaceChars(super.name(), '_', ' ');
        s = StringUtils.lowerCase(s);
        return StringUtils.capitalize(s);
    }
}