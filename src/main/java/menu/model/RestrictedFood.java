package menu.model;

import java.util.List;

public class RestrictedFood {
    private final List<String> restrictedFood;

    private RestrictedFood(List<String> restrictedFood) {
        this.restrictedFood = restrictedFood;
    }

    public static RestrictedFood of(List<String> restrictedFood) {
        return new RestrictedFood(restrictedFood);
    }

    public List<String> getRestrictedFood() {
        return this.restrictedFood;
    }

    public boolean contain(final String menu) {
        return restrictedFood.contains(menu);
    }
}
