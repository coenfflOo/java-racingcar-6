package racingcar.view.constant;

public enum OutputMessage {
    RESPONSE_RESULT("실행 결과");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}