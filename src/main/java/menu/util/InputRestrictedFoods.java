package menu.util;

import java.util.List;

public class InputRestrictedFoods {
    private final List<String> restrictedFood;

    private InputRestrictedFoods(List<String> restrictedFood) {
        this.restrictedFood = restrictedFood;
    }

    public static InputRestrictedFoods of (String restrictedFood) {
        List<String> parseFoods = Parser.parseString(restrictedFood);
        return new InputRestrictedFoods(parseFoods);
    }

    public List<String> getRestrictedFood() {
        return restrictedFood;
    }
}
