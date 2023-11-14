// Validation Framework

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
//[Name should be between 3 to 50 characters]
//[Name cannot be null]
public class MyValidator {

    public static Set<String> validate(Object obj) {

        Set<String> violations = new HashSet<>();

        // Implement validation logic using Reflection
        Class<?> cl = obj.getClass();
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                NotNull notNull = field.getAnnotation(NotNull.class);
                Object value = null;
                try {
                    value = field.get(obj);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (value == null) {
                    violations.add(notNull.message());
                    return violations;
                }
            }
            if (field.isAnnotationPresent(Size.class)) {
                Size size = field.getAnnotation(Size.class);
                Object value = null;
                try {
                    value = field.get(obj);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                String str = (String) value;
                int min = size.min();
                int max = size.max();
                if (min > str.length() || max < str.length()) {
                    violations.add(size.message());
                }
            }
        }

        return violations;

    }

}

