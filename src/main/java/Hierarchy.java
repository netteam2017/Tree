import java.util.*;

/**
 * Created by user on 25.11.2017.
 */
public class Hierarchy {
    Map<Node,Set<Node>> children; //тут будет set;
    Map<Node,Node> parent;



    Hierarchy(){
        this.children=new HashMap<>();
        this.parent= new HashMap<>();
    }


    public Node getParent(Node node) {
        return this.parent.get(node);
    }

    public void setRelHead(Node head){
        this.parent.put(head,null);
        this.children.put(head,null);
    }

    public void setParent(Node node,Node parent) {//нужно удалить ребенка от родителя первого
        this.getChildren(getParent(node)).remove(node);
        this.parent.put(node,parent);
        if(this.children.get(parent)==null) {
            Set<Node> childrenList = new HashSet<>();
            childrenList.add(node);
            this.children.put(parent,childrenList);
        }else{
            this.children.get(parent).add(node); //родителю надо передать список а списка с детьми в явном виде нет
        }
    }

    public Set<Node> getChildren(Node node) {
        return this.children.get(node);
    }


    public void setChildren(Node parent, Set<Node> children) {
        if(this.children.get(parent)!=null) {
            this.children.get(parent).addAll(children);
        }else{
            this.children.put(parent,children);
        }

        if (children!=null){
            for(int i=0;i<children.size();i++){
                this.parent.put(children.toArray(new Node[children.size()])[i],parent);
            }
        }
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

    //  public void setChild(Node child){
    //    this.children.add(this.children.size(),child);
    //}




}
