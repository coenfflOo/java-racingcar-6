package racingcar.domain;

import java.util.List;

public class CarName {
    private final List<String> CarNames;
    private CarName(List<String> names) {
        this.CarNames = names;
    }
    public static CarName of(List<String> names) {
        return new CarName(names);
    }

}
