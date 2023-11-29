package menu.model;

public class Coach {
    private final CoachName name;
    private final RestrictedFood restrictedFood;

    private Coach(final CoachName name, final RestrictedFood restrictedFood){
        this.name = name;
        this.restrictedFood = restrictedFood;
    }

    public static Coach valueOf(final CoachName name, final RestrictedFood restrictedFood) {
        return new Coach(name, restrictedFood);
    }
}
