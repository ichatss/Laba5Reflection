import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация - для полей или методов
 */

@Retention(value = RetentionPolicy.RUNTIME)
public @interface AutoInjectable {
    boolean value() default true;
}
