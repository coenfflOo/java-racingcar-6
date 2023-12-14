package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingMainController;

public class Application {
    public static void main(String[] args) {
        RacingMainController.start();
        Console.close();
    }
}
