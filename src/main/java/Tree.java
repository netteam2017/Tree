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
            //this.relations.add(0,new Hierarchy(this.head,null,null));
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
       /* while (getRelations().getChildren(tmp) != null) {

            Iterator<Node> itr = getRelations().getChildren(tmp).iterator();
            while (itr.hasNext()) {


                nodeMap.put(new Id(getIdOfNode(tmp).getHeight() + 1, getQuantityNumbers(getIdOfNode(tmp).getHeight() + 1)), itr.next());
                if (itr.hasNext())

                    tmp = itr.next();
                System.out.print(tmp);
            }

        }*/
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
            throw new IndexOutOfBoundsException(("Vertex is not exist! "));
            //  System.out.print("Vertex is not exist! ");
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
        ArrayList<Node> newnode= new ArrayList<>();
        int i=0;
        if ((height < 1) | (number < 1)) {
            throw new IndexOutOfBoundsException("Error! Wrong index! Index must be >1 ");
        } else {


            if (getRelations().getChildren(getNodeOnNumber(height, number))!=null) {
                Iterator<Node> iterator = getRelations().getChildren(getNodeOnNumber(height, number)).iterator();

                while (iterator.hasNext()) {
                    newnode.add(i,iterator.next());
                    i++;


//                    System.out.print("del " + getIdOfNode(newnode.get(i)).getHeight() + getIdOfNode(newnode.get(i)).getNumber());
                }
                for (int k=0;k<newnode.size();k++)
                    deleteNode(getIdOfNode(newnode.get(k)).getHeight(), getIdOfNode(newnode.get(k)).getNumber());

                getRelations().deleteChild(getRelations().getParent(getNodeOnNumber(height, number)), getNodeOnNumber(height, number));
                getRelations().deleteParent(getNodeOnNumber(height, number));
                getNodeMap().remove(new Id(height,number));

            }else{
                System.out.print("tyt ");
                getRelations().deleteChild(getRelations().getParent(getNodeOnNumber(height, number)), getNodeOnNumber(height, number));
                getRelations().deleteParent(getNodeOnNumber(height, number));
                getNodeMap().remove(new Id(height,number));


            }
        }
    }




    public void addNode(Node node,int heightParent, int numberParent) { //good
        Node child = new Node();
        if ((heightParent < 1) | (numberParent < 1)) {
            throw new IndexOutOfBoundsException("Error! Wrong index! Index must be >1 ");

        } else {
            Id id = new Id(heightParent, numberParent);
            Set<Node> nodeSet = new HashSet<Node>();
            nodeSet.add(node);
            if(this.getNodeMap().containsValue(node)){

                getNodeMap().remove(getIdOfNode(node));
                //System.out.print("node parent= "+getRelations().getParent(node) + " node child = "+node);
                this.getRelations().deleteChild(getRelations().getParent(node),node);
            }
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
                // Set<Node> newChildren = new HashSet<>();
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
        node = getNodeOnNumber(id.getHeight(),id.getNumber());
        ArrayList<Node> child = new ArrayList<>();
        help(newTree,node,child);
        return newTree;
    }

    public void help(Tree newTree,Node node,ArrayList<Node> child){
        if (getRelations().getChildren(node).size()!=0){
            int i=0;
            Iterator<Node> iterator= getRelations().getChildren(node).iterator();
            while (iterator.hasNext()){
                child.add(i,iterator.next());
                i++;
            }
            for (int k=0;k<child.size();k++){
                System.out.print(getIdOfNode(node).getNumber());
                newTree.addNode(child.get(k),newTree.getIdOfNode(node).getHeight(),newTree.getIdOfNode(node).getNumber());
               if(getRelations().getChildren(child.get(k))!=null) help(newTree,child.get(k),new ArrayList<Node>());
                //node=child.get(k);
            }


        }

    }
/*
    public ArrayList<Id> helpAdd (Tree newTree,Node node, Id id){
        ArrayList<Id> idChild= new ArrayList<>();
        int i=0;
        int h=1;
        int n=1;
        if (getRelations().getChildren(node)!=null) {
            Iterator<Node> iterator = getRelations().getChildren(node).iterator();
            while (iterator.hasNext()) {
                idChild.add(i, getIdOfNode(iterator.next()));
                i++;
            }
            System.out.print(idChild.size());
            for (int k = 0; k < idChild.size(); k++) {
                newTree.addNode(getNodeOnNumber(idChild.get(k).getHeight(), idChild.get(k).getNumber()), id.getHeight(), id.getNumber());
                //node=getNodeOnNumber(idChild.get(k).getHeight(),idChild.get(k).getNumber());
            }
        }
        return idChild;
    }*/
  /*  public void addTree(Tree newTree,int heightParent,int numberParent){
        Node child = new Node();
        Node node = newTree.getHead();
        if ((heightParent < 1) | (numberParent < 1)) {
            throw new IndexOutOfBoundsException("Error! Wrong index! Index must be >1 ");

        } else {
            Id id = new Id(heightParent, numberParent);
            Set<Node> nodeSet = new HashSet<Node>();
            nodeSet.add(node);

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
                // Set<Node> newChildren = new HashSet<>();
                Iterator<Node> iterator = getRelations().getChildren(node).iterator();
                while (iterator.hasNext()) {
                    child = iterator.next();
                }
                addNode(child, height, number);
                setNodeMap(node);
            }*/

            @Override
            public String toString() {

                return "Tree{" +
                        "head=" + head +
                        //", relations=" + relations +

                        '}';

            }
        }
