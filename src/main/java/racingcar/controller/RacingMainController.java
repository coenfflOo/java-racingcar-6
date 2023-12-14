package racingcar.controller;


import racingcar.domain.CarName;
import racingcar.view.input.InputView;

public class RacingMainController {
    private static CarName carName;
    private static int rountCount;

    private RacingMainController(){
    }

    public static void start() {
        carName = InputView.readNamesInfo();

    }

}
