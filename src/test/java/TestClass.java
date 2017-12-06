import junit.framework.Assert;
import org.junit.Test;
import sun.reflect.generics.tree.*;

/**
 * Created by user on 15.11.2017.
 */
public class TestClass {
    @Test
    public  void createTree(){
        Tree tree1 = new Tree();
        tree1.addNode(new Node(2),1,1);
        tree1.addNode(new Node(3),1,1);

        Assert.assertEquals( 1,tree1.getNodeOnNumber(1,1).getData());
        Assert.assertEquals( 2,tree1.getNodeOnNumber(2,1).getData());
        Assert.assertEquals( 3,tree1.getNodeOnNumber(2,2).getData());
    }




    public void deleteNode(){
        Tree tree1 = new Tree();
        tree1.addNode(new Node(2),1,1);
        tree1.addNode(new Node(3),1,1);

        tree1.deleteNode(1,1);
        tree1.deleteNode(1,1);
        tree1.addNode(new Node(),1,1);
        tree1.addNode(new Node(),2,1);
        tree1.addNode(new Node(),2,2);

        Assert.assertEquals("Vertex is not exist! "+null,tree1.getNodeOnNumber(1,1));
       // Assert.assertEquals("Vertex is not exist! ",tree1.deleteNode(1,1));
        Assert.assertEquals("Vertex is not exist! "+null,tree1.getNodeOnNumber(2,1));
        Assert.assertEquals("Vertex is not exist! "+null,tree1.getNodeOnNumber(2,2));
        Assert.assertEquals("Vertex is not exist! "+null,tree1.getNodeOnNumber(3,1));
        Assert.assertEquals("Vertex is not exist! "+null,tree1.getNodeOnNumber(3,2));

    }




}
