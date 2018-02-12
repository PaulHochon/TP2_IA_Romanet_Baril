import java.util.List;

public class Node {

    private int nodeID;
    public int getNodeID() {
        return nodeID;
    }

    private List<Node> parents;
    private List<Node> children;
    private int depth;
    // cost to reach this node from root
    private int cost;

    public Node(int nodeID) {
        this.nodeID = nodeID;
    }

    public void AddChild(Node child){
        children.add(child);
    }

    public void AddParent(Node parent){
        parents.add(parent);
    }

}

