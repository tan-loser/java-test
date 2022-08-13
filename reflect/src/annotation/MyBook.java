package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

@Target({METHOD,TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyBook {
    String name() default "java思想";
    String[] auther();

}
