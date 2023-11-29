package menu.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String SPLIT_REGEX_COMMA = ",";

    public static List<String> parseString(String parseTarget) {
        return Arrays.asList(parseTarget.split(SPLIT_REGEX_COMMA));
    }
}
