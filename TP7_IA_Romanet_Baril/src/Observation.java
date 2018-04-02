import java.util.HashMap;
import java.util.List;

/**
 * Created by Malomek on 02/04/2018.
 */
public class Observation {

    public String action;
    public HashMap<Hypothese,Double> relations;
    public static List<Observation> observations;


    public Observation(String action, HashMap<Hypothese, Double> relations) {
        this.action = action;
        this.relations = relations;
    }



    public double revision(Hypothese hypothese){
        double denominateur=0;
        double numerateur = hypothese.getProbabilite()* this.getRelation(hypothese);

        for(Hypothese h : Hypothese.hypotheses){
            denominateur += h.getProbabilite() * this.getRelation(h);
        }

        return numerateur/denominateur;
    }


    public Double getRelation(Hypothese h){
        return this.relations.get(h);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public HashMap<Hypothese, Double> getRelations() {
        return relations;
    }

    public void setRelations(HashMap<Hypothese, Double> relations) {
        this.relations = relations;
    }
}
