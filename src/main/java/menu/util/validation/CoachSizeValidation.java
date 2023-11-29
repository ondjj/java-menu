package menu.util.validation;

import java.util.List;
import menu.model.Coach;
import menu.util.exception.IllegalStateExceptionType;

public class CoachSizeValidation {
    public static void validateCoachSize(List<Coach> coaches) {
        if (hasInvalidCoachSize(coaches)) {
            throw IllegalStateExceptionType.INVALID_COACH_SIZE.getException();
        }
    }

    private static boolean hasInvalidCoachSize(List<Coach> coaches) {
        return coaches.size() > 5 || coaches.size() < 2;
    }
}
