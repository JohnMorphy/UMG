import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ant {
    private List<City> visitedCities;
    private City currentCity;
    private double tourLength;

    public Ant(List<City> cities) {
        this.visitedCities = new ArrayList<>();
        this.currentCity = selectRandomStartCity(cities);
        this.visitedCities.add(currentCity);
        this.tourLength = 0.0;
    }

    private City selectRandomStartCity(List<City> cities) {
        Random random = new Random();
        return cities.get(random.nextInt(cities.size()));
    }

    public void visitCity(City city, double distance) {
        visitedCities.add(city);
        this.currentCity = city;
        this.tourLength += distance;
    }

    public boolean hasVisited(City city) {
        return visitedCities.contains(city);
    }

    public void completeTour() {
        // Assuming that the ant returns to the start city
        tourLength += calculateDistance(currentCity, visitedCities.get(0));
        visitedCities.add(visitedCities.get(0));
        currentCity = visitedCities.get(0);
    }

    private double calculateDistance(City city1, City city2) {
        return city1.distanceTo(city2);
    }

    public List<City> getVisitedCities() {
        return visitedCities;
    }

    public double getTourLength() {
        return tourLength;
    }

    public void reset(List<City> cities) {
        visitedCities.clear();
        currentCity = selectRandomStartCity(cities);
        visitedCities.add(currentCity);
        tourLength = 0.0;
    }

    public void setVisitedCities(List<City> visitedCities) {
        this.visitedCities = visitedCities;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public void setTourLength(double tourLength) {
        this.tourLength = tourLength;
    }
}
