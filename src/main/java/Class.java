/**
 * Created by user on 15.11.2017.
 */
public class Class {
    public static String hello(){
        return ("hello");
    }

    public static String helloAge(int age){
        if(age<=0)
            throw new IllegalArgumentException();
        return String.format("hello%d", age);
    }
}
