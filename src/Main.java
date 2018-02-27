import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Node finalNode = new Node(0, new ArrayList<>(), true);
        Node v21 = new Node(4, Arrays.asList(finalNode), false);
        Node v23 = new Node(1, Arrays.asList(finalNode), false);
        Node initialNode = new Node(0, Arrays.asList(v21, v23), false);

        BranchAndBound branchAndBound = new BranchAndBound(initialNode);
        branchAndBound.search_minimum_route(0, initialNode, Integer.MAX_VALUE, new Node[4]);

    }

}
