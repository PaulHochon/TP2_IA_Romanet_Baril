import java.util.HashMap;
import java.util.List;

public class main {
    public static void main(String[] args){

        // generating the problem

        // matrix representing the problem
        int[][] graphMatrix = new int[20][20];
        graphMatrix[0][1] = 71;        graphMatrix[1][0] = 71;
        graphMatrix[1][2] = 75;        graphMatrix[2][1] = 75;
        graphMatrix[2][3] = 118;       graphMatrix[3][2] = 118;
        graphMatrix[3][5] = 111;       graphMatrix[5][3] = 111;
        graphMatrix[5][6] = 70;        graphMatrix[6][5] = 70;
        graphMatrix[6][7] = 75;        graphMatrix[7][6] = 75;
        graphMatrix[0][4] = 151;       graphMatrix[4][0] = 151;
        graphMatrix[2][4] = 140;       graphMatrix[4][2] = 140;
        graphMatrix[7][9] = 120;       graphMatrix[9][7] = 120;
        graphMatrix[4][8] = 80;        graphMatrix[8][4] = 80;
        graphMatrix[4][10] = 99;       graphMatrix[10][4] = 99;
        graphMatrix[8][9] = 146;        graphMatrix[9][8] = 146;
        graphMatrix[8][11] = 97;        graphMatrix[11][8] = 97;
        graphMatrix[9][11] = 138;        graphMatrix[11][9] = 138;
        graphMatrix[10][12] = 211;        graphMatrix[12][10] = 211;
        graphMatrix[11][12] = 101;        graphMatrix[12][11] = 101;
        graphMatrix[13][12] = 90;        graphMatrix[12][13] = 90;
        graphMatrix[17][12] = 85;        graphMatrix[12][17] = 85;
        graphMatrix[17][18] = 98;        graphMatrix[18][17] = 98;
        graphMatrix[19][18] = 86;        graphMatrix[18][19] = 86;
        graphMatrix[17][16] = 142;        graphMatrix[16][17] = 142;
        graphMatrix[15][16] = 92;        graphMatrix[16][15] = 92;
        graphMatrix[15][14] = 87;        graphMatrix[14][15] = 87;

        HashMap<Integer,Integer> straightlinedistance = new HashMap<Integer, Integer>();
        straightlinedistance.put(0,380);
        straightlinedistance.put(1,374);
        straightlinedistance.put(2,366);
        straightlinedistance.put(3,329);
        straightlinedistance.put(4,253);
        straightlinedistance.put(5,244);
        straightlinedistance.put(6,241);
        straightlinedistance.put(7,242);
        straightlinedistance.put(8,193);
        straightlinedistance.put(9,160);
        straightlinedistance.put(10,178);
        straightlinedistance.put(11,98);
        straightlinedistance.put(12,0);
        straightlinedistance.put(13,77);
        straightlinedistance.put(14,234);
        straightlinedistance.put(15,226);
        straightlinedistance.put(16,199);
        straightlinedistance.put(17,80);
        straightlinedistance.put(18,151);
        straightlinedistance.put(19,161);



        int initialPosition = 2;
        int goalPosition = 12;
        Problem problem = new Problem(initialPosition,goalPosition,graphMatrix);

        //strategy choice
        //String strategy ="DepthFirstSearch";
        String strategy ="AStarSearch";

        Agent agent = new Agent(problem,straightlinedistance);

        agent.SolveProblem(strategy);

        agent.PrintSolution(strategy);
    }
}
