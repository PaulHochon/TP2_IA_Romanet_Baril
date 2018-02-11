/**
 * Created by Malomek on 21/01/2018.
 */
public class main {

    public static void main (String[] args){
        // Create Environnement and Start it
        Environnement env = new Environnement(1);
        Thread tEnv = new Thread(env);
        tEnv.start();

        // Create agent and start it
        Thread agent = new Thread(new Agent(env));
        agent.run();

        System.exit(1);
    }
}
