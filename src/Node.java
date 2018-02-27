import com.sun.org.apache.xerces.internal.xni.XMLString;

import java.util.List;

public class Node {

    private int cost;
    private List<Node> nodeChildren;
    private boolean isFinal;

    public Node(int cost, List<Node> nodeChildren, boolean isFinal) {
        this.cost = cost;
        this.nodeChildren = nodeChildren;
        this.isFinal = isFinal;
    }

    public int getCost() {
        return cost;
    }

    public List<Node> expand() {
        return nodeChildren;
    }

    public boolean isFinal() {
        return isFinal;
    }

}
