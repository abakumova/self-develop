package support_frameworks.entities.animals.inheritors;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import support_frameworks.entities.animals.Animal;
import support_frameworks.entities.enums.CuteLevel;
import support_frameworks.entities.food.EatCharacteristic;
import support_frameworks.entities.food.Feed;
import support_frameworks.entities.humans.Owner;

import java.util.Objects;

@Getter
@Setter
public class Pug extends Animal {

    private static final Logger logger = LogManager.getLogger(Pug.class);

    private CuteLevel cuteLevel;
    private Owner owner;
    private Feed feed;

    public Pug(String name, double weight) {
        super(name, weight);
        logger.info("Pug was born");
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
        //Feed dailyFood = getFeed();
        if (dailyFood.getWeight() == 0.0) {
            logger.warn("Pug is concerned about the lack of food");
            return;
        } else {
            dailyFood.setWeight(dailyFood.getWeight() - eatCharacteristic.getFoodIntake());
            if (dailyFood.getWeight() > 0) {
                logger.info("Pug ate");
                return;
            } else {
                dailyFood.setWeight(dailyFood.getWeight() + eatCharacteristic.getFoodIntake());
                logger.info("Negative value");
                return;
            }
        }
    }

    @SneakyThrows(InterruptedException.class)
    public void close() {
        logger.error("Pug died");
        if (cuteLevel == CuteLevel.SMALL_DOG) {
            logger.info(String.format("The master of small dog is %s in sorrow.", owner.getFirstName()));
        } else if (cuteLevel == CuteLevel.MIDDLE_DOG) {
            logger.info(String.format("The master of middle dog is %s in sorrow.", owner.getFirstName()));
        } else if (cuteLevel == CuteLevel.BIG_DOG){
            logger.info(String.format("The master of big dog is %s in sorrow.", owner.getFirstName()));
        }
        throw new InterruptedException();
    }
}