package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.model.Coach;
import menu.model.CoachName;
import menu.model.RestrictedFood;
import menu.util.InputNames;
import menu.util.InputRestrictedFoods;
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
        InputNames inputNames = setCoachName();
        List<Coach> coaches = createCoaches(inputNames);
    }

    public InputNames setCoachName() {
        return inputView.readCoachName();
    }

    public InputRestrictedFoods setRestrictedFoods(String coachNames) {
        return inputView.readRestrictedFoods(coachNames);
    }

    private List<Coach> createCoaches(InputNames inputNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : inputNames.getAllCoachNames()) {
            InputRestrictedFoods inputRestrictedFoods = setRestrictedFoods(name);
            Coach coach = Coach.valueOf(CoachName.of(name), RestrictedFood.of(inputRestrictedFoods.getRestrictedFood()));
            coaches.add(coach);
        }
        return coaches;
    }
}
