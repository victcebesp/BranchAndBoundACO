import java.util.Comparator;
import java.util.List;

public class BranchAndBound {

    private Node initialNode;
    private int cota;

    public BranchAndBound(Node initialNode) {
        this.initialNode = initialNode;
        this.cota = Integer.MAX_VALUE;
    }

    public Node [] search_minimum_route (int etapa, Node currentNode, int costeActual, Node [] solucion) {

        List<Node> currentNodeChildren = currentNode.expand();
        currentNodeChildren.sort(Comparator.comparingInt(Node::getCost));
        Node nodoPrometedor = currentNodeChildren.remove(0);

        solucion[etapa] = nodoPrometedor;

        //podar
        if (costeActual + nodoPrometedor.getCost() >= this.cota) return solucion;

        if (nodoPrometedor.isFinal()) {
            int siguienteCota = costeActual + nodoPrometedor.getCost();
            if (siguienteCota < this.cota) this.cota = siguienteCota;
            return solucion;
        }

        else {
            int etapaAux = etapa + 1;
            int costeActualAux = costeActual + nodoPrometedor.getCost();
            for (Node eachNode : currentNodeChildren)
                search_minimum_route(etapaAux, eachNode, costeActualAux, solucion);
            return solucion;
        }
    }
}
