import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 15.11.2017.
 */
public class Main {
    public static void main(String[] args){

        Node nodeTest = new Node();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3=new Node (3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);

        Hierarchy rel = new Hierarchy();

        Set<Node> children = new HashSet<>();
        children.add(node2);
        children.add(node3);

        Set<Node> children2 = new HashSet<>();
        children2.add(node4);
        children2.add(node5);


         rel.setChildren(node1,children);
        rel.setParent(node3,node2);
        rel.setChildren(node2,children2);



        Tree tree1= new Tree(node1);


      // System.out.print(tree1.getNodeMap().containsKey(new Id(1,1)));
        tree1.addNode(node4,1,1);
        tree1.addNode(node3,1,1);
        tree1.addNode(node5,2,1);
        tree1.addNode(node6,3,1);
        //tree1.addNode(node7,3,1);
        tree1.addNode(node5,1,1);
       // System.out.println(tree1.getIdOfNode(node5).getHeight());
        tree1.addNode(node7,3,2);
       System.out.println(tree1.getRelations());




    }

}
