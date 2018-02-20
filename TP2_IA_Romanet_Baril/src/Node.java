import java.util.ArrayList;
import java.util.List;

public class Node {

    private int nodeID;
    public void setNodeID(int nodeID) { this.nodeID = nodeID;}
    public int getNodeID() { return nodeID; }

    private Node parent;
    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
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

    private int cost;
    public int getCost() {
        return hcost + pathCost;
    }

    // variable used for the heuristic
    private int hcost;
    public int gethCost() {
        return hcost;
    }
    public void setHcost(int hcost) {
        this.hcost = hcost;
    }

    // path cost to this node from root
    private int pathCost;
    public int getPathCost() {
        return pathCost;
    }
    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public Node(int nodeID) {
        this.nodeID = nodeID;
        children = new ArrayList<Node>();
    }

    public Node Tree_Search(Problem problem, String strategy, List<Node> frontier) {
        frontier.add(new Node(problem.getInitialState().getNodeID()));

        while (!frontier.isEmpty()){
            Node nextNode = RemoveFront(frontier);
            if(problem.TestGoal(nextNode)){
                return nextNode;
            }
            // expand
            frontier.addAll(Expand(nextNode,problem));
        }
        return null;
    }

    public Node RemoveFront(List<Node> frontier){
        Node chosenNode = new Node(-1);
        int maxCost = Integer.MAX_VALUE;

        for(Node item : frontier)
        {
            if(item.getCost()<maxCost){
                chosenNode = item;
                maxCost = item.getCost();
            }
        }

        frontier.remove(chosenNode);

        return chosenNode;
    }

    public List<Node> Expand(Node node, Problem problem){
        List<Node> solution = new ArrayList<>();

        for (Node child : problem.S(node))
        {
            Node s = new Node(-1);
            s.setParent(node);
            s.setNodeID(child.getNodeID());
            s.setPathCost(node.getPathCost() + problem.getTravelCost(node,child));
            s.setDepth(node.getDepth() + 1);
            solution.add(s);
        }

        return solution;
    }

}



