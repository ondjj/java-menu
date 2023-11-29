package menu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.model.CategoryGenerator;
import menu.model.Coach;
import menu.model.CoachName;
import menu.model.RestrictedFood;
import menu.model.menu.Menu;
import menu.model.menu.MenuCategory;
import menu.model.menu.Weekday;
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
        HashMap<String, List<String>> menu = setMenu(coaches);
        displayCoachMenu(menu);
        displayClose();
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

    private HashMap<String, List<String>> setMenu(List<Coach> coaches) {
        CategoryGenerator categoryGenerator = CategoryGenerator.of();
        Menu menu = Menu.getInstance(coaches, categoryGenerator);
        HashMap<String, List<String>> lunch = menu.lunch();
        outputView.printFinalMenu();

        Map<Weekday, MenuCategory> weekdayCategory = categoryGenerator.getWeekdayCategory();
        outputView.printWeekOfDay(weekdayCategory);
        outputView.printCategory(weekdayCategory);
        return lunch;
    }

    private void displayCoachMenu(HashMap<String, List<String>> lunch) {
        outputView.printCoachMenu(lunch);
    }

    private void displayClose() {
        outputView.printCompleted();
    }
}
