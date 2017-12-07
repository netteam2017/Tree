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




    public void delete_and_addNode(){
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

    public void addTree(){
        Tree tree1=new Tree(new Node(1));
        tree1.addNode(new Node(2),1,1);
        tree1.addNode(new Node(3),1,1);


        Tree tree2 = new Tree((new Node(11)));
        tree2.addNode(new Node(22),1,1);
        tree2.addNode(new Node(33),1,1);

        tree1.addTree(tree2,new Id(2,1));

        Assert.assertEquals(1,tree1.getNodeOnNumber(1,1).getData());
        Assert.assertEquals(2,tree1.getNodeOnNumber(2,1).getData());
        Assert.assertEquals(3,tree1.getNodeOnNumber(2,2).getData());
        Assert.assertEquals(11,tree1.getNodeOnNumber(3,1).getData());
        Assert.assertEquals(22,tree1.getNodeOnNumber(4,1).getData());
        Assert.assertEquals(33,tree1.getNodeOnNumber(4,2).getData());

        //uniq id

    }

    public void splitTree(){
        Tree tree1=new Tree(new Node(1));
        tree1.addNode(new Node(2),1,1);
        tree1.addNode(new Node(3),1,1);
        tree1.addNode(new Node(11),2,1);
        tree1.addNode(new Node(22),3,1);
        tree1.addNode(new Node(33),3,1);


        Tree tree2 = tree1.createTree(new Id(3,1));


        Assert.assertEquals(11,tree2.getNodeOnNumber(1,1).getData());
        Assert.assertEquals(22,tree2.getNodeOnNumber(2,1).getData());
        Assert.assertEquals(33,tree2.getNodeOnNumber(2,2).getData());

        tree2.addNode(new Node(100),2,2);
        Assert.assertEquals(100,tree2.getNodeOnNumber(4,1).getData());

        //4) Проверить что в дереве все id упорядочены сверху вниз.


    }






}
