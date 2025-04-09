package org.mask.annotations;

import org.mask.core.MaskType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Masker(type = MaskType.CPF)
public @interface CPF {
}


