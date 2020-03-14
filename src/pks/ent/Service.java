package pks.ent;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Target(ElementType.TYPE)
public @interface Service {

    String name();

    boolean lazyload() default false;
}
