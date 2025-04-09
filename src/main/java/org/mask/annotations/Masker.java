package org.mask.annotations;

import org.mask.core.MaskType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface Masker {
    MaskType type();
    String mask() default "";
}
