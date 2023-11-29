package menu.model;

import static menu.util.validation.CoachSizeValidation.*;

import java.util.List;

public class CoachPreferences {
    private final List<Coach> coaches;

    private CoachPreferences(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static CoachPreferences of(List<Coach> coaches) {
        validateCoachSize(coaches);
        return new CoachPreferences(coaches);
    }
}
