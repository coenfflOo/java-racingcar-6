package racingcar.service;

import java.util.*;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.output.OutputView;

public class RacingService {
    public static void racePlaying(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
        OutputView.printRoundResult(racingCars);
    }

    public static int getMaxPosition(List<RacingCar> racingCars) {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }

    public static String getWinners(List<RacingCar> racingCars, int maxPosition) {
        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
    }
}
