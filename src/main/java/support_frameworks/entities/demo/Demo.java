package support_frameworks.entities.demo;

import lombok.Cleanup;
import support_frameworks.entities.animals.inheritors.Pug;
import support_frameworks.entities.enums.CuteLevel;
import support_frameworks.entities.enums.DayPart;
import support_frameworks.entities.enums.DogPosition;
import support_frameworks.entities.food.EatCharacteristic;
import support_frameworks.entities.food.Feed;
import support_frameworks.entities.humans.Owner;
import support_frameworks.entities.properties.PropertyHolder;

public class Demo {

    public static void main(String[] args) {
        int calories = PropertyHolder.calories.getCaloriesValue();
        CuteLevel cuteLevel = PropertyHolder.cute.getCuteLevel();

        Owner owner = new Owner();
        owner.setFirstName("V");
        owner.setSecondName("A");
        owner.setAge(20);

        Feed feed = new Feed("meat", 500);
        feed.setCalorie(calories);

        @Cleanup Pug pug = new Pug("Tuzik", 15);
        pug.setCuteLevel(cuteLevel);

        pug.setOwner(owner);
        pug.eatFood(EatCharacteristic.createCharacteristic()
                .dayPart(DayPart.DAY)
                .dogPosition(DogPosition.SITTING)
                .foodIntake(20)
                .build(), feed);
    }
}