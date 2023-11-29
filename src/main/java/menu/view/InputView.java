package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.InputNames;
import menu.util.InputRestrictedFoods;

public class InputView {
    private static final String READ_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_RESTRICTED_FOODS = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public InputNames readCoachName() {
        System.out.println(READ_COACH_NAME);
        return InputNames.of(Console.readLine());
    }

    public InputRestrictedFoods readRestrictedFoods(String coachName) {
        System.out.println(coachName+READ_RESTRICTED_FOODS);
        return InputRestrictedFoods.of(Console.readLine());
    }
}
