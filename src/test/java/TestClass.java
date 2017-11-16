import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by user on 15.11.2017.
 */
public class TestClass {
    @Test
    public  void testClass(){

        Assert.assertEquals( "hello" ,Class.hello());
    }

    public void testAge(){
        Assert.assertEquals("hello,20",Class.helloAge(21));
    }
}
