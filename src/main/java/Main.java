/**
 * Created by user on 15.11.2017.
 */
public class Main {
    public static void main(String[] args) {

// Node nodeTest = new Node();
        Task node1 = new Task("1", "2", new Id(1, 1));
        Task node2 = new Task("2", "2", new Id(1, 1));
        Task node3 = new Task("3", "2", new Id(1, 1));

        TaskTree tree = new TaskTree(node1);


WriteRead writeRead = new WriteRead();
        tree = writeRead.inSerialize();
        System.out.println(tree.getNodeMap());


    }
}