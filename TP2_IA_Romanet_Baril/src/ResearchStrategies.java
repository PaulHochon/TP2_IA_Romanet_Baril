import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by adrie on 12/02/2018.
 */
public class ResearchStrategies {

    public static List<Node> AStarSearch(Tree tree, Node goal){

        List<Node> open = new ArrayList<>();
        List<Node> closed = new ArrayList<>();
        List<Node> queue = new ArrayList<>();
        HashMap<Node,Node> parents = new HashMap<Node,Node>();
        queue.add(tree.getRootNode());

        int couttotal=0;
        Node current = tree.getRootNode();
        open.add(current);

        for(Node child:current.getChildren()){
            open.add(child);
        }
        int compteur=1;
        while(!queue.isEmpty()){
            current = queue.remove(0);
            System.out.println("Boucle : "+compteur);compteur++;
            System.out.print("liste actuelle : ");
            for(Node n : closed){
                System.out.print(" "+n.getNodeID()+" ");
            }
            System.out.println("");
            open.remove(current);

            if(!closed.contains(current)){
                closed.add(current);
                if(current.equals(goal)){
                    return closed;
                }
                for(Node child:current.getChildren()){
                    parents.put(child,current);
                    if(!closed.contains(child)){
                        if(tree.getTotalCost(current,child)<couttotal||!open.contains(child)){
                            couttotal=tree.getTotalCost(current,child);
                            current=parents.get(child);
                            if(!open.contains(child)){
                                open.add(child);
                            }
                        }
                        queue.add(child);
                    }
                }
            }

        }
        return closed;
    }

    public static Node getBestChild(List<Node> children){
        if(children==null){
            return null;
        }
        int coutmin=children.get(0).getCost();
        Node bestchild = null;
        for(Node child : children){
            if(child.getCost()<coutmin){
                bestchild=child;
                coutmin=bestchild.getCost();
            }
        }
        return bestchild;
    }


    public static List<Node> DepthFirstSearch(Tree tree){//cette fonction parcourt un arbre donné selon la stratégie du DepthFirstSearch
                                                        //et retourne la liste de l'ordre de passage effectué
        Node init = tree.getRootNode();
        Stack<Node> stack = new Stack();
        stack.push(init);
        List<Node> marked = new ArrayList<>();
        while(!stack.isEmpty()){

            Node element = stack.pop();
            marked.add(element);
            List<Node> children = new ArrayList();
            if(element.getChild(0)!=null){

                for(int i=0;i<element.getChildren().size();i++){
                    children.add(element.getChild(i));
                }

                for(int i=0;i<children.size();i++){
                    Node n=children.get(i);
                    if(n!=null && !marked.contains(n))
                    {
                        stack.push(n);
                    }
                }
            }
        }
        /*for(Node nnn : marked){
            System.out.print(" "+nnn.getNodeID()+" ");
        }*/
        return marked;
    }

    public static List<Node> stackToList(Stack<Node> stack){
        List<Node> list = new ArrayList<>();
        while(!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

    public static List<Node> researchStrategy(Tree tree, String strategy){//cette fonction lit la strategie demandée et retourne
                                                                          // l'ordre de passage des noeuds de l'arbre donné selon celle ci

        switch(strategy){
            case "DepthFirstSearch" : return DepthFirstSearch(tree);
            case "AStarSearch" : return AStarSearch(tree,tree.getNodeByID(tree.problem.getGoalState(),tree.getRootNode()));
        }
        return null;
    }

    public static List<Node> researchStrategy(Tree tree, String strategy, Node goal){//cette fonction lit la strategie demandée et retourne
        // l'ordre de passage des noeuds de l'arbre donné selon celle ci

        if(goal==null){
            return researchStrategy(tree,strategy);
        }

        switch(strategy){
            case "DepthFirstSearch" : return DepthFirstSearch(tree);
            case "AStarSearch" : System.out.println("batman");return AStarSearch(tree,goal);
        }
        return null;
    }

}
