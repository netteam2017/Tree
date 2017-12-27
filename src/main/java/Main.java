/**
 * Created by user on 15.11.2017.
 */
public class Main {
    public static void main(String[] args) {

        //  Node nodeTest = new Node();
        Node node1 = new Node(1, new Id(1, 1));
        Node node2 = new Node(2,new Id(1,1));
        Node node3 = new Node(3, new Id(1, 1));
        Node node4 = new Node(4, new Id(1, 1));
        Node node5 = new Node(5, new Id(1, 1));

        Tree tree = new Tree(node1.getData());


        tree.addNode(node2,new Id(1,1));

        tree.addNode(node3, new Id(1, 1));

        tree.addNode(new Node(4, new Id(1, 1)), new Id(2, 1));
        tree.addNode(new Node(5, new Id(1, 1)), new Id(2, 1));
        System.out.println("____________________________");
        ///  Tree tree2 = tree.createTree(new Id(2, 1));
        //  tree.split(new Id(2,1));
        Node node11 = new Node(10, new Id(1, 1));
        Node node22 = new Node(20, new Id(1, 1));
        Node node33 = new Node(30, new Id(1, 1));
        Node node44 = new Node(40, new Id(1, 1));

        Tree tree2 = new Tree(node1.getData());
        tree2.addNode(node22, new Id(1, 1));
        tree2.addNode(node33, new Id(1, 1));
        tree2.addNode(node44, new Id(2, 1));

        // tree.addTree(tree2,new Id(3,1));

        tree.addTree(tree2, new Id(2, 2));
        System.out.println(tree.getNode(new Id(4, 2)));


    }
}

       /* Node node2 = new Node(2);
        Node node3=new Node (3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);
        Node node8=new Node(8);

        Hierarchy rel = new Hierarchy();

        Set<Node> children = new HashSet<>();
        children.add(node2);
        children.add(node3);

        Set<Node> children2 = new HashSet<>();
        children2.add(node4);
        children2.add(node5);


        rel.addChildren(node1,children);
        rel.setParent(node3,node2);
        rel.addChildren(node2,children2);



        Tree tree1= new Tree(node1);



        // System.out.print(tree1.getNodeMap().containsKey(new Id(1,1)));
        tree1.addNode(node4,1,1);
        tree1.addNode(node3,1,1);
        tree1.addNode(node5,1,1);
        tree1.addNode(node6,2,3);
        // tree1.addNode(node7,3,1);
        //tree1.addNode(node7,3,1);
        //tree1.addNode(node7,3,1);
       // tree1.addNode(node5,1,1);
        tree1.addNode(node7,3,1);
        tree1.addNode(node8,3,1);
        // tree1.deleteNode(2,2);
        //tree1.getHierarchy().deleteChild(node4,node5);
        //tree1.deleteNode(2,3);

       // tree1.split(3,1);

       // Tree tree2 = new Tree(new Node(100));
      //  tree1.addTree(tree2,1,1);

      //  tree2.addNode(new Node(33),1,1);
           //     tree1.createTree(new Id(2,3));
       // tree1.deleteNode(2,3);
        //tree1.addTree(tree2,new Id(1,1));
        tree1.deleteNode(1,1);
       // System.out.print(tree1.getNode(1,1));
        tree1.addNode(new Node(), 1,1);
//rel.deleteParent(node3);
        //  System.out.println(tree1.getHierarchy().getChildren(node7).size());




    }

}*/
