package racingcar.view.output;

import static racingcar.view.constant.OutputMessage.RESPONSE_RESULT;
import static racingcar.view.constant.PrintFormat.RESPONSE_WINNER;
import static racingcar.view.constant.PrintFormat.RESULT_FORMAT;

import java.util.List;
import racingcar.domain.RacingCar;

public final class OutputView extends OutputWriter {
    public static void printResult() {
        printMessageResponse(RESPONSE_RESULT);
    }

    public static void printCarPosition(String name, int position) {
        printFormat2(RESULT_FORMAT.getFormat(), name, "-".repeat(position));
        printNewLine();
    }

    public static void printWinner(String winners) {
        printFormat(RESPONSE_WINNER.getFormat(), winners);
    }

    public static void printRoundResult(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            printCarPosition(car.getName(), car.getPosition());
        }
        printNewLine();
    }

}