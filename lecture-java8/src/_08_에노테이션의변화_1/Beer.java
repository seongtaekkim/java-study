package _08_에노테이션의변화_1;

import java.lang.annotation.*;


/**
 * ElementType.TYPE_PARAMETER
 * -> 제네릭함수의 type_parameter 에만 애노테이션을 작성할 수 있다.
 * ElementType.TYPE_USE
 * -> type을 선언하는 모든곳에 애노테이션을 작성할 수 있다.
 */
@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE_PARAMETER)
@Target(ElementType.TYPE_USE)
public @interface Beer {
}
