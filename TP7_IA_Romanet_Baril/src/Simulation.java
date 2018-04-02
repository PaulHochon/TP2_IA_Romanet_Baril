import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Malomek on 02/04/2018.
 */
public class Simulation {


    public static void main(String[] args) {

        Hypothese.hypotheses = new ArrayList<>();
        Observation.observations = new ArrayList<>();

        Hypothese h1= new Hypothese("Aller chasser",0.35);
        Hypothese h2= new Hypothese("Voler la banque",0.3);
        Hypothese h3= new Hypothese("Retirer de l'argent",0.35);

        HashMap<Hypothese, Double> relations1 = new HashMap<>();
        relations1.put(h1,0.5);
        relations1.put(h2,0.5);

        HashMap<Hypothese, Double> relations2 = new HashMap<>();
        relations2.put(h2,0.5);
        relations2.put(h3,0.5);

        Observation e1 = new Observation("Prendre un fusil",relations1);
        Observation e2 = new Observation("Aller à la banque",relations2);

        Double ph2e1e2 = h2.estimation();

        System.out.println(ph2e1e2);

    }

}
