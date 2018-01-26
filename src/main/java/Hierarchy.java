import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by user on 25.11.2017.
 */
public class Hierarchy implements Serializable {
    private Map<Node, Set<Node>> children;
    private Map<Node, Node> parent;

    Hierarchy() {
        this.children = new HashMap<>();
        this.parent = new HashMap<>();
    }

    public Node getParent(Node node) {
        return this.parent.get(node);
    }

    public void setRelHead(Node head) {
        this.parent.put(head, null);
        this.children.put(head, null);
    }

    public void setParent(Node node, Node parent) {//нужно удалить ребенка от родителя первого
        this.getChildren(getParent(node)).remove(node);
        System.out.print(node);
        this.parent.put(node, parent);
        if (this.children.get(parent) == null) {
            Set<Node> childrenList = new HashSet<>();
            childrenList.add(node);
            this.children.put(parent, childrenList);
        } else {
            this.children.get(parent).add(node);
        }
    }

    public Set<Node> getChildren(Node node) {
        //  System.out.print(this.children.get(node));
        Set<Node> newChildren = new HashSet<>();
        if (this.children.get(node) != null) {
            newChildren.addAll(this.children.get(node));
        }
        return newChildren;
    }


    public void addChildren(Node parent, Set<Node> children) {
        if (this.children.get(parent) != null) {
            this.children.get(parent).addAll(children);
        } else {
            this.children.put(parent, children);
        }
        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                this.parent.put(children.toArray(new Node[children.size()])[i], parent);
            }
        }
    }

    public void deleteChild(Node parent, Node node) {
        if (parent != null) {
            this.children.get(parent).remove(node);
        } else {
            deleteParent(node);
        }
    }

    public void deleteParent(Node node) {
        this.children.get(getParent(node)).remove(node);
        parent.remove(node);
    }

    @Override
    public String toString() {
        return "Hierarchy{" +
                "children=" + children +
                ", parent=" + parent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hierarchy hierarchy = (Hierarchy) o;

        if (children != null ? !children.equals(hierarchy.children) : hierarchy.children != null) return false;
        return parent != null ? parent.equals(hierarchy.parent) : hierarchy.parent == null;
    }

    @Override
    public int hashCode() {
        int result = children != null ? children.hashCode() : 0;
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }
}