import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lab4_5_localSearch {

    public static void main(String[] args) {

        String fileName = "berlin52.tsp";

        try {
            ArrayList<City> coordinates = readData(fileName);

            int[] optimalSolution =
                    {1, 49, 32, 45, 19, 41, 8, 9, 10, 43, 33, 51, 11, 52, 14, 13, 47, 26, 27, 28, 12, 25, 4, 6, 15, 5, 24,
                    48, 38, 37, 40, 39, 36, 35, 34, 44, 46, 16, 29, 50, 20, 23, 30, 2, 7, 42, 21, 17, 3, 18, 31, 22, 1};
            double optimalSolutionEval = evaluateSolution(optimalSolution, coordinates);

            System.out.println("Optimal solution: " + optimalSolutionEval);

            int tryCount = 10;
            int iterationCount = 100;

            System.out.println("\n\n --- LOCAL SEARCH ---");

            displayMinAvgMax(tryCount, "NOT", iterationCount, coordinates,"SEQUENTIAL", "RANDOM", optimalSolution);
            displayMinAvgMax(tryCount, "NOT", iterationCount, coordinates,"SEQUENTIAL", "LOCAL", optimalSolution);
            displayMinAvgMax(tryCount, "NOT", iterationCount, coordinates,"RANDOM", "RANDOM", optimalSolution);
            displayMinAvgMax(tryCount, "NOT", iterationCount, coordinates,"RANDOM", "LOCAL", optimalSolution);
            displayMinAvgMax(tryCount, "NOT", iterationCount, coordinates,"GREEDY", "RANDOM", optimalSolution);
            displayMinAvgMax(tryCount, "NOT", iterationCount, coordinates,"GREEDY", "LOCAL", optimalSolution);

            System.out.println("\n\n --- LOCAL SEARCH EXTENDED --- ");

            displayMinAvgMax(tryCount, "YES", iterationCount, coordinates,"SEQUENTIAL", "RANDOM", optimalSolution);
            displayMinAvgMax(tryCount, "YES", iterationCount, coordinates,"SEQUENTIAL", "LOCAL", optimalSolution);
            displayMinAvgMax(tryCount, "YES", iterationCount, coordinates,"RANDOM", "RANDOM", optimalSolution);
            displayMinAvgMax(tryCount, "YES", iterationCount, coordinates,"RANDOM", "LOCAL", optimalSolution);
            displayMinAvgMax(tryCount, "YES", iterationCount, coordinates,"GREEDY", "RANDOM", optimalSolution);
            displayMinAvgMax(tryCount, "YES", iterationCount, coordinates,"GREEDY", "LOCAL", optimalSolution);

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

    public static int[] sequentialSolution(ArrayList<City> coordinates) {

        ArrayList<City> coordinatesCopy = new ArrayList<>(coordinates);

        int[] solution = new int[coordinatesCopy.size()+1];
        City destination;

        int index = 0;

        while(coordinatesCopy.size() > 0) {

            destination = coordinatesCopy.get(0);

            solution[index++] = destination.getIndex();
            coordinatesCopy.remove(destination);
        }

        solution[index] = coordinates.get(0).getIndex();

        return solution;
    }

    // random solution
    public static int[] randomSolution(ArrayList<City> coordinates) {

        ArrayList<City> coordinatesCopy = new ArrayList<>(coordinates);
        Random random = new Random();

        int[] solution = new int[coordinatesCopy.size()+1];
        int initialIndex = random.nextInt(coordinatesCopy.size());
        int index = 0;

        solution[index] = coordinatesCopy.get(initialIndex).getIndex();
        coordinatesCopy.remove(initialIndex);
        City destination;

        if(coordinatesCopy.size() == 0) {
            System.out.println("Only one city; therefor, no distance to travel");
            return solution;
        }

        while(coordinatesCopy.size() > 0) {

            int randomIndex = random.nextInt(coordinatesCopy.size());
            destination = coordinatesCopy.get(randomIndex);
            solution[++index] = destination.getIndex();
            coordinatesCopy.remove(destination);
        }

        solution[++index] = coordinates.get(initialIndex).getIndex();

        return solution;
    }

    public static int[] randomSearchStep(int[] previousSolution, ArrayList<City> coordinates, int iterationCount) {

        int[] bestSolution = previousSolution.clone();

        int[] currentSolution;

        Random random = new Random();

        for(int i = 0; i<iterationCount; i++) {

            currentSolution = previousSolution.clone();
            int randomIndex1 = random.nextInt(currentSolution.length - 2);
            int randomIndex2 = random.nextInt(currentSolution.length - 2);

            int buffer1 = currentSolution[randomIndex1];
            int buffer2 = currentSolution[randomIndex2];
            currentSolution[randomIndex1] = currentSolution[randomIndex2];
            currentSolution[randomIndex2] = buffer1;

            if (randomIndex1 == 0) {
                currentSolution[currentSolution.length - 1] = buffer2;
            }

            if (randomIndex2 == 0) {
                currentSolution[currentSolution.length - 1] = buffer1;
            }

            if(evaluateSolution(bestSolution, coordinates) > evaluateSolution(currentSolution, coordinates)) {
                bestSolution = currentSolution.clone();
                return bestSolution;
            }
        }

        return bestSolution;
    }

    public static int[] localSearchStep (int[] previousSolution, ArrayList<City> coordinates) {

        int[] bestSolution = previousSolution.clone();

        int[] currentSolution;

        for(int i=0; i<previousSolution.length-1; i++) {

            for(int j=0; j<previousSolution.length-1; j++) {

                currentSolution = previousSolution.clone();

                int buffer1 = currentSolution[i];
                int buffer2 = currentSolution[j];
                currentSolution[i] = buffer2;
                currentSolution[j] = buffer1;

                if(i == 0) {
                    currentSolution[currentSolution.length-1] = buffer2;
                }

                if(j == 0) {
                    currentSolution[currentSolution.length-1] = buffer1;
                }

                if(evaluateSolution(bestSolution, coordinates) > evaluateSolution(currentSolution, coordinates)) {
                    bestSolution = currentSolution.clone();
                }
            }


        }

        return bestSolution;
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

    public static int[] localSearch(ArrayList<City> coordinates, final String initialSolution, final String localSearchType) {

        boolean localMin = false;

        int[] solution = switch (initialSolution) {
            case "SEQUENTIAL" -> sequentialSolution(coordinates);
            case "RANDOM" -> randomSolution(coordinates);
            case "GREEDY" -> greedyAlgorithm(coordinates);
            default -> throw new IllegalArgumentException();
        };

        do {

            int[] currentSolution;
            if (localSearchType.equals("RANDOM")) {
                currentSolution = randomSearchStep(solution, coordinates, 50);
            } else if (localSearchType.equals("LOCAL")) {
                currentSolution = localSearchStep(solution, coordinates);
            } else {
                throw new IllegalArgumentException();
            }

            if(evaluateSolution(solution, coordinates) > evaluateSolution(currentSolution, coordinates)) {
                solution = currentSolution.clone();
            } else {
                localMin = true;
            }

        } while(!localMin);

        return solution;
    }

    public static int[] localSearchExtended (final int iterationCount, final ArrayList<City> coordinates,
                                             final String initialSolution, final String localSearchType) {

        int[] bestSolution = localSearch(coordinates, initialSolution, localSearchType);
        int i = 0;

        do {
            int[] currentSolution = localSearch(coordinates, initialSolution, localSearchType);

            if(evaluateSolution(currentSolution, coordinates) < evaluateSolution(bestSolution, coordinates)) {
                bestSolution = currentSolution;
            }

            i++;
        } while (i < iterationCount);

        return bestSolution;
    }

    public static double bestSolutionPercentage(ArrayList<City> coordinates, double bestSolution, int[] solution) {

        return Math.round(evaluateSolution(solution, coordinates)/bestSolution * 10000)/100.0;
    }

    public static void displayMinAvgMax(final int startAlgoCount, final String extendedOrNot, final int iterationCount,
                                        final ArrayList<City> coordinates,
                                        final String initialSolution, final String localSearchType,
                                        final int[] optimalSolution) {

        double optimalSolutionEval = evaluateSolution(optimalSolution, coordinates);

        int[] bestSolution = null;
        int[] worstSolution = null;

        double averageVal = 0;

        System.out.println("initial solution: " + initialSolution + ", search type: " + localSearchType + "; extended? " + extendedOrNot);
        for(int i = 0; i<startAlgoCount; i++) {

            int[] currentSolution;

            if(!extendedOrNot.equals("YES")) {
                currentSolution = localSearch(coordinates, initialSolution, localSearchType);
            } else {
                currentSolution = localSearchExtended (iterationCount, coordinates, initialSolution, localSearchType);
            }

            if(bestSolution == null) {
                bestSolution = currentSolution.clone();
            } else if(evaluateSolution(bestSolution, coordinates) > evaluateSolution(currentSolution, coordinates)) {
                bestSolution = currentSolution;
            }

            if(worstSolution == null) {
                worstSolution = currentSolution.clone();
            } else if(evaluateSolution(worstSolution, coordinates) < evaluateSolution(currentSolution, coordinates)) {
                worstSolution = currentSolution;
            }

            averageVal += evaluateSolution(currentSolution, coordinates);

        }

        System.out.println(Arrays.toString(bestSolution));
        System.out.println(evaluateSolution(bestSolution, coordinates));
        System.out.println(bestSolutionPercentage(coordinates, optimalSolutionEval, bestSolution) + "% najlepszego rozwiązania - najlepszy");

        System.out.println(Arrays.toString(worstSolution));
        System.out.println(evaluateSolution(worstSolution, coordinates));
        System.out.println(bestSolutionPercentage(coordinates, optimalSolutionEval, worstSolution) + "% najlepszego rozwiązania - najgorszy");

        averageVal /= startAlgoCount;
        System.out.println(averageVal);
        System.out.println((averageVal/optimalSolutionEval * 10000)/100.0 + "% najlepszego rozwiązania - średnie\n");


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
