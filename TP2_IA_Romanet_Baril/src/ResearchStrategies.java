import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by adrie on 12/02/2018.
 */
public class ResearchStrategies {


    public static List<Node> DepthFirstSearch(Tree tree){

        Node current = tree.getRootNode();
        Stack<Node> stack = new Stack();
        stack.push(current);
        List<Node> marked = new ArrayList<>();
        while(!stack.isEmpty()){
            System.out.println(""++"");
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
                        if(tree.problem.TestGoal(n.getNodeID())){
                            return stackToList(stack);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static List<Node> stackToList(Stack<Node> stack){
        List<Node> list = new ArrayList<>();
        while(!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

}
