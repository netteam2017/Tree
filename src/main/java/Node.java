import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16.11.2017.
 */
public class Node {
    private ArrayList<Node> child;
    private int data;
    static final int BASIC_DATA=1;

    public Node(){
        this.child=null;
        this.data=BASIC_DATA;
    }
    public Node(int data, ArrayList<Node> child){
        this.child=child;
        this.data = data;
    }

    public int getData(){
        return this.data;
    };
    public void setData(int data){
        this.data = data;
    };
    public ArrayList<Node> getChild(){
        return this.child;
    };
    public void setChild(ArrayList<Node> child){
        this.child=child;
    };


}