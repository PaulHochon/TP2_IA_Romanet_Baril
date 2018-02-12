public class Node<T> {

    private int nodeID;
    public int getNodeID() {
        return nodeID;
    }

    private Node[] parents;
    private Node[] children;
    private int depth;
    private int cost;

    public Node getChild(int i){
        if(children==null||children.length==0){
            return null;
        }
        return children[i];
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public Node[] getParents() {
        return parents;
    }

    public void setParents(Node[] parents) {
        this.parents = parents;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

