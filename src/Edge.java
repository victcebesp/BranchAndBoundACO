public class Edge implements Comparable{
    private int cost;
    private final int initialVertex;
    private final int finalVertex;

    public Edge(int initialVertex, int finalVertex, int cost) {
        this.initialVertex = initialVertex;
        this.finalVertex = finalVertex;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getInitialVertex() {
        return initialVertex;
    }

    public int getFinalVertex() {
        return finalVertex;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "cost=" + cost +
                ", initialVertex=" + initialVertex +
                ", finalVertex=" + finalVertex +
                '}';
    }

    @Override
    public boolean equals(Object o){
        Edge edge = (Edge) o;
        return edge.getCost() == this.getCost() &&
                edge.getInitialVertex() == this.getInitialVertex() &&
                edge.getFinalVertex() == this.getFinalVertex();
    }

    @Override
    public int compareTo(Object o) {
        Edge edge = (Edge) o;
        return Integer.compare(this.getCost(), edge.getCost());
    }
}
