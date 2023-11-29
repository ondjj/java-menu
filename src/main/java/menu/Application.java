package menu;

import menu.controller.LunchMenuController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LunchMenuController lunchMenuController = new LunchMenuController(inputView, outputView);
        lunchMenuController.run();
    }
}
