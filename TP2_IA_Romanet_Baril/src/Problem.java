public class Problem {

    // states
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
    
    public Problem(int initialState, int goalState){
        this.initialState=initialState;
        this.currentState=initialState;
        this.goalState=goalState;
    }
    
    // TODO operators
    public void GoTo(int nextState){

    }

    // TODO succession's functions

    // TODO path cost

}
