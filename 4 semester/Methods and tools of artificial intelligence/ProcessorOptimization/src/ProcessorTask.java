import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ProcessorTask {

    public final int[] task;
    public final int numberOfProcessors;

    public ProcessorTask() {
        this(generateTasks(1, 100, 10), 2);
    }

    public ProcessorTask(int[] tasks, int numberOfProcessors) {
        this.task = tasks;
        this.numberOfProcessors = numberOfProcessors;
    }

    public static int[] generateTasks(int lowerBound, int upperBound, int length) {
        if (lowerBound > upperBound || length <= 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        int[] randomArray = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        }

        return randomArray;
    }


    public int[] assignTasks() {

        Random random = new Random();
        int randomInt;
        int[] taskAssignment = new int[task.length];

        for (int i = 0; i< task.length; i++) {
            randomInt = random.nextInt(numberOfProcessors);
            taskAssignment[i] = randomInt;
        }

        return taskAssignment;
    }

    public int evaluateTaskArray(int[] chromosome) {

        int[] processorWorkTime = new int[numberOfProcessors];

        for (int i = 0; i<task.length; i++) {
            processorWorkTime[chromosome[i]] += task[i];
        }

        int jobLength = processorWorkTime[0];

        for(int i = 1; i<processorWorkTime.length; i++) {
            jobLength = Math.max(processorWorkTime[i], jobLength);
        }
        return jobLength;
    }

    public void showResult(int[] chromosome) {
        ArrayList<Integer>[] processorWork = new ArrayList[numberOfProcessors];

        for (int i = 0; i < processorWork.length; i++) {
            processorWork[i] = new ArrayList<>();
        }

        for (int i = 0; i< chromosome.length; i++) {
            processorWork[chromosome[i]].add(i);
        }

        System.out.println();
        for(int i = 0; i<numberOfProcessors; i++) {
            System.out.print("p"+(i+1)+";");
            for (int j = 0; j < processorWork[i].size(); j++) {
                System.out.print(processorWork[i].get(j) + ";");
            }
        }

        System.out.print("Cmax=;" + evaluateTaskArray(chromosome) + ";");

    }

    public int[] cross(int[] parent1, int[] parent2, int numberOfCrossings) {

        int[] pointOfCross = new int[numberOfCrossings];

        int[] child = new int[task.length];

        for(int i=0; i<numberOfCrossings; i++) {
            pointOfCross[i] = (int)(Math.random()*task.length);
        }

        Arrays.sort(pointOfCross);
        int crossCount = 0;

        for(int i = 0; i<parent1.length; i++) {

            while(crossCount<numberOfCrossings && i>=pointOfCross[crossCount]) {
                crossCount++;
            }

            if(crossCount%2 == 0) {
                child[i] = parent1[i];
            } else {
                child[i] = parent2[i];
            }
        }

        return child;
    }

    public int[] mutate(int[] chromosome, double probabilityOfMutation) {

        int[]mutated = chromosome.clone();
        Random random = new Random();

        for (int i=0; i<chromosome.length; i++) {
            if (Math.random() < probabilityOfMutation) {
                mutated[i] = random.nextInt(numberOfProcessors);
            }
        }

        return mutated;
    }

    public void printChromosome(int[] chromosome) {
        System.out.println(Arrays.toString(chromosome));
    }


    public int[][] generatePopulation(int numberOfChromosomes) {
        int[][] population = new int[numberOfChromosomes][task.length];

        for (int i = 0; i<population.length; i++) {
            population[i] = assignTasks();
        }

        return population;
    }

    public int[][] rouletteSelection(int[][] population) {

        double[] functionValues = new double[population.length];

        for (int i=0; i<functionValues.length; i++) {
            functionValues[i] = -1 * evaluateTaskArray(population[i]);
        }

        double minFunctionValue = functionValues[0];

        for (int i = 1; i < functionValues.length; i++) {
            if (functionValues[i] < minFunctionValue) {
                minFunctionValue = functionValues[i];
            }
        }

        double[] distanceFromMin = new double[population.length];
        for (int i=0; i<distanceFromMin.length; i++) {
            distanceFromMin[i] = functionValues[i] - minFunctionValue;
        }

        double[] improvementPercentage = new double[population.length];

        double modulatedMinFunctionValue = (minFunctionValue<0) ? -minFunctionValue : minFunctionValue;

        for (int i=0; i<improvementPercentage.length; i++) {
            improvementPercentage[i] = distanceFromMin[i]/modulatedMinFunctionValue;
        }

        double[] probability = new double[population.length];
        double[] rangeOfSelection = new double[population.length];

        probability[0] = improvementPercentage[0]+(1/(double)population.length);
        rangeOfSelection[0] = probability[0];

        for (int i=1; i<probability.length; i++) {
            probability[i] = 10*improvementPercentage[i]+(1/(double)population.length);
            rangeOfSelection[i] = rangeOfSelection[i-1] + probability[i];
        }

        int[][] populationAfterSelection = population.clone();

        for(int i=0; i<population.length; i++) {
            double random = Math.random()*rangeOfSelection[population.length-1];
            for (int j=0; j<rangeOfSelection.length; j++) {
                if(random<rangeOfSelection[j]) {
                    populationAfterSelection[i] = population[j];
                    break;
                }
            }
        }

        return populationAfterSelection;
    }

    public double getAverage(int[][] population) {
        double average = 0;

        for (int[] chromosome:population) {
            average += evaluateTaskArray(chromosome);
        }

        int populationSize = population.length;

        average = average/(double)populationSize;

        return average;
    }

    public int[] getBest(int[][] population) {
        int[] best = population[0];

        int currentEvaluation;

        for (int[] chromosome:population) {
            currentEvaluation = evaluateTaskArray(chromosome);
            if(currentEvaluation < this.evaluateTaskArray(best)) {
                best = chromosome.clone();
            }

        }

        return best;
    }

    public void printPopulationInformation(int[][] population) {
        System.out.println(getAverage(population) + "  " + evaluateTaskArray(getBest(population)));
    }

    public int[][][] geneticAlgorithm(int maxEvaluations,
                                         int[][] population,
                                         int numberOfCrossings, double probabilityOfChromosomeCrossing,
                                         double probabilityOfChromosomeMutation, double probabilityOfMutation) {

        int numberOfChromosomes = population.length;
        int numberOfGenerations = maxEvaluations/numberOfChromosomes;
        int[][][] allGenerations = new int[numberOfGenerations][][];

        int[][] currentPopulation = population.clone();

        for(int i=0; i<numberOfGenerations; i++) {
            currentPopulation = evolutionCycle(currentPopulation,
                    numberOfCrossings, probabilityOfChromosomeCrossing,
                    probabilityOfChromosomeMutation,probabilityOfMutation);
            allGenerations[i] = currentPopulation.clone();
        }

        return allGenerations;
    }
    public int[][] evolutionCycle(int[][] population, int numberOfCrossings, double probabilityOfChromosomeCrossing,
                                     double probabilityOfChromosomeMutation, double probabilityOfMutation) {

        int[][] selectedPopulation = this.rouletteSelection(population);

        int numberOfChromosomes = selectedPopulation.length;

        for (int i=0; i<numberOfChromosomes; i++) {
            if(Math.random()<probabilityOfChromosomeCrossing) {
                int numOfChromosome = (int)Math.floor(Math.random()*numberOfChromosomes);
                selectedPopulation[i] = this.cross(selectedPopulation[i], selectedPopulation[numOfChromosome], numberOfCrossings);
            }

            if(Math.random()<probabilityOfChromosomeMutation) {
                selectedPopulation[i] = this.mutate(selectedPopulation[i], probabilityOfMutation);
            }
        }

        return selectedPopulation;
    }

    public double[][] getGenerationInformation(int[][][] generation) {

        double[][] generationInformation = new double[generation.length][3];

        double average;
        double bestCurrent;
        double bestGlobal = evaluateTaskArray(this.getBest(generation[0]));

        for(int i = 0; i<generation.length; i++) {

            average = this.getAverage(generation[i]);
            bestCurrent = evaluateTaskArray(this.getBest(generation[i]));
            bestGlobal = Math.min(bestGlobal, bestCurrent);

            generationInformation[i][0] = average;
            generationInformation[i][1] = bestCurrent;
            generationInformation[i][2] = bestGlobal;
        }

        return generationInformation;
    }

    public void printInformationAboutGeneration(int[][][] generation) {

        double[][] generationInformation = this.getGenerationInformation(generation);

        for(int i = 0; i<generationInformation.length; i++) {
            System.out.println((i+1) + ";" + generationInformation[i][0] + ";"
                    + generationInformation[i][1] + ";" + generationInformation[i][2]);
        }
    }

    public int[] saveAverageFromFiles(int maxEvaluations, int numberOfChromosomes,
                                     int numberOfCrossings, double probabilityOfChromosomeCrossing,
                                     double probabilityOfChromosomeMutation, double probabilityOfMutation,
                                     int numberOfFiles) {

        int[] bestOfPopulation;
        int[] bestGlobal = new int[task.length];

        int numberOfGenerations = maxEvaluations/numberOfChromosomes;

        double[][]data = new double[numberOfGenerations][3];

        for(int i = 0; i<numberOfFiles; i++) {
            int[][][] generations = this.geneticAlgorithm(maxEvaluations,
                    this.generatePopulation(numberOfChromosomes),
                    numberOfCrossings, probabilityOfChromosomeCrossing,
                    probabilityOfChromosomeMutation, probabilityOfMutation);

            for (int[][] population:generations) {
                bestOfPopulation = this.getBest(population);
                if(evaluateTaskArray(bestOfPopulation)<evaluateTaskArray(bestGlobal)) {
                    bestGlobal = bestOfPopulation.clone();
                }
            }

            String fileName = "output_" + "p" + this.numberOfProcessors + "_t" + this.task.length + "_" + i +".txt";
            this.saveToFile(generations, fileName);

            double[][] generationInformation = this.getGenerationInformation(generations);

            for (int j=0; j< data.length; j++) {
                data[j][0] += generationInformation[j][0];
                data[j][1] += generationInformation[j][1];
                data[j][2] += generationInformation[j][2];
            }
        }

        for(int i = 0; i<data.length; i++) {
            data[i][0] /= numberOfFiles;
            data[i][1] /= numberOfFiles;
            data[i][2] /= numberOfFiles;
        }

        String fileName = "result_" + "p" + this.numberOfProcessors + "_t" + this.task.length +".txt";
        this.saveToFile(data, fileName);

        return bestGlobal;
    }
    public void saveToFile(int[][][] generations, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            double[][] generationInformation = this.getGenerationInformation(generations);

            for(int i = 0; i<generationInformation.length; i++) {
                double average = generationInformation[i][0];
                double bestCurrent = generationInformation[i][1];
                double bestGlobal = generationInformation[i][2];
                writer.write((i+1) + ";" + average + ";" + bestCurrent + ";" + bestGlobal);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void saveToFile(double[][] generationInformation, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for(int i = 0; i<generationInformation.length; i++) {
                double average = generationInformation[i][0];
                double bestCurrent = generationInformation[i][1];
                double bestGlobal = generationInformation[i][2];
                writer.write( (i+1) + ";" + average + ";" + bestCurrent + ";" + bestGlobal);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
