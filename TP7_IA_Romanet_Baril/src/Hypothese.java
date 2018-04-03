import java.util.List;

/**
 * Created by Malomek on 02/04/2018.
 */
public class Hypothese {

    public String nom;
    public Double probabilite;
    public static List<Hypothese> hypotheses;

    public String getNom() {
        return nom;
    }

    public Hypothese(String nom, double probabilite) {
        this.nom = nom;
        this.probabilite = probabilite;

        Hypothese.hypotheses.add(this);
    }


    public Double estimation(){
        double numerateur=this.getProbabilite();
        double denominateur=0;
        double intermediaire=1;
        for(Observation o : Observation.observations){
            if(o.getRelation(this)!=null){
                numerateur*=o.getRelation(this);
            }
        }
        for(Hypothese h : Hypothese.hypotheses){
            for(Observation o : Observation.observations){
                if(o.getRelation(h)!=null){
                    intermediaire*=o.getRelation(h);
                }
            }
            intermediaire*=h.getProbabilite();
            denominateur+=intermediaire;
            intermediaire=1;
        }

        return numerateur/denominateur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getProbabilite() {
        return probabilite;
    }

    public void setProbabilite(double probabilite) {
        this.probabilite = probabilite;
    }
}
