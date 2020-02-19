package support_frameworks.entities.animals.inheritors;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import support_frameworks.entities.animals.Animal;
import support_frameworks.entities.enums.CuteLevel;
import support_frameworks.entities.food.EatCharacteristic;
import support_frameworks.entities.food.Feed;
import support_frameworks.entities.humans.Owner;

import java.util.Objects;

@Getter
@Setter
@Log4j2
public class Pug extends Animal {

    private CuteLevel cuteLevel;
    private Owner owner;
    private Feed feed;

    public Pug(String name, double weight) {
        super(name, weight);
        log.info("Pug was born");
    }

    @Override
    public String toString() {
        return "Pug{" +
                "cuteLevel=" + cuteLevel +
                ", owner=" + owner +
                ", feed=" + feed +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pug pug = (Pug) o;
        return cuteLevel == pug.cuteLevel &&
                owner.equals(pug.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuteLevel, owner);
    }

    public void eatFood(EatCharacteristic eatCharacteristic, Feed dailyFood) {
        if (dailyFood.getWeight() == 0.0) {
            log.warn("Pug is concerned about the lack of food");
            return;
        } else {
            dailyFood.setWeight(dailyFood.getWeight() - eatCharacteristic.getFoodIntake());
            if (dailyFood.getWeight() > 0) {
                log.info("Pug ate");
                return;
            } else {
                dailyFood.setWeight(dailyFood.getWeight() + eatCharacteristic.getFoodIntake());
                log.info("Negative value");
                return;
            }
        }
    }

    @SneakyThrows(InterruptedException.class)
    public void close() {
        log.error("Pug died");
        if (cuteLevel.equals(CuteLevel.SMALL_DOG)) {
            log.info(String.format("The master of small dog is %s in sorrow.", owner.getFirstName()));
        } else if (cuteLevel.equals(CuteLevel.MIDDLE_DOG)) {
            log.info(String.format("The master of middle dog is %s in sorrow.", owner.getFirstName()));
        } else if (cuteLevel.equals(CuteLevel.BIG_DOG)) {
            log.info(String.format("The master of big dog is %s in sorrow.", owner.getFirstName()));
        }
        throw new InterruptedException();
    }
}