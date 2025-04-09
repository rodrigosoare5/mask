package org.mask.reflections;

import org.reflections.Reflections;

public class ReflectionsSingleton {
    private static Reflections reflections;

    private ReflectionsSingleton() {
       throw new UnsupportedOperationException("This is a singleton class and cannot be instantiated");
    }

    public static Reflections getInstance() {
        if(reflections == null) {
            reflections = new Reflections("org.mask.core");
        }
        return reflections;
    }
}
