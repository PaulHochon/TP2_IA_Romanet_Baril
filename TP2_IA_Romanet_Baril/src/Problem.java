import java.util.ArrayList;
import java.util.List;

public class Problem {

    // states matrix;
    private int[][] graphMatrix;
    public int[][] getGraphMatrix() {
        return graphMatrix;
    }

    // current state
    private Node currentState;
    public Node getCurrentState(){
        return currentState;
    }
    
    // initial state
    private Node initialState;
    public Node getInitialState(){
        return initialState;
    }

    // goal state
    private Node goalState;
    public Node getGoalState(){
        return goalState;
    }

    public boolean TestGoal(Node currentState){
        return currentState.getNodeID() == goalState.getNodeID();
    }

    public Problem(Node initialState, Node goalState, int[][] graphMatrix){
        this.initialState=initialState;
        this.currentState=initialState;
        this.goalState=goalState;
        this.graphMatrix=graphMatrix;
    }


    // operators
    public void GoTo(Node nextState){
        if(graphMatrix[currentState.getNodeID()][nextState.getNodeID()]!=0){
            currentState = nextState;
            cost+=1;
        }
    }


    // succession's functions
    public List<Node> S(Node state){
        List<Node> solution = new ArrayList<>();
        for(int i = 0; i<graphMatrix.length ; i++)
        {
            if(graphMatrix[state.getNodeID()][i]!=0){
                solution.add(new Node(i));
            }
        }
        return solution;
    }

    // path cost
    private int cost;
    public int getCost() {
        return cost;
    }

    // cost between nodes linked by an edge
    public int EdgeCost(Node state1, Node state2){
        if(graphMatrix[state1.getNodeID()][state2.getNodeID()]!=0){
            return graphMatrix[state1.getNodeID()][state2.getNodeID()];
        }
        else return -1;
    }

    public int getTravelCost(Node depart, Node arrival){
        return this.getGraphMatrix()[depart.getNodeID()][arrival.getNodeID()];
    }

    // real cost + mapping cost (Straight line cost for example)
    public int getTotalCost(Node depart, Node arrival){
        return this.getGraphMatrix()[depart.getNodeID()][arrival.getNodeID()]+arrival.getCost();
    }
}
