package edu.pnu.cse.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Size {
    public int min();
    public int max();
    String message() default "size!!";
}
