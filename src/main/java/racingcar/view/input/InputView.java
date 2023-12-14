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

}