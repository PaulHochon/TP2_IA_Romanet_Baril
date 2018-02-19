import java.util.ArrayList;
import java.util.List;

public class Node {

    private int nodeID;
    public int getNodeID() { return nodeID; }

    private List<Node> parents;
    public List<Node> getParents() {
        return parents;
    }
    public void setParents(List<Node> parents) {
        this.parents = parents;
    }

    public void AddParent(Node parent) {
        parents.add(parent);
    }


    private List<Node> children;
    public List<Node> getChildren() { return children; }
    public void setChildren(List<Node> children) { this.children = children; }

    public void AddChild(Node child) {
        children.add(child);
    }

    public Node getChild(int i) {
        if (children == null || children.size() == 0) {
            return null;
        }
        return children.get(i);
    }

    private int depth;
    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }

    // variable used for the heuristic
    private int cost;
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }


    public Node(int nodeID) {
        this.nodeID = nodeID;
        parents = new ArrayList<Node>();
        children = new ArrayList<Node>();
    }
}



