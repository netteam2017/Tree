import java.util.*;
/*
/**
 * Created by user on 16.11.2017.
 */

public class Tree {
    private Node head;
    private Hierarchy relations;
    private Map<Id, Node> nodeMap;

    public Tree(Node node) {
        if (nodeMap == null) {
            this.head = node;
            this.relations = new Hierarchy();
            this.nodeMap = new HashMap<>();
            relations.setRelHead(this.head);
            relations.setChildren(this.head,null);
            this.nodeMap.put(new Id(1, 1), head);

        } else {
            System.out.print("Error. Tree already exist");
        }
    }

    public Tree() {
        if (nodeMap == null) {
            this.head = new Node();
            this.nodeMap = new HashMap<>();

            this.nodeMap.put(new Id(1, 1), head);
            this.relations = new Hierarchy();

        } else {
            System.out.print("Error. Tree already exist");
        }
    }

    public Map<Id, Node> getNodeMap() {
        return this.nodeMap;
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

    public void setNodeMap(Node node) {
        Node tmp = node;
        if (nodeMap == null) {
            Id id = new Id(1, 1);
            nodeMap.put(id, node);
        } else {
            Id id = new Id(getIdOfNode(getRelations().getParent(node)).getHeight() + 1, getRelations().getChildren(getRelations().getParent(node)).size());
            nodeMap.put(id, node);
        }

    }


    public Hierarchy getRelations() {
        return relations;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return this.head;
    }


    public Node getNodeOnNumber(int height, int number) {
        Node tmp = null;
        Id id = new Id(height, number);
        if (this.nodeMap.containsKey(id) == true) {
            tmp = getNodeMap().get(id);
        } else {
            System.out.print("Vertex is not exist! ");
        }
        return tmp;
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

    public void deleteNode(int height,int number) {
        if (getNodeOnNumber(height, number)!=null) {
            ArrayList<Node> newnode = new ArrayList<>();
            int i = 0;
            if ((height < 1) | (number < 1)) {
                throw new IndexOutOfBoundsException("Error! Wrong index! Index must be >1 ");
            } else {


                if (getRelations().getChildren(getNodeOnNumber(height, number)) != null) {
                    Iterator<Node> iterator = getRelations().getChildren(getNodeOnNumber(height, number)).iterator();

                    while (iterator.hasNext()) {
                        newnode.add(i, iterator.next());
                        i++;
                    }
                    for (int k = 0; k < newnode.size(); k++)
                        deleteNode(getIdOfNode(newnode.get(k)).getHeight(), getIdOfNode(newnode.get(k)).getNumber());

                    getRelations().deleteChild(getRelations().getParent(getNodeOnNumber(height, number)), getNodeOnNumber(height, number));
                    getRelations().deleteParent(getNodeOnNumber(height, number));
                    getNodeMap().remove(new Id(height, number));

                } else {

                    getRelations().deleteChild(getRelations().getParent(getNodeOnNumber(height, number)), getNodeOnNumber(height, number));
                    getRelations().deleteParent(getNodeOnNumber(height, number));
                    getNodeMap().remove(new Id(height, number));


                }
            }
        }
    }




    public void addNode(Node node,int heightParent, int numberParent) { //good
        Node child = new Node();
        if(getNodeOnNumber(heightParent,numberParent)!=null)
        if ((heightParent < 1) | (numberParent < 1)) {
            throw new IndexOutOfBoundsException("Error! Wrong index! Index must be >1 ");

        } else {
            Id id = new Id(heightParent, numberParent);
            Set<Node> nodeSet = new HashSet<Node>();
            nodeSet.add(node);
          /*
          блок нужен для того чтобы перенести существующие узлы  на др узел в этом же дереве
          if(this.getNodeMap().containsValue(node)){

                getNodeMap().remove(getIdOfNode(node));
                //System.out.print("node parent= "+getRelations().getParent(node) + " node child = "+node);
                this.getRelations().deleteChild(getRelations().getParent(node),node);
            }*/
            if (getNodeMap().containsKey(id) == true) {
                if (getRelations().getChildren(getNodeMap().get(id)) == null) {
                    getRelations().setChildren(getNodeOnNumber(heightParent, numberParent), new HashSet<Node>());
                }
                getRelations().setChildren(getNodeOnNumber(heightParent, numberParent), nodeSet);
                getRelations().setParent(node, getNodeOnNumber(heightParent, numberParent));
            }
            setNodeMap(node);
            int height = getIdOfNode(node).getHeight();
            int number = getIdOfNode(node).getNumber();
            if (getRelations().getChildren(node) != null) {
                Iterator<Node> iterator = getRelations().getChildren(node).iterator();
                while (iterator.hasNext()) {
                    child = iterator.next();
                }
                addNode(child, height, number);
                setNodeMap(node);
            }
        }
    }

    public void split(int height,int number){
        ArrayList<Node> children = new ArrayList<>();
        int i=0;
        if (getNodeMap().containsKey(new Id(height, number))){
            Node parent = new Node();
            parent = getRelations().getParent(getNodeOnNumber(height, number));
            System.out.print(getIdOfNode(parent).getHeight()+"trt"+getIdOfNode(parent).getNumber());
            if(getRelations().getChildren(getNodeOnNumber(height,number))!=null){
                Iterator<Node> iterator = getRelations().getChildren(getNodeOnNumber(height, number)).iterator();
                while (iterator.hasNext()){
                    children.add(i,iterator.next());
                }
                for (int k=0;k<children.size();k++)
                    addNode(children.get(k),getIdOfNode(parent).getHeight(),getIdOfNode(parent).getNumber());
            }
            deleteNode(height,number);

        }else{
            System.out.print("Error of id");
        }
    }

    public Tree(Tree otherTree){
        this.head=otherTree.getHead();
        this.nodeMap=otherTree.getNodeMap();
        this.relations=otherTree.getRelations();
    }

    public Tree createTree(Id id){

        Tree newTree= new Tree(getNodeOnNumber(id.getHeight(),id.getNumber()));
        Node node = new Node();
        node = getNodeOnNumber(id.getHeight(),id.getNumber());System.out.print(newTree.getRelations());
        ArrayList<Node> child = new ArrayList<>();
        help(newTree,node,child);
        return newTree;
    }

    public void help(Tree newTree,Node node,ArrayList<Node> child){
        if(getRelations().getChildren(node)!=null){
        if (getRelations().getChildren(node).size()!=0) {
            int i = 0;
            Iterator<Node> iterator = getRelations().getChildren(node).iterator();
            while (iterator.hasNext()) {
                child.add(i, iterator.next());
                i++;
            }
            for (int k = 0; k < child.size(); k++) {
                newTree.addNode(child.get(k), newTree.getIdOfNode(node).getHeight(), newTree.getIdOfNode(node).getNumber());
                if (getRelations().getChildren(child.get(k)) != null)
                    help(newTree, child.get(k), new ArrayList<Node>());
            }
        }


        }

    }

    public void addTree(Tree newTree,Id idParent){
        Node node = new Node();
        node = newTree.getHead();
        Node child = new Node();
        addNode(node,idParent.getHeight(),idParent.getNumber());
        if (newTree.getRelations().getChildren(node)!=null) {
            if (newTree.getRelations().getChildren(node).size() != 0) {
                Iterator<Node> iterator = newTree.getRelations().getChildren(node).iterator();
                while (iterator.hasNext()) {
                    child = iterator.next();
                    newTree = newTree.createTree(newTree.getIdOfNode(child));

                    addTree(newTree, getIdOfNode(node));
                }
            }

        }
    }
            @Override
            public String toString() {

                return "Tree{" +
                        "head=" + head +
                        //", relations=" + relations +

                        '}';

            }
        }
