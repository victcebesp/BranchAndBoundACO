import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Edge edge01 = new Edge(0, 1, 4);
//        Edge edge02 = new Edge(0, 2, 1);
//        Edge edge13 = new Edge(1, 3, 2);
//        Edge edge23 = new Edge(2, 4, 1);
//        Edge edge25 = new Edge(2, 5, 2);
//        Edge edge43 = new Edge(4, 3, 3);
//        Edge edge53 = new Edge(5, 3, 1);

        Edge edge01 = new Edge(0, 1, 1);
        Edge edge02 = new Edge(0, 2, 3);
        Edge edge03 = new Edge(0, 3, 2);
        Edge edge14 = new Edge(1, 4, 5);
        Edge edge16 = new Edge(1, 6, 3);
        Edge edge24 = new Edge(2, 4, 4);
        Edge edge25 = new Edge(2, 5, 3);
        Edge edge35 = new Edge(3, 5, 2);
        Edge edge36 = new Edge(3, 6, 7);
        Edge edge47 = new Edge(4, 7, 4);
        Edge edge57 = new Edge(5, 7, 1);
        Edge edge67 = new Edge(6, 7, 1);

        List<Edge> graph = Arrays.asList(edge01, edge02, edge03, edge14, edge16, edge24, edge25, edge35, edge36, edge47, edge57, edge67);

        int maxRouteSize = 4;
        Route route = new Route(maxRouteSize);
        BranchAndBound branchAndBound = new BranchAndBound(graph, 7);

        branchAndBound.search_minimum_route(0, 0, 0, route);

        for (int each : route.getFinalRoute()) System.out.println(each);


    }

}
