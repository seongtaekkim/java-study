package _04_Optional_1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList();
        springClasses.add(new OnlineClass(1, "springboot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(2, "spring data jpa", true);

        /*
            Optional<T> 사용 이전에는, 객체를 사용할 때 null체크를 항상 해야 했다.
         */
        /*Progress progress = spring_boot.getProgress();
        if (progress != null)
             System.out.println(progress.getStudyDuration());*/

        /*
            getProgress() 리턴타입을 Optional 로 변경 후 로직.
            - Optional<T>은 객체가 존재할 수도 없을수도 있다는 것을 의미 (없어도 npe가 발생하지 않음)
         */
        Duration studyDuration = spring_boot.getProgress().get().getStudyDuration();
        System.out.println(studyDuration);


        /*
            setProgress parameter에 Optional 입력 지양
         */
        OnlineClass obj = new OnlineClass(2, "spring data jpa", true);
        obj.setProgress(null);

        /*
            내부에서 박싱/언박싱이 일어나므로 지양
         */
        Optional.of(10);

        /*
            이 코드를 쓰자.
         */
        OptionalInt.of(10);

    }
}
