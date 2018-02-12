import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Node rootNode;
    public Node getRootNode() {
        return rootNode;
    }

    Problem problem;

    List<Integer> marked = new ArrayList<>();

    public Tree(Node rootNode, Problem problem){
        this.rootNode = rootNode;
        this.problem = problem;
        CreateTree(problem,rootNode,marked);
    }

    public void CreateTree(Problem problem, Node node, List<Integer> list){
        list.add(node.getNodeID());
        boolean done = false;

        for (int item: problem.S(node.getNodeID())) {
            for(int markedNodes : list){
                if(item==markedNodes){
                    done = true;
                    break;
                }
                done=false;
            }
            if(!done)
            {
                list.add(item);
                Node newNode = new Node(item);
                node.AddChild(newNode);
                CreateTree(problem,newNode,list);
                //node.AddParent(new Node(item));
            }

        }
    }

    public void PrintTree(Node node) {
        System.out.print(node.getNodeID());
        for (Node item : node.getChildren()) {
            PrintTree(item);
        }
        System.out.println("End Branch");
    }
}
