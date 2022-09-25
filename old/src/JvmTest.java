import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JvmTest {
    public static void main( String[] args ) {

        System.out.println(JvmTest.class.getClassLoader().getClass());
        System.out.println(JvmTest.class.getClassLoader().getParent());
        System.out.println((JvmTest.class.getClassLoader().getParent().getParent()));


        System.out.println(Test.class);
        Student s1 = new Student();

        // Getting hold of Class
        // object created by JVM.
        Class c1 = s1.getClass();

        // Printing type of object using c1.
        System.out.println(c1.getName());

        // getting all methods in an array
        Method m[] = c1.getDeclaredMethods();
        for (Method method : m)
            System.out.println(method.getName());

        // getting all fields in an array
        Field f[] = c1.getDeclaredFields();
        for (Field field : f)
            System.out.println(field.getName());

        Student s2 = new Student();
        // c2 will point to same object where
        // c1 is pointing
        Class c2 = s2.getClass();
        System.out.println(c1==c2); // true
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(s2);
        // String class is loaded by bootstrap loader, and
        // bootstrap loader is not Java object, hence null
        System.out.println(String.class.getClassLoader());

        // Test class is loaded by Application loader
        System.out.println(Test.class.getClassLoader());
    }
}

class Test{

}

// A sample class whose information
// is fetched above using its Class object.
class Student {
    private String name;
    private int roll_No;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getRoll_no() { return roll_No; }
    public void setRoll_no(int roll_no)
    {
        this.roll_No = roll_no;
    }
}
