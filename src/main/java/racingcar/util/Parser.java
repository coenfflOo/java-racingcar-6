package racingcar.util;

import static racingcar.exception.ErrorCode.*;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String DELIMITER = ";";
    private static final int POSITIVE_NUMBER_MINIMUM_RANGE = 1;
    private static final Pattern REGEX_ROUND_PATTERN = Pattern.compile("^[1-9][0-9]*$");
    // 쉼표(,)로 구분되는 이름인지 확인하는 정규식
    private static final Pattern REGEX_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]{1,5}(,[a-zA-Z0-9]{1,5}){1,}$");


    // Default Constructor
    private Parser() {
    }

    //== Business Logic ==//
    public static List<String> parseInputToList(String input) {
        INVALID_INPUT.validate(() -> isEndWithDelimiter(input));
        INVALID_NAME_BLANK.validate(() -> hasWhitespace(input));
        INVALID_NAME_PATTERN.validate(() -> isInvalidNamePattern(input));
        return splitInput(input);
    }

    public static int parseRoundInput(String roundInput) {
        INVALID_INPUT.validate(() -> isEndWithDelimiter(roundInput));
        INVALID_ROUND_TYPE.validate(() -> isInvalidRoundPattern(roundInput));
        int round =  Integer.parseInt(roundInput);
        INVALID_ROUND.validate(() -> isNotPositiveInteger(round));
        return round;
    }

    //==split Logic ==//
    public static List<String> splitInput(String input) {
        String[] names = input.split(DELIMITER);
        for (String name : names) {
            INVALID_NAME_BLANK.validate(() -> hasWhitespace(name));
        }
        return Arrays.asList(names);
    }

    //== Validation Method ==//
    // 빈칸을 가지고 있는가
    private static boolean hasWhitespace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    // 입력받은 이름이 패턴에 맞는가
    private static boolean isInvalidNamePattern(String input) {
        return matchWithRegex(input, REGEX_NAME_PATTERN);
    }

    // 입력받은 횟수가 패턴에 맞는가
    public static boolean isInvalidRoundPattern(String input) {
        return matchWithRegex(input, REGEX_ROUND_PATTERN);
    }

    // 끝이 DELIMITER로 끝나는가
    private static boolean isEndWithDelimiter (String input) {
        return input.endsWith(DELIMITER);
    }

    // 양수인가
    private static boolean isNotPositiveInteger(Integer value) {
        return value < POSITIVE_NUMBER_MINIMUM_RANGE;
    }

    // == 정규표현식 제약 조건== //
    private static boolean matchWithRegex(String input, Pattern regex) {
        Matcher matcher = regex.matcher(input);
        return !matcher.matches();
    }


}