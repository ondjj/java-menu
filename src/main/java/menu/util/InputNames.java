package menu.util;

import static menu.util.validation.CoachNameValidation.validateCoachNames;

import java.util.List;

public class InputNames {
    private final List<String> names;

    private InputNames(List<String> names) {
        this.names = names;
    }

    public static InputNames of(String coachName) {
        List<String> parseNames = Parser.parseString(coachName);
        validateCoachNames(parseNames);
        return new InputNames(parseNames);
    }

    public List<String> getAllCoachNames() {
        return this.names;
    }
}
