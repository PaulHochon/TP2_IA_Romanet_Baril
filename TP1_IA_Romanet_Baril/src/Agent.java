import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Malomek on 21/01/2018.
 */
public class Agent implements Runnable{

    public Set objective;  //Le but de la vie de notre agent est d'accomplir au moins une fois chacun des objectifs que nous avons créé
    public boolean isAlive;
    public Environnement environnement; //Lien avec l'environnement dans lequel l'agent évolu pour suivre son statut


    public Agent(Environnement env){
        this.isAlive = true;
        this.objective = new HashSet();
        this.objective.add(1);
        this.objective.add(2);
        this.objective.add(3);
        this.environnement=env;

    }

    public void agit(int n) throws InterruptedException {//ici en fonction du numéro d'objectif donné l'agent va accomplir la tache correspondante, ici chaque "tache" correspondant à endormir le thread plus ou moins longtemps
        switch(n){
            case 1 : //Thread.sleep(1000);
            for(int i=0;i<3;i++){
                Thread.sleep(500);                  //
                if(this.environnement.GetState()==0){     //tous les 500ms pour correspondre au temps de rafraichissement de l'environnement nous allons vérifier si l'environnement n'est pas devenu nefaste
                    this.isAlive=false;
                    return;                               //si c'est le cas on declare la mort de l'agent et on met un terme à ses agissements
                }
            }
            break;
            case 2 : //Thread.sleep(2000);
                for(int i=0;i<5;i++){
                    Thread.sleep(500);
                    if(this.environnement.GetState()==0){
                        this.isAlive=false;
                        return;
                    }
                }
            break;
            case 3 : //Thread.sleep(3000);
                for(int i=0;i<7;i++){
                    Thread.sleep(500);
                    if(this.environnement.GetState()==0){
                        this.isAlive=false;
                        return;
                    }
                }
            break;
        }
        System.out.println("Objectif " + n + " accompli");

    }


    public void run(){

        while(!this.objective.isEmpty()&&isAlive){        //La boucle fera travailler l'agent jusqu'à ce que sa liste d'objectifs à faire soit vide
            if(this.environnement.GetState()==1){
                Random rand = new Random();
                int  n = rand.nextInt(3) + 1;

                try {
                    this.agit(n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.objective.remove(n);    //ici l'agent retire le numéro d'objectif de sa liste à faire (s'il n'est pas déjà enlevé)
            }
            else{
                System.out.println("Environnement hostile ! On annule tout !");
                try {
                    Thread.sleep(500);  //on attend pour laisser à l'environnement le temps de changer
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        if(!isAlive){
            System.out.println("Mission échoué, l'agent a été détruit");
        }
        else{
            System.out.println("Tous les objective ont été accomplis ! ");
        }
        return;


    }

}
