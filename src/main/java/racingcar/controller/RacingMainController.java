package racingcar.controller;


import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.CarName;
import racingcar.domain.RacingCar;
import racingcar.service.RacingService;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingMainController {
    private static CarName carName;
    private static int roundCount;

    private RacingMainController(){
    }

    public static void start() {
        carName = InputView.readNamesInfo();
        roundCount = InputView.readRoundCount();
        racePlaying();
    }

    private static void racePlaying() {
        List<RacingCar> racingCars = carName.getCarNames().stream()
                .map(RacingCar::new)
                .toList();
        for (int i = 0; i < roundCount; i++) {
            RacingService.racePlaying(racingCars);
        }
    }

//    private  static void announceWinners(List<RacingCar> racingCars) {
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
