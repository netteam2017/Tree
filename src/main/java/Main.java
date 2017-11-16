import java.util.ArrayList;

/**
 * Created by user on 15.11.2017.
 */
public class Main {
    public static void main(String[] args){

        Node node = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node head=null;

        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(0,node);
        nodes.add(1,node2);
        nodes.add(2,node3);

        TreeGenerate Tree = new TreeGenerate(45,nodes);
        System.out.println(Tree.getIdOfObject(0).getData());
        System.out.println(Tree.getIdOfObject(1).getData());
        System.out.println(Tree.getIdOfObject(2).getData());
        System.out.println(Tree.getIdOfObject(3).getData());



}

}
