package menu.model.menu;

import camp.nextstep.edu.missionutils.Randoms;

public enum MenuCategory {

    JAPANESE_FOOD("일식"),
    KOREAN_FOOD("한식"),
    CHINESE_FOOD("중식"),
    OTHER_ASIAN("아시안"),
    WESTERN_FOOD("양식");

    private final String menuItems;

    MenuCategory(String menuItems) {
        this.menuItems = menuItems;
    }

    public String getMenuItems() {
        return menuItems;
    }

    private static final MenuCategory[] VALUES = values();

    public static MenuCategory getRandomCategory() {
        return VALUES[Randoms.pickNumberInRange(0, VALUES.length - 1)];
    }
}
