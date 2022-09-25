package _04_Optional_2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList();
        springClasses.add(new OnlineClass(1, "springboot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = optional.isPresent();
        System.out.println(present);

        if (optional.isPresent()) {
            OnlineClass onlineClass = optional.get();
            System.out.println(onlineClass.getTitle());
        }

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));


        OnlineClass onlineClass = optional.orElse(createNewClass());
        System.out.println(onlineClass.getTitle());

        OnlineClass onlineClass1 = optional.orElseGet(App::createNewClass);
        System.out.println(onlineClass1.getTitle());

        OnlineClass onlineClass2 = optional.orElseThrow(() -> new IllegalStateException());
        System.out.println(onlineClass2.getTitle());


        Optional<OnlineClass> optional1 = optional.filter(oc -> !oc.isClosed());
        System.out.println(optional1.isEmpty());


        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElseThrow();
        progress1.orElseThrow();

        Optional<Progress> progress2 = optional.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new class");
        return new OnlineClass(10, "new class", false);
    }
}
