package org.mask.core.resolver;

import org.mask.core.Mask;
import org.mask.core.MaskType;

import java.util.HashSet;
import java.util.Set;

import org.mask.reflections.ReflectionsSingleton;

public class MaskResolver {
    private static  MaskResolver instance;

    private final Set<Class<? extends Mask>> classes = new HashSet<>();

    public MaskResolver() {
        this.classes.addAll(ReflectionsSingleton.getInstance().getSubTypesOf(Mask.class));
    }
    /**
     * Retrieves a mask instance based on the provided MaskType.
     *
     * @param type the MaskType to retrieve the mask for
     * @return an instance of the corresponding Mask
     * @throws IllegalArgumentException if the type is null or no matching mask is found
     */
    public Mask getMaskInstance(MaskType type, String pattern) {
        if (type == null) {
            throw new IllegalArgumentException("MaskType cannot be null");
        }

        for (Class<? extends Mask> clazz : classes) {
            try {
                Mask mask = clazz.getDeclaredConstructor(String.class).newInstance(pattern);
                if (mask.type() == type) {
                    return mask;
                }
            } catch (Exception e) {
                throw new RuntimeException("Error creating mask instance", e);
            }
        }
        throw new IllegalArgumentException("No mask found for type: " + type);
    }

    public static MaskResolver getInstance() {
        if (instance == null) {
            instance = new MaskResolver();
        }
        return instance;
    }

    public static Mask getMask(MaskType type, String pattern) {
        return getInstance().getMaskInstance(type, pattern);
    }
}
