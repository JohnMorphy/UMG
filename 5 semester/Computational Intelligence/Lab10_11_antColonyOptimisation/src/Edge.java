public class Edge {
    private City city1;
    private City city2;
    private double pheromoneLevel;
    private double length;

    public Edge(City city1, City city2, double initialPheromoneLevel) {
        this.city1 = city1;
        this.city2 = city2;
        this.pheromoneLevel = initialPheromoneLevel;
        this.length = city1.distanceTo(city2);
    }

    public City getCity1() {
        return city1;
    }

    public City getCity2() {
        return city2;
    }

    public double getPheromoneLevel() {
        return pheromoneLevel;
    }

    public void setPheromoneLevel(double pheromoneLevel) {
        this.pheromoneLevel = pheromoneLevel;
    }

    public double getLength() {
        return length;
    }

    public void addPheromone(double amount) {
        this.pheromoneLevel += amount;
    }

    public void evaporatePheromone(double evaporationRate) {
        this.pheromoneLevel *= (1 - evaporationRate);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "city1=" + city1 +
                ", city2=" + city2 +
                ", pheromoneLevel=" + pheromoneLevel +
                '}';
    }
}
