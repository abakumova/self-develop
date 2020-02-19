package support_frameworks.entities.food;

import lombok.Builder;
import lombok.Getter;
import support_frameworks.entities.enums.DayPart;
import support_frameworks.entities.enums.DogPosition;

@Getter
@Builder(builderClassName = "FoodCollector", builderMethodName = "createCharacteristic")
public class EatCharacteristic {

    private double foodIntake;
    private DayPart dayPart;
    private DogPosition dogPosition;
}