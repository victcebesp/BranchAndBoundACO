import java.util.List;

public class Graph {

    private int vertexAmount;
    private int [][] representation;

    public Graph(int [][] representation, int vertexAmount) {
        this.representation = representation;
        this.vertexAmount = vertexAmount;
    }

    public int vertexAmount() {
        return vertexAmount;
    }

}
