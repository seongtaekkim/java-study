package _01_함수형인터페이스와람다_1;

public class Foo {
    public static void main(String[] args) {
        // 익명 내부 클래스 anonymouse inner class
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
            }
        };

        // 람다 표현식 == 익명 내부클래스
        // 특수한 형태의 오브젝트
        RunSomething runSomething2 = () -> System.out.println("hello");
        runSomething2.doIt();

        // 입력값이 같으면 출력값이 같아야 한다, (순수함수)
        // 아래 예시처럼 외부 상태값에 의존하면(파라메터가 아닌) 순수함수가 아니다.
        // 함수형프로그래밍을 하려면 순수함수를 사용하도록 해야 한다.
        RunSomething2 runSomething3 = new RunSomething2() {
        int baseNumber = 10;
            @Override
            public int doIt(int number) {
                baseNumber++;
                return (number + baseNumber);
            }
        };
    }
}
