import java.util.ArrayList;
import java.util.List;

public class Problem {

    // states matrix;
    private int[][] graphMatrix;
    public int[][] getGraphMatrix() {
        return graphMatrix;
    }

    // current state
    private int currentState;
    public int getCurrentState(){
        return currentState;
    }
    
    // initial state
    private int initialState;
    public int getInitialState(){
        return initialState;
    }

    // goal test
    private int goalState;
    public int getGoalState(){
        return goalState;
    }

    public boolean TestGoal(int currentState){

        return currentState == goalState;
    }
    
    public Problem(int initialState, int goalState, int[][] graphMatrix){
        this.initialState=initialState;
        this.currentState=initialState;
        this.goalState=goalState;
        this.graphMatrix=graphMatrix;
    }
    
    // operators
    public void GoTo(int nextState){
        if(graphMatrix[currentState][nextState]!=0){
            currentState = nextState;
            cost+=1;
        }
    }

    // succession's functions
    public List<Integer> S(int state){
        List<Integer> solution = new ArrayList<Integer>();
        for(int i = 0; i<graphMatrix.length ; i++)
        {
            if(graphMatrix[state][i]!=0){
                solution.add(i);
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
    public int PathCost(int state1, int state2){
        if(graphMatrix[state1][state2]!=0){
            return graphMatrix[state1][state2];
        }
        else return -1;
    }
}
