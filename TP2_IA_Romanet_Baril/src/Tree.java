import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tree {

    private Node rootNode;

    public Tree(Node node, Problem problem, HashMap<Integer, Integer> mapping) {
        this.rootNode = node;
        this.problem = problem;
        CreateTree(problem, rootNode, marked, mapping);
    }

    public Node getRootNode() {
        return rootNode;
    }

    Problem problem;

    List<Integer> marked = new ArrayList<>();

    public Tree(Node rootNode, Problem problem) {
        this.rootNode = rootNode;
        this.problem = problem;
        CreateTree(problem, rootNode, marked, null);
    }

    public void CreateTree(Problem problem, Node node, List<Integer> list, HashMap<Integer, Integer> mapping) {
        System.out.print("cost:"+mapping.get(node.getNodeID()));
        if(mapping!=null)node.setCost(mapping.get(node.getNodeID()));
        list.add(node.getNodeID());

        // foreach node linked to the current node
        for (int item : problem.S(node.getNodeID())) {
            if (!marked.contains(item)) {
                // if not, add it to the list of marked nodes
                // insert node into the children and parents list
                // repeat the process for the newly found node
                list.add(item);
                Node newNode = new Node(item);
                node.AddChild(newNode);
                if(mapping==null){
                    CreateTree(problem, newNode, list,null);
                }
                else{
                    CreateTree(problem, newNode, list,mapping);
                }
                node.AddParent(newNode);
            }
        }
    }

    public static void PrintTree(Node node) {
        System.out.print(node.getNodeID() + " ");
        for (Node item : node.getChildren()) {
            PrintTree(item);
        }
        System.out.println("");
    }
    public Node getNodeByID(int id,Node n) {
        if(n.getNodeID()==id){
            return n;
        }
        for (Node item : n.getChildren()) {
            return this.getNodeByID(id,item);
        }
            return null;
    }

    public void initializeWithProblem(Node node, Problem problem) { //Fonction appellée dans le tree search pour initialiser l'arbre selon le probleme
        if (problem.getInitialState() == node.getNodeID()) {
            return;
        }
        for (Node item : node.getChildren()) {
            if (problem.getInitialState() == node.getNodeID()) {
                this.rootNode = item;
                return;
            }
            initializeWithProblem(item, problem);
        }
    }

    public int getTravelCost(Node depart, Node arrival){
        return this.problem.getGraphMatrix()[depart.getNodeID()][arrival.getNodeID()];
    }
    public int getTotalCost(Node depart, Node arrival){
        return this.problem.getGraphMatrix()[depart.getNodeID()][arrival.getNodeID()]+arrival.getCost();
    }

    public List<Integer> Tree_Search(Problem problem, String strategy) {
        List<Integer> list = new ArrayList<>();
        this.initializeWithProblem(rootNode, problem);  //On initialise l'arbre pour s'assurer que l'on part bien du point initial du probleme
        List<Node> researchorder = ResearchStrategies.researchStrategy(this, strategy,this.getNodeByID(this.problem.getGoalState(),this.getRootNode()));
        Node current = null;
        do {
            if (researchorder.isEmpty()) {
                return null;
            }
            problem.GoTo(researchorder.get(0).getNodeID());
            current = researchorder.get(0);
            list.add(current.getNodeID());
            if (problem.TestGoal(current.getNodeID())) {
                return list;
            }
            researchorder.remove(0);

        } while (!researchorder.isEmpty());

        return list;
    }

}
