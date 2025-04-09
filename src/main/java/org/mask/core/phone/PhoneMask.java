package org.mask.core.phone;

import org.mask.core.*;

import static org.mask.core.util.MaskUtils.isValidMask;

public class PhoneMask implements Mask {
    private final String mask;

    public PhoneMask(String mask) {
        if (!isValidMask(mask)) {
            throw new FormatInvalidException("Invalid mask format");
        }
        this.mask = mask;
    }

    @Override
    public String mask(String value) {
        StringBuilder result = new StringBuilder();
        var val = value.replaceAll("[^0-9]", "");

        applyMask(result, val);
        return result.toString();
    }

    @Override
    public String unmask() {
        return "value";
    }

    @Override
    public MaskType type() {
        return MaskType.PHONE;
    }

    public static String mask(String value, PhoneMaskCountry maskCountry) {
        return maskCountry.getMask().mask(value);
    }

    private void applyMask(StringBuilder result, String value) {
        for (int i = 0, j = 0; i < mask.length(); i++) {
            if(j >= value.length()) {
                break;
            }
            if (mask.charAt(i) == '#') {
                result.append(value.charAt(j++));
                continue;
            }
            result.append(mask.charAt(i));
        }
    }

}
