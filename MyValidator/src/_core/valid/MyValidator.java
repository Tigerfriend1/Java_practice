package _core.valid;// Validation Framework

import _core.annotation.NotNull;
import _core.annotation.Size;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
//[Name should be between 3 to 50 characters]
//[Name cannot be null]
public class MyValidator {

    public static Set<String> validate(Object obj) {
        Set<String> violations = new HashSet<>();

        Class<?> cl = obj.getClass();
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            if (field.isAnnotationPresent(NotNull.class)) {
                NotNull notNull = field.getAnnotation(NotNull.class);
                validateNotNull(value, notNull, violations);
            }
            if (field.isAnnotationPresent(Size.class)) {
                Size size = field.getAnnotation(Size.class);
                validateSize(value, size, violations);
            }
        }

        return violations;
    }

    private static void validateNotNull(Object value, NotNull notNull, Set<String> violations) {
        if (value == null) {
            violations.add(notNull.message());
        }
    }

    private static void validateSize(Object value, Size size, Set<String> violations) {
        String str = (String) value;
        int min = size.min();
        int max = size.max();
        if(value==null){
            return;
        }
        if (min > str.length() || max < str.length()) {
            violations.add(size.message());
        }
    }

}

