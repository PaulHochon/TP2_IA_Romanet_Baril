public class Tree<T> {

    private int rootNodeID;

    public Tree(Node root){
        this.rootNodeID = root.getNodeID();
    }

    public Tree(){
        this.rootNodeID = 0;
    }
}
