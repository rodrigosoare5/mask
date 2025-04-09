package org.mask.core.proxy;

import net.sf.cglib.proxy.Enhancer;


public class MaskProxy {
    @SuppressWarnings("unchecked")
    public static <T> T create(T target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MaskInterceptor(target));
        return (T) enhancer.create();
    }
}
