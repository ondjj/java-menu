package menu.model;


import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import menu.model.menu.MenuCategory;
import menu.model.menu.Weekday;

public class CategoryGenerator {
    private final Map<Weekday, MenuCategory> weekdayCategory;

    private CategoryGenerator() {
        this.weekdayCategory = createValidWeekdayMenuMap();
    }

    public static CategoryGenerator of() {
        return new CategoryGenerator();
    }

    private Map<Weekday, MenuCategory> createValidWeekdayMenuMap() {
        Map<Weekday, MenuCategory> weekdayCategory = createWeekdayCategory();
        while (validCategory(weekdayCategory)) {
            weekdayCategory = createWeekdayCategory();
        }
        return weekdayCategory;
    }

    private Map<Weekday, MenuCategory> createWeekdayCategory() {
        Map<Weekday, MenuCategory> map = new EnumMap<>(Weekday.class);
        map.put(Weekday.MONDAY, MenuCategory.getRandomCategory());
        map.put(Weekday.TUESDAY, MenuCategory.getRandomCategory());
        map.put(Weekday.WEDNESDAY, MenuCategory.getRandomCategory());
        map.put(Weekday.THURSDAY, MenuCategory.getRandomCategory());
        map.put(Weekday.FRIDAY, MenuCategory.getRandomCategory());
        return map;
    }

    private boolean validCategory(Map<Weekday, MenuCategory> weekdayCategory) {
        Map<MenuCategory, Integer> menuCategoryIntegerMap = excessiveCount(weekdayCategory);
        return menuCategoryIntegerMap.size() < 3;
    }

    private Map<MenuCategory, Integer> excessiveCount(Map<Weekday, MenuCategory> weekdayCategory) {
        Map<MenuCategory, Integer> categories = new HashMap<>();
        for (Entry<Weekday, MenuCategory> weekday : weekdayCategory.entrySet()) {
            MenuCategory category = weekday.getValue();
            categories.put(category, categories.getOrDefault(category, 0) + 1);
        }
        return categories;
    }

    public Map<Weekday, MenuCategory> getWeekdayCategory() {
        return this.weekdayCategory;
    }

    public MenuCategory getCategoryType(Weekday weekday) {
        return weekdayCategory.get(weekday);
    }
}
