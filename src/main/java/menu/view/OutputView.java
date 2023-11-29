package menu.view;

public class OutputView {
    private static final String START_RECOMMENDATION = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_MENU = "메뉴 추천 결과입니다.";
    private static final String COMPLETED = "추천을 완료했습니다.";

    public void printStartRecommendation() {
        System.out.println(START_RECOMMENDATION);
    }
}
