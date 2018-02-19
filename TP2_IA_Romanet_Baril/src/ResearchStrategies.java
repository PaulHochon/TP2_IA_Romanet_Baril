import java.util.*;

/**
 * Created by adrie on 12/02/2018.
 */
public class ResearchStrategies {


    public static List<Node> AStarSearch(Tree tree, Node goal){
        List<Node> returnlist = new ArrayList<>();
        List<Node> open = new ArrayList<>();
        List<Node> closed = new ArrayList<>();
        List<Node> queue = new ArrayList<>();
        HashMap<Node,Node> parents = new HashMap<Node,Node>();
        queue.add(tree.getRootNode());

        int couttotal=Integer.MAX_VALUE;
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
                System.out.print(" "+n.getNodeID()+"("+tree.getTotalCost(current,n)+")");
            }
            System.out.println("");
            open.remove(current);

            if(!closed.contains(current)){
                closed.add(current);
                if(current.equals(goal)){
                    return rebuildPath(parents);
                }
                for(Node child:current.getChildren()){
                    if(!closed.contains(child)&&tree.getTotalCost(current,child)<couttotal){
                        if(child.equals(getBestChild(current.getChildren(),current,tree))||!queue.contains(child)){
                            returnlist.add(child);
                            parents.put(child,current);

                            System.out.print("BESTCHILD: "+child.getNodeID());
                            couttotal=tree.getTotalCost(current,child);
                            current=parents.get(child);
                            if(!open.contains(child)){
                                open.add(child);
                            }
                        }
                    }
                    queue.add(child);

                }
            }

        }
        System.out.print("SUPERMAN");
        return returnlist;
    }

    public static List<Node> rebuildPath(HashMap<Node,Node> parents){
        List<Node> returnlist = new ArrayList<>();
        for(Node n : parents.keySet()){
            System.out.print("BATMAN"+n.getNodeID()+parents.get(n).getNodeID());
            returnlist.add(n);returnlist.add(parents.get(n));
        }
        return returnlist;
    }

    public static Node getBestChild(List<Node> children, Node parent, Tree tree){
        if(children==null||parent==null){
            return null;
        }
        int coutmin=Integer.MAX_VALUE;
        Node bestchild = null;
        for(Node child : children){
            if(tree.getTotalCost(parent,child)<coutmin){
                bestchild=child;
                coutmin=tree.getTotalCost(parent,child);
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
            case "AStarSearch" : return AStarSearch(tree,tree.getNodeByID(tree.getProblem().getGoalState(),tree.getRootNode()));
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
