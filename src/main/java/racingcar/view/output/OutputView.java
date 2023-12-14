package racingcar.view.output;

import static racingcar.view.constant.OutputMessage.RESPONSE_RESULT;
import static racingcar.view.constant.PrintFormat.RESPONSE_WINNER;
import static racingcar.view.constant.PrintFormat.RESULT_FORMAT;

public final class OutputView extends OutputWriter {
    public static void printResult() {
        printMessageResponse(RESPONSE_RESULT);
    }
    public static void printCarPosition(String name, int position) {
        printFormat2(RESULT_FORMAT.getFormat(), name, "-".repeat(position));
    }

    public static void printWinner(String winners) {
        System.out.println("최종 우승자: " + winners);
        printFormat(RESPONSE_WINNER.getFormat(), winners);
    }

}