package support_frameworks.entities.enums;

import org.apache.commons.lang3.builder.ToStringBuilder;

public enum CuteLevel {
    SMALL_DOG,
    MIDDLE_DOG,
    BIG_DOG;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .toString();
    }
}