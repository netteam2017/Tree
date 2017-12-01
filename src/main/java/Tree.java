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




    public void addNode(Node node,int heightParent, int numberParent) {
        if((heightParent<1)|(numberParent<1)){
            throw new IndexOutOfBoundsException("Error! Wrong index! Index must be >1 ");

        }
        Id id = new Id(heightParent,numberParent);
        Set<Node> nodeSet = new HashSet<Node>();
        nodeSet.add(node);
        if (getNodeMap().containsKey(id)==true) {

            if (getRelations().getChildren(getNodeMap().get(id))==null){
                getRelations().setChildren(getNodeOnNumber(heightParent,numberParent),new HashSet<Node>());
            }
            getRelations().setChildren(getNodeOnNumber(heightParent,numberParent),nodeSet);
            getRelations().setParent(node,getNodeOnNumber(heightParent,numberParent));
        }
        setNodeMap(node);

        if(getRelations().getChildren(node)!=null)

            for (Node s: getRelations().getChildren(node)){
                System.out.print(getIdOfNode(node).getNumber());
                addNode(s,getIdOfNode(node).getHeight(),getIdOfNode(node).getNumber()-1);
            }

        //добавление в карту доделать!

    }

    @Override
    public String toString() {
        return "Tree{" +
                "head=" + head +
                //", relations=" + relations +

                '}';
    }
}
/*
    public void refreshNodeMap(int number, int quantity,Node node) {
        int size=getNodeMap().size();
        for(int i=1;i<=number;i++) {
            setNodeMap(size + quantity - i, getNodeOnNumber(size - i));
        }
        setNodeMap(number,node);
    }

    public void deleteNode(int numberNode){
        if(getNodeMap().containsKey(numberNode)==true){
            for (int i=0;i<getNodeOnNumber(numberNode).getParent().getChildren().size();i++)
            if(getNodeOnNumber(numberNode).getParent().getChildren().get(i)==getNodeOnNumber(numberNode)){
                getNodeOnNumber(numberNode).getParent().getChildren().remove(i);
                getRelations().setParent(getNodeOnNumber(numberNode),null);
                return;
            }


        }
    }*/


    /*
    private ArrayList<Hierarchy> relations;
    private Map<Integer, Node> nodeMap; //с нуля
    //private int quantity;


    public void setHead(Node head){
        this.head=head;
    }
    public Node getHead(){
        return this.head;
    }

    public ArrayList<Hierarchy> getRelations() {
        return relations;
    }

    public void setRelations(ArrayList relations) {
        this.relations = relations;
    }

    public void setNodeMap(int number, Node node){
        this.nodeMap.put(number,node);
    }
    public Map<Integer,Node> getNodeMap(){
        return this.nodeMap;
    }
    public Node getNumOfObject(int num){/////////
        return this.nodeMap.get(num);
    }

    public Tree(){
        if (nodeMap ==null){
            this.head = new Node();
            this.nodeMap =new HashMap<>();
            this.nodeMap.put(0,head);
            this.relations=new ArrayList<>();
            this.relations.add(0,new Hierarchy(this.head,null,null));
        }else{
            System.out.print("Error. Tree already exist");
        }
    }


    public Tree(Node head, ArrayList<Node> children){
        if (nodeMap ==null){
            this.head=head;
            this.relations=new ArrayList<>();
            relations.add(0,new Hierarchy(this.head,null,children));
            this.nodeMap =new HashMap<>();
            this.nodeMap.put(0,this.head);

            for (int i=0;i<children.size();i++){ //записываем детей в карту
                this.relations.add(relations.size(),new Hierarchy(children.get(i),this.head,null));
                this.nodeMap.put(nodeMap.size(),children.get(i));
            }
        }else{
            System.out.print("Error. Tree already exist");
        }
    }

    public Node getNodeOnNumber(int numberNode) {
        Node tmp = null;
        if (this.nodeMap.containsKey(numberNode) == true) {
            tmp = getNodeMap().get(numberNode);
        } else {
            System.out.print("Vertex is not exist! ");
        }
        return tmp;
    }

    public  void addNode(Node node,int parentNumber){
        for (int i=parentNumber;i<getRelations().size();i++)
            if (getRelations().get(parentNumber).getParent()!=getRelations().get(i).getParent()){
            getRelations().add(i,new Hierarchy(node,getNodeOnNumber(parentNumber),
                    ));
            }

        Node tmp=null;
        tmp=getNodeOnNumber(key);
        if (tmp!=null){ //если узел существует то добавляем
            if(tmp.getChildren()==null){//если у него не было детей, то создаем список
                ArrayList<Node> children = new ArrayList<Node>();
                tmp.setChildList(children);

            }
            tmp.setChildren(node);//добавляем узел в список

            this.getNodeMap().put(quantity,node);//заносим узел в карту
            this.quantity++;//увеличиваем количество узлов

           /* while(tmp.getChildren()!=null)//если это поддерево ,то добавляем его в карту
            {
                for (int i=0;i<tmp.getChildren().size();i++) {
                    this.getNodeMap().put(quantity, tmp.getChildren().get(i));
                    quantity++;
                    tmp = tmp.getChildren().get(i);
                }
            }*/




