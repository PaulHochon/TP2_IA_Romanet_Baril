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
        return hCost + pathCost;
    }

    // variable used for the heuristic
    private int hCost;
    public int gethCost() {
        return hCost;
    }
    public void setHcost(int hCost) {
        this.hCost = hCost;
    }

    // path cost to this node from root
    private int pathCost;
    public int getPathCost() {
        return pathCost;
    }
    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    private boolean isExplored = false;

    public Node(int nodeID, int hCost) {
        this.nodeID = nodeID;
        parent = null;
        children = new ArrayList<Node>();
        depth = 0;
        this.hCost = hCost;
    }

    public Node Tree_Search(Problem problem, String strategy, List<Node> frontier) {
        frontier.add(new Node(problem.getInitialState().getNodeID(), problem.getMapping().get(problem.getInitialState().getNodeID())));

        while (!frontier.isEmpty()){
            Node nextNode = RemoveFront(frontier,strategy);
            if(problem.TestGoal(nextNode)){
                return nextNode;
            }
            // expand
            frontier.addAll(Expand(nextNode,problem));
        }
        return null;
    }

    // In this function strategy matters
    // the node you pick from the frontier changes depending on the strategy
    // here we pick the most promising node
    public Node RemoveFront(List<Node> frontier,String strategy){
        Node chosenNode = new Node(-1,0);

        switch (strategy){
            case "AStarSearch":
                int maxCost = Integer.MAX_VALUE;

                for(Node item : frontier)
                {
                    if(item.getCost()<maxCost){
                        chosenNode = item;
                        maxCost = item.getCost();
                    }
                }

                frontier.remove(chosenNode);
                break;
                default:
                    // random
                    int i = (int)Math.random()*(frontier.size() - 1);

                    // always returns 4 10 12
                    /*int i = -1;
                    do {
                        i++;
                    }
                    while(frontier.get(i).isExplored);*/

                    chosenNode = frontier.get(i);
                    frontier.remove(i);
                    break;
        }

        return chosenNode;
    }

    public List<Node> Expand(Node node, Problem problem){
        List<Node> solution = new ArrayList<>();

        for (Node child : problem.S(node))
        {
            Node s = new Node(-1,0);
            s.setParent(node);
            s.setNodeID(child.getNodeID());
            s.setPathCost(node.getPathCost() + problem.getTravelCost(node,child));
            s.setDepth(node.getDepth() + 1);
            solution.add(s);
        }

        return solution;
    }

}



