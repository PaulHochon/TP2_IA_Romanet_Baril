import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Agent {

    private Problem problem;
    public Problem getProblem() {
        return problem;
    }


    //private Tree problemTree;
    private Node solutionNode;
    public Node getSolutionNode(){
        return solutionNode;
    }

    public Agent(Problem problem){
        this.problem = problem;
        //this.problemTree = new Tree(new Node(problem.getInitialState()),problem);
    }
    public Agent(Problem problem, HashMap<Integer,Integer> mapping){
        this.problem = problem;
        //this.problemTree = new Tree(new Node(problem.getInitialState()),problem,mapping);
    }

    public void SolveProblem(String strategyChoice){
        solutionNode = problem.getInitialState().Tree_Search(problem,"",new ArrayList<>());
        //solutionList = problemTree.Tree_Search(problem,strategyChoice);
    }

    public void PrintSolution(){
        Node dummy = solutionNode;
        while(dummy.getParent() != null)
        {
            System.out.print(dummy.getNodeID() + " ");
            dummy = dummy.getParent();
        }
    }

   /* public void PrintSolution(String strategyChoice){
        System.out.println("\n En utilisant la strategie " + strategyChoice + " nous obtenons le parcours suivant : ");
        for(int i : solutionList){
            System.out.print(" "+i+" ");
        }
    }*/


}
