package org.mask.core.util;

public class MaskUtils {
    private MaskUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static boolean isValidMask(String mask) {
        return StringUtils.isNotNullOrEmpty(mask) && mask.matches("^[#\\(\\)\\-\\s]+$");
    }

    private boolean isValidValueForMask(String value, String mask) {
        return value.length() == mask.replaceAll("[^#]", "").length();
    }
}
