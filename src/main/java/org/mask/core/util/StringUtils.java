package org.mask.core.util;

public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isNullOrBlank(String ...values) {
        for(String value : values) {
            if(isNullOrBlank(value)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isNotNullOrEmpty(String value) {
        return !isNullOrEmpty(value);
    }

    public static boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isNotNullOrBlank(String value) {
        return !isNullOrBlank(value);
    }

    public static boolean isNumeric(String value) {
        return value != null && value.matches("\\d+");
    }

    public static boolean isNotNumeric(String value) {
        return !isNumeric(value);
    }

    public static boolean isAlpha(String value) {
        return value != null && value.matches("[a-zA-Z]+");
    }

    public static boolean isNotAlpha(String value) {
        return !isAlpha(value);
    }

    public static boolean isAlphaNumeric(String value) {
        return value != null && value.matches("[a-zA-Z0-9]+");
    }

    public static boolean isNotAlphaNumeric(String value) {
        return !isAlphaNumeric(value);
    }

    public static boolean isAlphaNumericWithSpaces(String value) {
        return value != null && value.matches("[a-zA-Z0-9 ]+");
    }

    public static boolean isNotAlphaNumericWithSpaces(String value) {
        return !isAlphaNumericWithSpaces(value);
    }

    public static boolean isAlphaNumericWithSpecialCharacters(String value) {
        return value != null && value.matches("[a-zA-Z0-9\\p{Punct}]+");
    }

    public static boolean isNotAlphaNumericWithSpecialCharacters(String value) {
        return !isAlphaNumericWithSpecialCharacters(value);
    }

    public static boolean isEmail(String value) {
        return value != null && value.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    public static boolean isNotEmail(String value) {
        return !isEmail(value);
    }

    public static boolean isPhone(String value) {
        return value != null && value.matches("\\(\\d{2}\\)\\d{4,5}-\\d{4}");
    }

    public static boolean isNotPhone(String value) {
        return !isPhone(value);
    }
}
