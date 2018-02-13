import java.util.List;

public class main {
    public static void main(String[] args){

        //strategy choice
        String strategy ="DepthFirstSearch";

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

        int initialPosition = 2;
        int goalPosition = 12;

        Problem problem = new Problem(initialPosition,goalPosition,graphMatrix);

        //generating tree from the problem

        Tree problemTree = new Tree(new Node(problem.getInitialState()), problem);

        //problemTree.PrintTree(problemTree.getRootNode());

        List<Integer> list  = problemTree.Tree_Search(problem,strategy);
        System.out.println("\n En utilisant la strategie " + strategy + " nous obtenons le parcours suivant : ");
        for(int i :list){
            System.out.print(" "+i+" ");
        }
    }
}
