package menu.model;

public class CoachName {
    private final String name;

    private CoachName(String name) {
        this.name = name;
    }

    public static CoachName of(String name) {
        return new CoachName(name);
    }

    public String getName() {
        return this.name;
    }
}
