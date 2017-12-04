import java.util.ArrayList;

/**
 * Created by user on 16.11.2017.
 */
public class Node {

    final private int data;
    static final int BASIC_DATA=1;




    public Node(){
        this.data=BASIC_DATA;
    }
    public Node(int data){
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return data == node.data;

    }

    @Override
    public int hashCode() {
        return data;
    }

    public int getData(){
        return this.data;
    };




    @Override
    public String toString() {
        return "Node{" +
                " data=" + data +
                '}';
    }
}

