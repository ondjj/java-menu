package menu.model;

import static menu.util.validation.CoachNameValidation.validateCoachNames;

import java.util.List;
import menu.util.Parser;

public class CoachNames {
    private final List<String> names;

    private CoachNames(List<String> names) {
        this.names = names;
    }

    public static CoachNames of(String coachName) {
        List<String> parseNames = Parser.parseString(coachName);
        validateCoachNames(parseNames);
        return new CoachNames(parseNames);
    }

    public List<String> getAllCoachNames() {
        return this.names;
    }
}
