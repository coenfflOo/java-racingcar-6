package racingcar.view.input;

import static racingcar.view.constant.InputMessage.*;

import java.util.List;
import racingcar.util.InputUtil;
import racingcar.util.Parser;
import racingcar.domain.CarName;

public class InputView {
    public static CarName readNamesInfo() {
        while (true) {
            try {
                System.out.print(REQUEST_CAR_NAMES.getMessage());
                final String input = InputUtil.readLine();
                final List<String> names = Parser.parseInputToList(input);
                return CarName.of(names);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static int readRoundCount() {
        while (true) {
            try {
                System.out.print(REQUEST_ROUND_COUNT.getMessage());
                final String input = InputUtil.readLine();
                return Parser.parseRoundInput(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}