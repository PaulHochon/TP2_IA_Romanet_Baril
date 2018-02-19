import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Agent {

    private Problem problem;
    private Tree problemTree;
    private List<Integer> solutionList;

    public Agent(Problem problem){
        this.problem = problem;
        this.problemTree = new Tree(new Node(problem.getInitialState()),problem);
        this.solutionList = new ArrayList<Integer>();
    }
    public Agent(Problem problem, HashMap<Integer,Integer> mapping){
        this.problem = problem;
        this.problemTree = new Tree(new Node(problem.getInitialState()),problem,mapping);
        this.solutionList = new ArrayList<Integer>();
    }

    public void SolveProblem(String strategyChoice){
        solutionList = problemTree.Tree_Search(problem,strategyChoice);
    }

    public void PrintSolution(String strategyChoice){
        System.out.println("\n En utilisant la strategie " + strategyChoice + " nous obtenons le parcours suivant : ");
        for(int i : solutionList){
            System.out.print(" "+i+" ");
        }
    }

    public Problem getProblem() {
        return problem;
    }

    public Tree getProblemTree() {
        return problemTree;
    }
}
