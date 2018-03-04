package Project;

import java.io.Serializable;

/**
 * Created by user on 16.11.2017.
 */
public class Node implements Serializable {

    final private Id id;
    final private int data;
    static final int BASIC_DATA = 1;

    public Node(Id id) {
        this.id = id;
        this.data = BASIC_DATA;
    }

    public Node(int data, Id id) {
        this.id = id;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id != null ? id.equals(node.id) : node.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Id getId() {
        return this.id;
    }

    public int getData() {
        return this.data;
    }


    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}

