package _08_에노테이션의변화_1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ChickenContainer는 감쌀 Chicken의 Retention, target 등 보다 더 넓은 범위를 케어해야 한다.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface ChickenContainter {
    Chicken[] value();
}
