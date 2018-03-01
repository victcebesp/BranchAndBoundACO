import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BranchAndBound {

    private final int finalVertex;
    private int upperBound;
    private List<Edge> graph;
    private final boolean isNotAValidGraph;

    public BranchAndBound(List<Edge> graph, int finalVertex) {
        this.upperBound = Integer.MAX_VALUE;
        this.graph = graph;
        this.finalVertex = finalVertex;
        this.isNotAValidGraph = isNotValidGraph(graph);
    }

    public void search_minimum_route(int stage, int currentVertex, int pathCost, Route route) {

        if (isNotAValidGraph) return;

        List<Edge> currentVertexChildren = getSortedChildrenFrom(currentVertex);

        Edge currentEdge = currentVertexChildren.get(0);
        int nextStageVertex = currentEdge.getFinalVertex();
        int currentEdgeCost = currentEdge.getCost();

        int nextBound = pathCost + currentEdgeCost;

        if (nextBound >= this.upperBound) return;

        route.updateActualRoute(stage, currentEdge.getInitialVertex());

        if (isFinal(nextStageVertex)) {
            if (hasLessBound(nextBound)) {
                this.upperBound = nextBound;
                route.updateActualRoute(stage+1, nextStageVertex);
                route.updateFinalRoute();
            }
        } else {
            for (Edge eachNode : currentVertexChildren){
                search_minimum_route(++stage, eachNode.getFinalVertex(), pathCost + eachNode.getCost(), route);
            }
        }
    }

    private boolean hasLessBound(int nextBound) {
        return nextBound < this.upperBound;
    }

    private boolean isFinal(int nextStageVertex) {
        return nextStageVertex == this.finalVertex;
    }

    private List<Edge> getSortedChildrenFrom(int currentNode) {
        return graph.stream()
                .filter(edge -> edge.getInitialVertex() == currentNode)
                .sorted(Comparator.comparingInt(Edge::getCost))
                .collect(Collectors.toList());

    }

    private boolean isNotValidGraph(List<Edge> graph) {
        return graph.size() == 1 && graph.get(0).getInitialVertex() == graph.get(0).getFinalVertex();
    }
}
