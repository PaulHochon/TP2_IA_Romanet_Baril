import java.util.ArrayList;
import java.util.List;

public class Node {

    private int nodeID;
    public int getNodeID() {
        return nodeID;
    }

    private List<Node> parents;
    public List<Node> getParents() {
        return parents;
    }

    private List<Node> children;
    public List<Node> getChildren() {
        return children;
    }

    private int depth;
    // cost to reach this node from root
    private int cost;

    public Node(int nodeID) {
        this.nodeID = nodeID;
        parents = new ArrayList<Node>();
        children = new ArrayList<Node>();
    }

    public void AddChild(Node child){
        children.add(child);
    }

    public void AddParent(Node parent){
        parents.add(parent);
    }

}

