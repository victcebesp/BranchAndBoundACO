import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BranchAndBoundTest {

    @Test
    public void single_vertex_graph_return_one_step_route(){

        List<Edge> graph = Collections.singletonList(new Edge(0, 0, 0));

        int maxRouteSize = 1;

        Route route = new Route(maxRouteSize);

        BranchAndBound branchAndBound = new BranchAndBound(graph, 0);
        branchAndBound.search_minimum_route(0, 0, 0, route);

        assertArrayEquals(new int []{0}, route.getFinalRoute());
        assertEquals(0, route.getCost());
    }

    @Test
    public void two_vertex_graph_return_two_step_route(){

        List<Edge> graph = Collections.singletonList(new Edge(0, 1, 2));

        int maxRouteSize = 2;

        Route route = new Route(maxRouteSize);

        BranchAndBound branchAndBound = new BranchAndBound(graph, 1);
        branchAndBound.search_minimum_route(0, 0, 0, route);

        assertArrayEquals(new int []{0, 1}, route.getFinalRoute());
        assertEquals(2, route.getCost());
    }

    @Test
    public void two_vertex_graph_two_branches_return_two_step_route(){

        Edge edge01 = new Edge(0, 1, 3);
        Edge edge02 = new Edge(0, 1, 2);
        List<Edge> graph = Arrays.asList(edge01, edge02);

        int maxRouteSize = 2;

        Route route = new Route(maxRouteSize);

        BranchAndBound branchAndBound = new BranchAndBound(graph, maxRouteSize-1);
        branchAndBound.search_minimum_route(0, 0, 0, route);

        assertArrayEquals(new int []{0, 1}, route.getFinalRoute());
        assertEquals(2, route.getCost());
    }

    @Test
    public void diamond_shape_graph_return_three_step_route(){

        Edge edge01 = new Edge(0, 1, 3);
        Edge edge02 = new Edge(0, 2, 2);
        Edge edge13 = new Edge(1, 3, 1);
        Edge edge23 = new Edge(2, 3, 3);
        List<Edge> graph = Arrays.asList(edge01, edge02, edge13, edge23);

        int maxRouteSize = 3;

        Route route = new Route(maxRouteSize);

        BranchAndBound branchAndBound = new BranchAndBound(graph, 3);
        branchAndBound.search_minimum_route(0, 0, 0, route);

        assertArrayEquals(new int []{0, 1, 3}, route.getFinalRoute());
        assertEquals(4, route.getCost());
    }

    @Test
    public void dense_graph_return_four_step_route(){

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

        assertArrayEquals(new int[]{0, 1, 6, 7}, route.getFinalRoute());
        assertEquals(5, route.getCost());
    }

}
