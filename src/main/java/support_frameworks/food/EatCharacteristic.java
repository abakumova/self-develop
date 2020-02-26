package support_frameworks.food;

import lombok.Builder;
import lombok.Getter;
import support_frameworks.enums.DayPart;
import support_frameworks.enums.DogPosition;

@Getter
@Builder(builderClassName = "FoodCollector", builderMethodName = "createCharacteristic")
public class EatCharacteristic {

    private double foodIntake;
    private DayPart dayPart;
    private DogPosition dogPosition;
}