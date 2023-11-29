package menu.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import menu.model.menu.MenuCategory;
import menu.model.menu.Weekday;

public class OutputView {
    private static final String START_RECOMMENDATION = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_MENU = "메뉴 추천 결과입니다.";
    private static final String DAY = "[ 구분 ";
    private static final String CATEGORY = "[ 카테고리 ";
    private static final String OPEN_ARRAY = "[ ";
    private static final String CLOSE_ARRAY = " ]";
    private static final String SPACE = " | ";
    private static final String COMPLETED = "추천을 완료했습니다.";

    public void printStartRecommendation() {
        System.out.println(START_RECOMMENDATION);
    }

    public void printFinalMenu() {
        System.out.println("\n" + RESULT_MENU);
    }

    public void printWeekOfDay(final Map<Weekday, MenuCategory> weekdayMenuCategory) {
        Set<Weekday> weekdays = weekdayMenuCategory.keySet();
        StringBuilder formattedString = new StringBuilder(DAY);
        for (Weekday day : weekdays) {
            formattedString.append(SPACE).append(day.getDay());
        }
        formattedString.append(CLOSE_ARRAY);
        System.out.println(formattedString);
    }

    public void printCategory(final Map<Weekday, MenuCategory> weekdayCategory) {
        Collection<MenuCategory> values = weekdayCategory.values();
        StringBuilder formattedString = new StringBuilder(CATEGORY);
        for (MenuCategory category : values) {
            formattedString.append(SPACE).append(category.getMenuItems());
        }
        formattedString.append(CLOSE_ARRAY);
        System.out.println(formattedString);
    }

    public void printCoachMenu(final HashMap<String, List<String>> lunch) {
        StringBuilder formattedString = new StringBuilder(OPEN_ARRAY);
        for (Entry<String, List<String>> coach : lunch.entrySet()) {
            formattedString.append(coach.getKey());
            List<String> value = coach.getValue();
            formattedString.append(SPACE).append(String.join(", ", value));
            formattedString.append(CLOSE_ARRAY);
            System.out.println(formattedString);
            formattedString = new StringBuilder(OPEN_ARRAY);
        }
    }

    public void printCompleted() {
        System.out.println("\n" + COMPLETED);
    }
}
