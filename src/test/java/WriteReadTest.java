import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by user on 14.01.2018.
 */

public class WriteReadTest {
    @Test
    public void outSerialize() {

    }

    @Test
    public void inSerialize() throws IOException {
        Node node1 = new Node(1, new Id(1, 1));
        Node node2 = new Node(2, new Id(1, 1));
        Node node3 = new Node(3, new Id(1, 1));
        Node node4 = new Node(4, new Id(1, 1));
        Node node5 = new Node(5, new Id(1, 1));
        Tree tree = new Tree(node1.getData());


        tree.addNode(node2, new Id(1, 1));

        tree.addNode(node3, new Id(1, 1));

        tree.addNode(new Node(4, new Id(1, 1)), new Id(2, 1));
        tree.addNode(new Node(5, new Id(1, 1)), new Id(2, 1));

        Tree tree1;
        WriteRead writeRead = new WriteRead();
        tree1 = writeRead.inSerialize(1);//я добавила сюда  единицу,что здесь должно быть?!
        System.out.println(tree1.getNodeMap());

        if (tree.equals(tree1)) {
            System.out.println("ууииии");
        } else {
            System.out.println("лажа");
        }
    }

}
