package racingcar.domain;

public class CarPosition {
    private int position = 0;

    public void advance() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
