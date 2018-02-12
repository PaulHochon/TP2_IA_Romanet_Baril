public class Tree<T> {

    private int rootNodeID;
    private Node rootNode;
    public Problem problem;

    public Tree(Node root){
        this.rootNodeID = root.getNodeID();
    }

    public Tree(){
        this.rootNodeID = 0;
    }


    public int getRootNodeID() {
        return rootNodeID;
    }

    public void setRootNodeID(int rootNodeID) {
        this.rootNodeID = rootNodeID;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }
}
