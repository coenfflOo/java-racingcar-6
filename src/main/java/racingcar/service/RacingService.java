package racingcar.service;

import java.util.*;
import racingcar.domain.RacingCar;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.output.OutputView;

public class RacingService {
    public static void racePlaying(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            car.move(Randoms.pickNumberInRange(0, 9));
            OutputView.printCarPosition(car.getName(), car.getPosition());
        }
        OutputView.printNewLine();
    }

//    private static void announceWinners(List<RacingCar> racingCars) {
//        int maxPosition = racingCars.stream()
//                .mapToInt(RacingCar::getPosition)
//                .max()
//                .orElse(0);
//
//        String winners = racingCars.stream()
//                .filter(car -> car.getPosition() == maxPosition)
//                .map(RacingCar::getName)
//                .collect(Collectors.joining(", "));
//
//        OutputView.printWinner(winners);
//    }

}
