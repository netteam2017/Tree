import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by user on 15.11.2017.
 */
public class TestClass {
    @Test
    public  void createTree(){
        Tree tree1 = new Tree(1);
        tree1.addNode(new Node(2, new Id(1, 1)), new Id(1, 1));
        tree1.addNode(new Node(2, new Id(1, 1)), new Id(1, 1));

        Assert.assertEquals(1, tree1.getNode(new Id(1, 1)).getData());
        Assert.assertEquals(2, tree1.getNode(new Id(2, 1)).getData());
        Assert.assertEquals(2, tree1.getNode(new Id(2, 2)).getData());
    }



    @Test
    public void delete_and_addNode(){
        Tree tree1 = new Tree(1);
        tree1.addNode(new Node(2, new Id(1, 1)), new Id(1, 1));
        tree1.addNode(new Node(3, new Id(1, 1)), new Id(1, 1));
        tree1.addNode(new Node(4, new Id(1, 1)), new Id(2, 1));

        tree1.deleteNode(new Node(2, new Id(2, 1)));

        tree1.addNode(new Node(10, new Id(1, 1)), new Id(3, 1));

        Assert.assertEquals(null, tree1.getNode(new Id(3, 1)));
        Assert.assertEquals(null, tree1.getNode(new Id(4, 1)));
        //Assert.assertEquals("Vertex is not exist! "+null,tree1.getNode(new Id(3,2)));

    }
}
/*
    public void addTree(){
        Tree tree1=new Tree(new Node(1));
        tree1.addNode(new Node(2),1,1);
        tree1.addNode(new Node(3),1,1);


        Tree tree2 = new Tree((new Node(11)));
        tree2.addNode(new Node(22),1,1);
        tree2.addNode(new Node(33),1,1);

        tree1.addTree(tree2,new Id(2,1));

        Assert.assertEquals(1,tree1.getNode(1,1).getData());
        Assert.assertEquals(2,tree1.getNode(2,1).getData());
        Assert.assertEquals(3,tree1.getNode(2,2).getData());
        Assert.assertEquals(11,tree1.getNode(3,1).getData());
        Assert.assertEquals(22,tree1.getNode(4,1).getData());
        Assert.assertEquals(33,tree1.getNode(4,2).getData());

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


        Assert.assertEquals(11,tree2.getNode(1,1).getData());
        Assert.assertEquals(22,tree2.getNode(2,1).getData());
        Assert.assertEquals(33,tree2.getNode(2,2).getData());

        tree2.addNode(new Node(100),2,2);
        Assert.assertEquals(100,tree2.getNode(4,1).getData());

        //4) Проверить что в дереве все id упорядочены сверху вниз.


    }






}
*/