package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.model.Coach;
import menu.model.CoachNames;
import menu.model.RestrictedFoods;
import menu.view.InputView;
import menu.view.OutputView;

public class LunchMenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public LunchMenuController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartRecommendation();
        CoachNames coachNames = setCoachName();
        List<Coach> coaches = createCoaches(coachNames);
    }

    public CoachNames setCoachName() {
        return inputView.readCoachName();
    }

    public RestrictedFoods setRestrictedFoods(String coachNames) {
        return inputView.readRestrictedFoods(coachNames);
    }

    private List<Coach> createCoaches(CoachNames coachNames) {
        List<String> allCoachNames = coachNames.getAllCoachNames();
        List<Coach> coaches = new ArrayList<>();
        for (String name : allCoachNames) {
            RestrictedFoods restrictedFoods = setRestrictedFoods(name);
            Coach coach = Coach.valueOf(coachNames, restrictedFoods);
            coaches.add(coach);
        }
        return coaches;
    }
}
