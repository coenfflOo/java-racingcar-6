package racingcar.view.constant;

public enum PrintFormat {
    RESULT_FORMAT("%s : %s"),
    RESPONSE_WINNER("최종 우승자 : %s");

    private final String format;

    PrintFormat(String format) {
        this.format = format;
    }


    public String getFormat() {
        return format;
    }


}