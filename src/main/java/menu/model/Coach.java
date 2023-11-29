package menu.model;

public class Coach {
    private final CoachNames coachNames;
    private final RestrictedFoods restrictedFoods;

    private Coach(final CoachNames coachNames, final RestrictedFoods restrictedFoods){
        this.coachNames = coachNames;
        this.restrictedFoods = restrictedFoods;
    }

    public static Coach valueOf(final CoachNames coachNames, final RestrictedFoods restrictedFoods) {
        return new Coach(coachNames, restrictedFoods);
    }
}
