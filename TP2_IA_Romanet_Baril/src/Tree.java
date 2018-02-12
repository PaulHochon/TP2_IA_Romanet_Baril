public class Tree {

    private Node rootNode;
    public Node getRootNode() {
        return rootNode;
    }

    Problem problem;

    public Tree(Node rootNode, Problem problem){
        this.rootNode = rootNode;
        this.problem = problem;
        CreateTree(problem,rootNode);
    }

    public Node CreateTree(Problem problem, Node node){
        for (int item: problem.S(node.getNodeID())) {
            node.AddChild(new Node(item));
            node.AddParent(new Node(item));
        }

        return node;
    }
}
