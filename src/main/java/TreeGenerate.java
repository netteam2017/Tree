import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 16.11.2017.
 */

public class TreeGenerate {
    private Node head;
    private Map<Integer, Node> id;
    private int quantity;


    public TreeGenerate(){ //
        if (id==null){
            this.head = new Node();
            this.id.put(0,head);
            this.quantity=1;
        }else{
            System.out.print("Error. Tree already exist");
        }
    }

    public TreeGenerate(int data, ArrayList<Node> child){
        if (id==null){
            this.head=new Node(data,child);
            this.id=new HashMap<>();
            this.id.put(0,this.head);
            this.quantity=1;
            for (int i=0;i<child.size();i++){ //записываем детей в карту
                this.quantity++;
                this.id.put(i,child.get(i));
            }

        }
    }

    public TreeGenerate(Node node, ArrayList<Node> child){
        if (id==null){
            this.head=node;
            this.id=new HashMap<>();
            this.id.put(0,this.head);
            this.quantity=1;
            for (int i=0;i<child.size();i++){ //записываем детей в карту
                this.quantity++;
                this.id.put(i,child.get(i));
            }

        }
    }

    public Node getNodeOnNumber(int key) {
        Node tmp = null;
        if (this.id.containsKey(key) == true) {
            tmp = getId().get(key);
        } else {
            System.out.print("Vertex is not exist! ");
        }
        return tmp;
    }
    public  void addNode(Node node,int key){
        Node tmp=null;
        tmp=getNodeOnNumber(key);
        if (tmp!=null){ //если узел существует то добавляем
            if(tmp.getChild()==null){//если у него не было детей, то создаем список
                ArrayList<Node> children = new ArrayList<Node>();
                tmp.setChildList(children);

            }
            tmp.setChild(node);//добавляем узел в список

            this.getId().put(quantity,node);//заносим узел в карту
            this.quantity++;//увеличиваем количество узлов

           /* while(tmp.getChild()!=null)//если это поддерево ,то добавляем его в карту
            {
                for (int i=0;i<tmp.getChild().size();i++) {
                    this.getId().put(quantity, tmp.getChild().get(i));
                    quantity++;
                    tmp = tmp.getChild().get(i);
                }
            }*/
        }

    }
    public int getQuantity(){
        return quantity;
    }

    public void setHead(Node head){
        this.head=head;
    }
    public void setId(int key,Node head){
        this.id.put(key,head);
    }

    public Node getHead(){
        return this.head;
    }
    public Map<Integer,Node> getId(){
        return this.id;
    }
    public Node getIdOfObject(int num){/////////
        return this.id.get(num);
    }
}
