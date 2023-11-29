package menu.model;

import java.util.List;
import menu.util.Parser;

public class RestrictedFoods {
    private final List<String> restrictedFood;

    private RestrictedFoods(List<String> restrictedFood) {
        this.restrictedFood = restrictedFood;
    }

    public static RestrictedFoods of (String restrictedFood) {
        List<String> parseFoods = Parser.parseString(restrictedFood);
        return new RestrictedFoods(parseFoods);
    }

    public void merge(List<String> restrictedFoods) {
        restrictedFood.addAll(restrictedFoods);
    }

    public List<String> getRestrictedFood() {
        return restrictedFood;
    }
}
