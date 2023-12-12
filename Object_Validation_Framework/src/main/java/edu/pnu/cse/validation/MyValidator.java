package edu.pnu.cse.validation;

import edu.pnu.cse.annotations.Email;
import edu.pnu.cse.annotations.NotNull;
import edu.pnu.cse.annotations.Size;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyValidator {
    /**
     * 주어진 객체의 필드에 대한 유효성 검사를 수행하고, 위반 사항을 반환함.
     * @param obj 검증 대상 객체
     * @return 유효성 위한 사항 Set
     */
    public static Set<String> validate(Object obj) {
        Set<String> violations = new HashSet<>();
        Class<?> clazz = obj.getClass();
        List<Field> fields = new ArrayList<>();

        //부모 클래스를 찾으면서 모든 필드를 리스트에 추가
        while(clazz != null){
            fields.addAll(List.of(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }

        // 필드 유효성 검사
        for(Field field : fields){
            if(field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    NotNull annotation = field.getAnnotation(NotNull.class);
                    if (field.get(obj)==null) {
                        violations.add(annotation.message());
                    }
                } catch (Exception e) {}
            }
            if(field.isAnnotationPresent(Email.class)){
                field.setAccessible(true);
                try {
                    Email annotation = field.getAnnotation(Email.class);
                    if(!validateEmail(field.get(obj).toString())){
                        violations.add(annotation.message());
                    }
                }catch (Exception e){}
            }
            if(field.isAnnotationPresent(Size.class)){
                field.setAccessible(true);
                try {
                    Size annotation = field.getAnnotation(Size.class);
                    int length = field.get(obj).toString().length();
                    if(length<annotation.min() || length>annotation.max()){
                        violations.add(annotation.message());
                    }
                }catch (Exception e){}
            }
        }
        return violations;

        // implement your code

    }


    private static boolean validateEmail(String email) {
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}



// annotations

// implement your code

