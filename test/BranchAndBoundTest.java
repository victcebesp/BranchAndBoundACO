import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class BranchAndBoundTest {

    @Test
    public void single_vertex_graph_return_one_step_route(){

        List<Edge> graph = Collections.singletonList(new Edge(0, 0, 0));

        int maxRouteSize = 1;

        Route route = new Route(maxRouteSize);

        BranchAndBound branchAndBound = new BranchAndBound(graph, 0);
        branchAndBound.search_minimum_route(0, 0, 0, route);

        assertArrayEquals(new int []{0}, route.getFinalRoute());
    }

    @Test
    public void two_vertex_graph_return_two_step_route(){

        List<Edge> graph = Collections.singletonList(new Edge(0, 1, 2));

        int maxRouteSize = 2;

        Route route = new Route(maxRouteSize);

        BranchAndBound branchAndBound = new BranchAndBound(graph, 1);
        branchAndBound.search_minimum_route(0, 0, 0, route);

        assertArrayEquals(new int []{0, 1}, route.getFinalRoute());
    }


}
