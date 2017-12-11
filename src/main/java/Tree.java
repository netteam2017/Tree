import java.util.*;
/*
/**
 * Created by user on 16.11.2017.
 */

public class Tree {
    private Node head;
    private Hierarchy hierarchy;
    private Map<Id, Node> nodeMap;

    public Tree(Node node) {
        if (nodeMap == null) {
            this.head = node;
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
            this.head = new Node(new Id(1,1));
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
            System.out.print("Vertex is not exist! ");
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


    public Id getNewNodeId(Node parent){
        int height=parent.getId().getHeight();
        System.out.println(height);
        Id newId = new Id(height+1,getQuantityNumbers(height+1)+1);
        return newId;
    }
    public int getQuantityNumbers(int height) {
        int quantity = 0;
        Set<Map.Entry<Id, Node>> entrySet = getNodeMap().entrySet();
        for (Map.Entry<Id, Node> pair : entrySet) {
            if (pair.getKey().getHeight() == height) {
                quantity = quantity + pair.getKey().getNumber();
            }

        }
        return quantity;
    }
    public void rememberNodeMap(Node node) {
        //Node tmp = node;
        Id id;
        if (nodeMap == null) {
             id = new Id(1, 1);
        } else {
            // id = getNewNodeId(getHierarchy().getParent(node));
//             id = new Id(getIdOfNode(getHierarchy().getParent(node)).getHeight() + 1, getHierarchy().getChildren(getHierarchy().getParent(node)).size());
        }
       // Node tmp = new Node(node.getData(),id);
        nodeMap.put(node.getId(), node);
    }





    public void deleteNode(Id id) {
        if (getNode(id) == null) {
            return;
        }
        ArrayList<Node> newnode = new ArrayList<>();
        int i = 0;

        if (getHierarchy().getChildren(getNode(id)) != null) {
            Iterator<Node> iterator = getHierarchy().getChildren(getNode(id)).iterator();

            while (iterator.hasNext()) {
                newnode.add(i, iterator.next());
                i++;
            }
            for (int k = 0; k < newnode.size(); k++)
                deleteNode(getIdOfNode(newnode.get(k)));

            getHierarchy().deleteChild(getHierarchy().getParent(getNode(id)), getNode(id));
            getHierarchy().deleteParent(getNode(id));
            getNodeMap().remove(id);

        } else {//переделать склеить

            getHierarchy().deleteChild(getHierarchy().getParent(getNode(id)), getNode(id));
            getHierarchy().deleteParent(getNode(id));
            getNodeMap().remove(id);


        }


    }


    public void addNode(Node node, Id id) { //good
        if (getNode(id) == null) {
            return;
        }
        Node tmp = new Node(node.getData(),getNewNodeId(getNode(id)));
        Node child = new Node(new Id(1,1));

        rememberNodeMap(tmp);

        Set<Node> nodeSet = new HashSet<Node>();
        nodeSet.add(getNodeMap().get(getNewNodeId(getNode(id))));

         // блок нужен для того чтобы перенести существующие узлы  на др узел в этом же дереве
        /*if(this.getNodeMap().containsValue(node)){
            getNodeMap().remove(getIdOfNode(node));
                //System.out.print("node parent= "+getHierarchy().getParent(node) + " node child = "+node);
            this.getHierarchy().deleteChild(getHierarchy().getParent(node),node);
        }*/

       /* if (getHierarchy().getChildren(getNodeMap().get(id)) == null) {
             getHierarchy().addChildren(getNode(id), new HashSet<Node>());
         }//перенести это в addchildren*/

        getHierarchy().addChildren(getNode(id), nodeSet);
       // getHierarchy().setParent(node, getNode(id));

        Id childId = tmp.getId();//надо изменить node

        ArrayList<Node> children = new ArrayList<>(getHierarchy().getChildren(node));
       // if(getHierarchy().getChildren(node)!=null) {
            /*Iterator<Node> iterator = getHierarchy().getChildren(node).iterator();
            while (iterator.hasNext()) {
                child = iterator.next();
            }
            System.out.print("kikik");*/
            for (Node ch:children) {
                if (ch!=null)
                addNode(ch, childId);
            }

           // rememberNodeMap(node);


    }/*

    public void split(int height, int number) {
        ArrayList<Node> children = new ArrayList<>();
        int i = 0;
        if (getNodeMap().containsKey(new Id(height, number))) {
            Node parent = new Node();
            parent = getHierarchy().getParent(getNode(height, number));
           // System.out.print(getIdOfNode(parent).getHeight() + "trt" + getIdOfNode(parent).getNumber());
            if (getHierarchy().getChildren(getNode(height, number)) != null) {
                Iterator<Node> iterator = getHierarchy().getChildren(getNode(height, number)).iterator();
                while (iterator.hasNext()) {
                    children.add(i, iterator.next());
                }
                for (int k = 0; k < children.size(); k++)
                    addNode(children.get(k), getIdOfNode(parent).getHeight(), getIdOfNode(parent).getNumber());
            }
            deleteNode(height, number);

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

        Tree newTree = new Tree(getNode(id.getHeight(), id.getNumber()));
        Node node = new Node();
        node = getNode(id.getHeight(), id.getNumber());
        //System.out.print(newTree.getHierarchy());
        ArrayList<Node> child = new ArrayList<>();
        collect(newTree, node, child);
        return newTree;
    }

    public void collect(Tree newTree, Node node, ArrayList<Node> child) {
        if (getHierarchy().getChildren(node) != null) {
            if (getHierarchy().getChildren(node).size() != 0) {
                int i = 0;
                Iterator<Node> iterator = getHierarchy().getChildren(node).iterator();
                while (iterator.hasNext()) {
                    child.add(i, iterator.next());
                    i++;
                }
                for (int k = 0; k < child.size(); k++) {
                    newTree.addNode(child.get(k), newTree.getIdOfNode(node).getHeight(), newTree.getIdOfNode(node).getNumber());
                    if (getHierarchy().getChildren(child.get(k)) != null)
                        collect(newTree, child.get(k), new ArrayList<Node>());
                }
            }


        }

    }

    public void addTree(Tree newTree, Id idParent) {
        Node node = new Node();
        node = newTree.getHead();
        Node child = new Node();
        addNode(node,idParent.getHeight(),idParent.getNumber());
        if (newTree.getHierarchy().getChildren(node) != null) {
            if (newTree.getHierarchy().getChildren(node).size() != 0) {
                Iterator<Node> iterator = newTree.getHierarchy().getChildren(node).iterator();
                while (iterator.hasNext()) {
                    child = iterator.next();
                   // newTree = newTree.createTree(newTree.getIdOfNode(child));
                    addNode(child, idParent.getHeight(), idParent.getNumber());
                   // addTree(newTree, getIdOfNode(node));
                }
            }

        }
    }

    public void addTreeInternal(Tree newTree,Id idParentSource,Id idParentTarget){
        Node node = new Node();
        node = getNode(idParentSource.getHeight(),idParentTarget.getNumber());
        Node child = new Node();

        if (newTree.getHierarchy().getChildren(node) != null) {
            if (newTree.getHierarchy().getChildren(node).size() != 0) {
                Iterator<Node> iterator = newTree.getHierarchy().getChildren(node).iterator();
                while (iterator.hasNext()) {
                    child = iterator.next();
                    // newTree = newTree.createTree(newTree.getIdOfNode(child));
                    addNode(child, idParent.getHeight(), idParent.getNumber());//target!!
                    // addTree(newTree, getIdOfNode(node));
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

    }*/
}
