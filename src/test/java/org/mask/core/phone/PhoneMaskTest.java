package org.mask.core.phone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class PhoneMaskTest {

    @ParameterizedTest
    @CsvSource({"(##) #####-####, 1199999-9999, (11) 99999-9999",
                "#####-####, 119999999, 11999-9999",
                "(###) ###-####, 1199999999, (119) 999-9999",
                "####-####, 1199999999, 1199-9999",
                })
    void mask(String mask, String value, String expected) {
        PhoneMask phoneMask = new PhoneMask(mask);
        assertThat(phoneMask.mask(value)).isEqualTo(expected);
    }

}