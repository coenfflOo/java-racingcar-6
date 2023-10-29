package racingcar.View;
import static racingcar.Message.InputMessage.*;
import static racingcar.Message.ExceptionMessage.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Exception.CarException;
import racingcar.Exception.RaceException;

public class InputView {
    CarException carException = new CarException();
    RaceException raceException = new RaceException();
    public String inputCar(){
        System.out.println(CAR_NAME_MESSAGE);
        String carsName = Console.readLine();
        try {
            return carException.checkExceptionCar(carsName);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return null;
        }
    }

    public int inputRaceTime(){
        System.out.println(CAR_NAME_MESSAGE);
        String carsName = Console.readLine();
        try {
            return raceException.checkExceptionRace(carsName);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return -1;
        }
    }
}
