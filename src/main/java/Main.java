import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * Created by user on 15.11.2017.
 */
public class Main {
    public static void main(String[] args){

        Node nodeTest = new Node();
        Node node = new Node(0,null);
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,null);
        Node node3 = new Node(3,null);

        Node node4 = new Node(44,null);
        Node node5 = new Node(55,null);
        Node node6 = new Node(66,null);
        Node node7 = new Node(77,null);
        Node node8 = new Node(88,null);


        Node head=null;

        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(0,node);
        nodes.add(1,node1);
        nodes.add(2,node2);
        nodes.add(3,node3);





        TreeGenerate Tree1 = new TreeGenerate(node7,nodes);

        Tree1.addNode(node8,1);
        //    Tree2.getHead().getChild().get(1).setChildList(nodes2);
         System.out.println(Tree1.getIdOfObject(0).getData());
         System.out.println(Tree1.getIdOfObject(1).getData());

        System.out.println(Tree1.getIdOfObject(2).getData());
        System.out.println(Tree1.getIdOfObject(3).getData());

        System.out.println(Tree1.getNodeOnNumber(4).getData());
//  System.out.println(Tree.getIdOfObject(2).getData());
        System.out.print(node);
//        System.out.println(Tree.getIdOfObject(3).getData());



    }

}
