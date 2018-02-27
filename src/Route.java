import java.util.Arrays;

public class Route {

    private int [] finalRoute;
    private int [] actualRoute;

    public Route(int maxRouteSize) {
        this.finalRoute = new int[maxRouteSize];
        this.actualRoute= new int[maxRouteSize];
    }

    public void updateActualRoute(int stage, int vertex) {
        actualRoute[stage] = vertex;
    }

    public void updateFinalRoute() {
        this.finalRoute = Arrays.copyOf(actualRoute, actualRoute.length);
    }

    public int [] getFinalRoute(){
        return finalRoute;
    }

}
