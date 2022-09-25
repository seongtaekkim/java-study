package _08_에노테이션의변화_1;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("마늘")
public class App2 {
    public static void main(@Chicken("치킨") String[] args) {

        /**
         * 애노테이션 컨테이너가 갖고있는 애노테이션 배열을 가져와서 출력하기. (2가지)
         */
        Chicken[] chickens = App2.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> {
            System.out.println(c.value());
        });

        ChickenContainter chickenContainter = App2.class.getAnnotation(ChickenContainter.class);
        Arrays.stream(chickenContainter.value()).forEach(c -> {
            System.out.println(c.value());
        });



    }
}
