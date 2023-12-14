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
    private static List<RacingCar> racingCars;

    private RacingMainController(){
    }

    public static void start() {
        carName = InputView.readNamesInfo();
        roundCount = InputView.readRoundCount();
        OutputView.printNewLine();
        racePlaying();
        announceWinners(racingCars);
    }

    private static void racePlaying() {
        racingCars = carName.getCarNames().stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());

        OutputView.printResult();
        for (int i = 0; i < roundCount; i++) {
            RacingService.racePlaying(racingCars);
        }
    }

    private  static void announceWinners(List<RacingCar> racingCars) {
        int maxPosition = RacingService.getMaxPosition(racingCars);
        String winners = RacingService.getWinners(racingCars, maxPosition);
        OutputView.printWinner(winners);
    }
}
