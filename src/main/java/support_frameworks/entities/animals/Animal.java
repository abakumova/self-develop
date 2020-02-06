package support_frameworks.entities.animals;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

@Getter
public abstract class Animal {

    @ToString.Include
    private String name;
    @Setter @ToStringExclude
    private double weight;

    protected Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
}