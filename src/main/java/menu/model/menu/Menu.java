package menu.model.menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import menu.model.CategoryGenerator;
import menu.model.Coach;
import menu.model.CoachName;
import menu.model.RestrictedFood;

public class Menu {
    private final List<Coach> coaches;
    private final CategoryGenerator categoryGenerator;

    private Menu(List<Coach> coaches, CategoryGenerator categoryGenerator) {
        this.coaches = coaches;
        this.categoryGenerator = categoryGenerator;
    }

    public static Menu getInstance(List<Coach> coaches, CategoryGenerator categoryGenerator) {
        return new Menu(coaches, categoryGenerator);
    }

    private final Map<MenuCategory, Supplier<List<String>>> categoryToMenuMethod = Map.of(
            MenuCategory.JAPANESE_FOOD, this::getJapaneseFood,
            MenuCategory.KOREAN_FOOD, this::getKoreanFood,
            MenuCategory.CHINESE_FOOD, this::getChineseFood,
            MenuCategory.OTHER_ASIAN, this::getAsianFood,
            MenuCategory.WESTERN_FOOD, this::getWesternFood
    );

    public List<String> getJapaneseFood() {
        return Arrays.asList(
                "규동", "우동", "미소시루", "스시", "가츠동",
                "오니기리", "하이라이스", "라멘", "오코노미야끼"
        );
    }

    public List<String> getKoreanFood() {
        return Arrays.asList(
                "김밥", "김치찌개", "쌈밥", "된장찌개",
                "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"
        );
    }

    public List<String> getChineseFood() {
        return Arrays.asList(
                "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕",
                "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"
        );
    }

    public List<String> getAsianFood() {
        return Arrays.asList(
                "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥",
                "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"
        );
    }

    public List<String> getWesternFood() {
        return Arrays.asList(
                "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트",
                "바게트", "스파게티", "피자", "파니니"
        );
    }

    public HashMap<String, List<String>> lunch() {
        HashMap<String, List<String>> coachWithMenu = new HashMap<>();
        for (Coach coach : coaches) {
            List<String> finalMenu = new ArrayList<>();
            CoachName name = coach.getName();
            RestrictedFood restrictedFood = coach.getRestrictedFood();
            selectMenu(finalMenu, restrictedFood);
            coachWithMenu.put(name.getName(), finalMenu);
        }
        return coachWithMenu;
    }

    private void selectMenu(final List<String> finalMenu, final RestrictedFood restrictedFood) {
        for (Weekday weekday : Weekday.values()) {
            MenuCategory categoryType = categoryGenerator.getCategoryType(weekday);
            Supplier<List<String>> menuMethod = categoryToMenuMethod.get(categoryType);

            List<String> menus = menuMethod.get();
            String menu = Randoms.shuffle(menus).get(0);

            while (restrictedFood.contain(menu) && finalMenu.contains(menu)){
                menu = Randoms.shuffle(menus).get(0);
            }
            finalMenu.add(menu);
        }
    }
}
