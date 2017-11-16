import java.util.ArrayList;
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
            this.id.put(0,this.head);
            this.quantity=1;
            for (int i=0;i<child.size();i++){ //записываем детей в карту
                this.quantity++;
                this.id.put(i,child.get(i));
            }

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
