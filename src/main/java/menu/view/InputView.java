package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.model.CoachNames;
import menu.model.RestrictedFoods;

public class InputView {
    private static final String READ_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_RESTRICTED_FOODS = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public CoachNames readCoachName() {
        System.out.println(READ_COACH_NAME);
        return CoachNames.of(Console.readLine());
    }

    public RestrictedFoods readRestrictedFoods(String coachName) {
        System.out.println(coachName+READ_RESTRICTED_FOODS);
        return RestrictedFoods.of(Console.readLine());
    }
}
