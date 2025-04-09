package org.mask.core.phone;

public enum PhoneMaskCountry {
    BR_PHONE( new PhoneMask("(##) #####-####")),
    BR_WITHOUT_DDD(new PhoneMask("#####-####")),
    BR_WITH_DIAL_CODE(new PhoneMask("+55 (##) #####-####")),
    US_PHONE(new PhoneMask("(###) ###-####")),
    US_PHONE_WITHOUT_DDD(new PhoneMask("###-####")),
    ES_PHONE(new PhoneMask("####-####"));

    private final PhoneMask mask;

    PhoneMaskCountry(PhoneMask mask) {
        this.mask = mask;
    }

    public PhoneMask getMask() {
        return mask;
    }

}
