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
                done = false;
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
        System.out.print(node.getNodeID()+" ");
        for (Node item : node.getChildren()) {
            PrintTree(item);
        }
        System.out.println("");
    }

    public void initializeWithProblem(Node node, Problem problem){ //Fonction appellée dans le tree search pour initialiser l'arbre selon le probleme
        if(problem.getInitialState()==node.getNodeID()){
            return;
        }
        for(Node item : node.getChildren()){
            if(problem.getInitialState()==node.getNodeID()){
                this.rootNode=item;return;
            }
            initializeWithProblem(item,problem);
        }
    }

    public List<Integer> Tree_Search(Problem problem, String strategy){
        List<Integer> list = new ArrayList<>();
        this.initializeWithProblem(rootNode,problem);  //On initialise l'arbre pour s'assurer que l'on part bien du point initial du probleme
        List<Node> researchorder = ResearchStrategies.researchStrategy(this, strategy);
        Node current = null;
        do{
            if(researchorder.isEmpty()){
                return null;
            }
            problem.GoTo(researchorder.get(0).getNodeID());
            current=researchorder.get(0);
            list.add(current.getNodeID());
            if(problem.TestGoal(current.getNodeID())){
                return list;
            }
            researchorder.remove(0);

        }while(!researchorder.isEmpty());

        return list;
    }

}
