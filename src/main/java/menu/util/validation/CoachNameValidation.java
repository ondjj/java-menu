package menu.util.validation;

import java.util.List;
import menu.util.exception.IllegalArgumentExceptionType;

public class CoachNameValidation {
    public static void validateCoachNames(List<String> coachNames) {
        if (hasInvalidNameLength(coachNames)) {
            throw IllegalArgumentExceptionType.INVALID_NAME_LENGTH.getException();
        }
    }

    private static boolean hasInvalidNameLength(List<String> coachNames) {
        return coachNames.stream().anyMatch(name -> name.length() > 4 || name.length() < 2);
    }
}
