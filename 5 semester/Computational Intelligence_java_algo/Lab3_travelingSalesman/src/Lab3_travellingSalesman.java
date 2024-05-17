import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Lab3_travellingSalesman {

    public static void main(String[] args) {

        String fileName = "berlin52.tsp";


        try {
            ArrayList<City> coordinates = readData(fileName);


            int[] optimalSolution = {1, 49, 32, 45, 19, 41, 8, 9, 10, 43, 33, 51, 11, 52, 14, 13, 47, 26, 27, 28, 12, 25, 4,
            6, 15, 5, 24, 48, 38, 37, 40, 39, 36, 35, 34, 44, 46, 16, 29, 50, 20, 23, 30, 2, 7, 42, 21, 17, 3, 18, 31, 22, 1};

            System.out.println("Optimal solution: " + evaluateSolution(optimalSolution, coordinates));

            int[] solution = greedyAlgorithm(coordinates);
            System.out.println(Arrays.toString(solution));
            System.out.println(evaluateSolution(solution, coordinates));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<City> readData(String filename) throws IOException {

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();

            while(!line.equals("NODE_COORD_SECTION")) {
                line = reader.readLine();
            }
            line = reader.readLine();

            ArrayList<City> coordinates = new ArrayList<>();

            while (!line.equals("EOF")) {

                String[] values = line.split(" ");
                coordinates.add(new City(Integer.parseInt(values[0]), Double.parseDouble(values[1]), Double.parseDouble(values[2])));
                line = reader.readLine();
            }
            reader.close();

            return coordinates;
    }

    public static int[] greedyAlgorithm(ArrayList<City> coordinates) {

        ArrayList<City> coordinatesCopy = new ArrayList<>(coordinates);

        int[] solution = new int[coordinatesCopy.size()+1];
        int index = 0;
        solution[index] = coordinatesCopy.get(index).getIndex();
        City current = coordinatesCopy.get(0);
        coordinatesCopy.remove(0);
        City destination;

        if(coordinatesCopy.size() == 0) {
            System.out.println("Only one city; therefor, no distance to travel");
            return solution;
        }

        while(coordinatesCopy.size() > 0) {

            double minDistance = City.getDistance(current, coordinatesCopy.get(0));
            destination = coordinatesCopy.get(0);

            for (City city:coordinatesCopy) {
                if(minDistance > City.getDistance(current, city)) {
                    minDistance = City.getDistance(current, city);
                    destination = city;
                }
            }

            solution[++index] = destination.getIndex();
            coordinatesCopy.remove(destination);
            current = destination;
        }

        solution[++index] = coordinates.get(0).getIndex();

        return solution;
    }

    public static double evaluateSolution(int[] solution, ArrayList<City> coordinates) {

        if(solution.length != coordinates.size()+1) {
            return -1;
        }

        double distance = 0;

        for (int i = 0; i<solution.length-1; i++) {
            distance+=City.getDistance(coordinates.get(solution[i]-1), coordinates.get(solution[i+1]-1));
        }

        return distance;
    }

}

class City {

    private final int index;
    private final double x;
    private final double y;

    public City(int index, double x, double y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public static double getDistance(City city1, City city2) {
        return Math.sqrt(Math.pow(city1.x-city2.x, 2) + Math.pow(city1.y-city2.y, 2));
    }

}