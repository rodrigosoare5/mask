package org.mask.core.cpf;

import org.mask.core.*;

public class CPFMask implements Mask {

    private final String mask;

    public CPFMask(String mask) {
        this.mask = mask;
    }

    @Override
    public String mask(String value) {
        if (!isValidCpf(value)) {
            throw new FormatInvalidException("Invalid CPF format");
        }
        return value.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    @Override
    public String unmask() {
        return mask.replaceAll("\\D", "");
    }

    private boolean isValidCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        return cpf.matches("\\d{11}");

    }

    @Override
    public MaskType type() {
        return MaskType.CPF;
    }
}
