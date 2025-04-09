package org.mask.core;

public interface Mask {
    String mask(String value);
    String unmask();
    MaskType type();
}
