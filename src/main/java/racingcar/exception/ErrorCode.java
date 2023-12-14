package racingcar.exception;

import java.util.function.BooleanSupplier;

public enum ErrorCode {
    INVALID_NAME_PATTERN("이름은 쉼표(,) 기준으로 구분하여 5자 이하로 입력해야합니다.."),
    INVALID_NAME_DUPLICATE("중복된 이름은 사용할 수 없습니다."),
    INVALID_NAME_BLANK("이름은 공백일 수 없습니다."),
    INVALID_ROUND("시도 횟수는 1 이상이어야 합니다."),
    INVALID_ROUND_TYPE("시도 횟수는 숫자여야 합니다."),
    INVALID_INPUT("잘못된 입력입니다.");

    public static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public void validate(BooleanSupplier condition) {
        if (isSameCondition(condition)) {
            throw BusinessException.from(this);
        }
    }

    private boolean isSameCondition(BooleanSupplier condition) {
        return condition.getAsBoolean();
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
