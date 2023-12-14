package racingcar.domain;


public class RacingCar {
    private final String name;
    private final CarPosition position;

    public RacingCar(String name) {
        this.name = name;
        this.position = new CarPosition();
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position.advance();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name;
    }
}
