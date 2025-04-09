package org.mask.core.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.mask.annotations.Masker;
import org.mask.core.Mask;
import org.mask.core.resolver.MaskResolver;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Optional;

public class MaskInterceptor implements MethodInterceptor {
    private final Object target;

    public MaskInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        if (method.getName().startsWith("get")) {
            String fieldName = Character.toLowerCase(method.getName().charAt(3)) + method.getName().substring(4);

            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(target);

            return applyMask(field, value);
        }
        return methodProxy.invoke(target, args);
    }

    private Object applyMask(Field field, Object value) {
        if (value instanceof String val) {
            if (field.isAnnotationPresent(Masker.class)) {
                Masker masker = field.getAnnotation(Masker.class);
                Mask mask = MaskResolver.getMask(masker.type(), masker.mask());
                return mask.mask(val);
            }

            var possibleAnnotation = Arrays.stream(field.getAnnotations())
                    .flatMap(annotation -> Arrays.stream(annotation.annotationType().getAnnotations()))
                    .filter(it -> it.annotationType().equals(Masker.class))
                    .findFirst();

            if (possibleAnnotation.isPresent()) {
                Masker masker = (Masker) possibleAnnotation.get();
                Mask mask = MaskResolver.getMask(masker.type(), masker.mask());
                return mask.mask(val);
            }
        }
        return value;

    }
}
