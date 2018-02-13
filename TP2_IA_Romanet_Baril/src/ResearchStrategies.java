import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by adrie on 12/02/2018.
 */
public class ResearchStrategies {


    public static List<Node> DepthFirstSearch(Tree tree){//cette fonction parcourt un arbre donné selon la stratégie du DepthFirstSearch
                                                        //et retourne la liste de l'ordre de passage effectué
        Node init = tree.getRootNode();
        Stack<Node> stack = new Stack();
        stack.push(init);
        List<Node> marked = new ArrayList<>();
        marked.add(init);
        while(!stack.isEmpty()){
            Node element = stack.pop();
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
                        marked.add(n);
                    }
                }
            }
        }
       /* for(Node nnn : marked){
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
        }
        return null;
    }

}
