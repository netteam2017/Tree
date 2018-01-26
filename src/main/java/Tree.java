import java.io.Serializable;
import java.util.*;
/*
/**
 * Created by user on 16.11.2017.
 */

public class Tree implements Serializable {
    private Node head;
    private Hierarchy hierarchy;
    private Map<Id, Node> nodeMap;

    public Tree(int data) {
        if (nodeMap == null) {
            this.head = new Node(data, new Id(1, 1));
            this.hierarchy = new Hierarchy();
            this.nodeMap = new HashMap<>();
            hierarchy.setRelHead(this.head);
            hierarchy.addChildren(this.head, null);
            this.nodeMap.put(new Id(1, 1), head);

        } else {
            System.out.print("Error. Tree already exist");
        }
    }

    public Tree() {
        if (nodeMap == null) {
            this.head = new Node(new Id(1, 1));
            this.nodeMap = new HashMap<>();
            this.nodeMap.put(head.getId(), head);
            this.hierarchy = new Hierarchy();

        } else {
            System.out.print("Error. Tree already exist");
        }
    }

    public Node getNode(Id id) {
        Node tmp = null;

        if (this.nodeMap.containsKey(id) == true) {
            tmp = getNodeMap().get(id);
        } else {
            System.out.print("Vertex is not exist! " + id);
        }
        return tmp;
    }

    public Map<Id, Node> getNodeMap() {
        return this.nodeMap;
    }

    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    public Node getHead() {
        return this.head;
    }

    public Id getIdOfNode(Node node) {
        Id id = new Id(0, 0);
        Set<Map.Entry<Id, Node>> entrySet = getNodeMap().entrySet();
        for (Map.Entry<Id, Node> pair : entrySet) {
            if (node.equals(pair.getValue())) {
                id = pair.getKey();
                return pair.getKey();
            }
        }
        return id;
    }

    public Id getNewNodeId(Node parent) {
        int height = parent.getId().getHeight();
        Id newId = new Id(height + 1, getQuantityNumbers(height + 1) + 1);
        return newId;
    }

    public int getQuantityNumbers(int height) {
        int quantity = 0;
        Set<Map.Entry<Id, Node>> entrySet = getNodeMap().entrySet();
        for (Map.Entry<Id, Node> pair : entrySet) {
            if (pair.getKey().getHeight() == height) {
                quantity = quantity + 1;
            }
        }
        return quantity;
    }

    public void rememberNodeMap(Node node) {
        Id id;
        if (nodeMap == null) {
            id = new Id(1, 1);
        } else {
        }

        nodeMap.put(node.getId(), node);
    }

    public void deleteNode(Node node) {
        if (getNodeMap().containsValue(node) == false) {
            return;
        } else {
            ArrayList<Node> newnode = new ArrayList<>(getHierarchy().getChildren(node));
            for (Node ch : newnode) {
                if (ch != null)
                    deleteNode(ch);
            }
            getHierarchy().deleteChild(getHierarchy().getParent(node), node);
            getNodeMap().remove(node.getId());
        }
    }

    public Node addNode(Node node, Id id) {
        if (getNode(id) == null) {
            return null;
        }
        Node tmp = new Node(node.getData(), this.getNewNodeId(getNode(id)));
        Node child = new Node(new Id(1, 1));
        rememberNodeMap(tmp);
        Set<Node> nodeSet = new HashSet<Node>();
        nodeSet.add(tmp);
        getHierarchy().addChildren(getNode(id), nodeSet);
        return tmp;
    }

    public void addNodeForSplit(Node node, Id id) {
        if (getNode(id) == null) {
            return;
        }
        Node tmp = new Node(node.getData(), getNewNodeId(getNode(id)));
        rememberNodeMap(tmp);
        Set<Node> nodeSet = new HashSet<Node>();
        nodeSet.add(tmp);
        if (this.getNodeMap().containsValue(node)) {
            getNodeMap().remove(node.getId());
            this.getHierarchy().deleteChild(getHierarchy().getParent(node), node);
        }
        getHierarchy().addChildren(getNode(id), nodeSet);
    }

    public void split(Id id) {
        ArrayList<Node> children = new ArrayList<>(getHierarchy().getChildren(getNode(id)));
        if (getNodeMap().containsKey(id)) {
            Node parent = getHierarchy().getParent(getNode(id));
            if (getHierarchy().getChildren(getNode(id)) != null) {
                for (Node ch : children) {
                    System.out.println(getIdOfNode(parent).getHeight());
                    addNodeForSplit(ch, getIdOfNode(parent));
                }
            }
            deleteNode(getNode(id));
        } else {
            System.out.print("Error of id");
        }
    }

    public Tree(Tree otherTree) {
        this.head = otherTree.getHead();
        this.nodeMap = otherTree.getNodeMap();
        this.hierarchy = otherTree.getHierarchy();
    }

    public Tree createTree(Id id) {
        Tree newTree = new Tree(getNode(id).getData());
        Node node = getNode(id);
        ArrayList<Node> child = new ArrayList<>();
        collect(newTree, newTree.getHead(), node);
        return newTree;
    }

    public void collect(Tree newTree, Node newnode, Node node) {
        ArrayList<Node> children = new ArrayList<>(getHierarchy().getChildren(node));
        if (children != null) {
            if (children.size() != 0) {
                for (Node ch : children) {
                    System.out.println("Idnew " + newTree.getIdOfNode(node).getHeight());
                    Node newNode = newTree.addNode(ch, newnode.getId());
                    if (getHierarchy().getChildren(ch) != null)
                        collect(newTree, newNode, ch);
                }
            }
        }
    }

    public void addTree(Tree newTree, Id idParent) {
        Node node = newTree.getHead();
        System.out.println("head = " + node);
        Node tmp;
        tmp = addNode(node, idParent);
        System.out.println("tmp = " + tmp);
        ArrayList<Node> children = new ArrayList<>(newTree.getHierarchy().getChildren(node));
        if (children != null) {
            if (children.size() != 0) {
                for (Node child : children) {
                    addTreeInternal(newTree, node.getId(), tmp.getId());
                }
            }
        }
    }

    public void addTreeInternal(Tree newTree, Id idParentSource, Id idParentTarget) { //source -из текущего target - куда в новом дереве.
        Node node = getNode(new Id(idParentSource.getHeight(), idParentSource.getNumber()));
        System.out.println("node = " + node);
        System.out.println("target = " + idParentTarget);
        ArrayList<Node> children = new ArrayList<>(newTree.getHierarchy().getChildren(node));
        if (children != null) {
            if (children.size() != 0) {
                for (Node child : children) {
                    Node tmp = addNode(child, idParentTarget);
                    addTreeInternal(newTree, child.getId(), tmp.getId());
                }
            }
        }
    }

    @Override
    public String toString() {

        return "Tree{" +
                "head=" + head +
                //", hierarchy=" + hierarchy +

                '}';
    }
}