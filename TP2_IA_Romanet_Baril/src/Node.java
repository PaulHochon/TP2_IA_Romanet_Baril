import java.util.ArrayList;
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

    public Node getChild(int i) {
        if (children == null || children.size() == 0) {
            return null;
        }
        return children.get(i);
    }

    public Node(int nodeID) {
        this.nodeID = nodeID;
        parents = new ArrayList<Node>();
        children = new ArrayList<Node>();
    }

    public void AddChild(Node child) {
        children.add(child);
    }

    public void AddParent(Node parent) {
        parents.add(parent);
    }

    public List<Node> getParents() {
        return parents;
    }

    public void setParents(List<Node> parents) {
        this.parents = parents;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}



