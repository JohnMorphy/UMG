import java.util.Arrays;
import java.util.Random;

public abstract class Lab_07_Chromosome {

    private final double lowerBound;
    private final double upperBound;
    private final int resolution;
    private int size;
    private int numberOfGenomes;

    public Lab_07_Chromosome() {
        this(-2.0, 2.0, 5, 2);
    }

    public Lab_07_Chromosome(double lowerBound, double upperBound, int resolution, int numberOfGenomes) {

        long intervalCount = (long) Math.floor( (upperBound-lowerBound)*Math.pow(10,resolution) )+1;

        int calculateSize = 1;

        while(Math.pow(2, calculateSize)<intervalCount) {
            calculateSize++;
        }

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.resolution = resolution;
        this.size = calculateSize;
        this.numberOfGenomes = numberOfGenomes;

    }
    private void fillWithRandom(byte[] arr) {
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (byte) rand.nextInt(2);
        }
    }

    private byte[][] generateChromosome() {
        if (size <= 0) {
            size = 1;
        }

        if (numberOfGenomes <= 0) {
            numberOfGenomes = 1;
        }

        byte[][] values = new byte[numberOfGenomes][size];

        for (int i = 0; i < numberOfGenomes; i++) {
            while (true) {
                this.fillWithRandom(values[i]);
                double real = getRealValue(getDecimal(values[i]));
                if (real <= upperBound) {
                    break;
                }
            }
        }
        return values;
    }

    public byte[][][] generatePopulation(int numberOfChromosomes) {
        byte[][][] population = new byte[numberOfChromosomes][numberOfGenomes][size];

        for (int i = 0; i < numberOfChromosomes; i++) {
            population[i] = generateChromosome();
        }

        return population;
    }

    public void printTable(byte[] arr) {
        for (byte i : arr) {
            System.out.print(i);
        }
    }

    public void printChromosome(byte[][] chromosome) {
        for (byte[] genome:chromosome) {
            printTable(genome);
            System.out.print(" ");
        }
    }


    public void printPopulation(byte[][][] population) {
        for (byte[][] chromosome:population) {
            System.out.println();
            printChromosome(chromosome);
        }
    }

    public void printPopulationReal(byte [][][] population) {
        for (byte[][] chromosome:population) {
            System.out.println();
            printChromosome(chromosome);
            System.out.print(" ");
            System.out.print(getFunctionResult(getRealValues(chromosome)));
        }
    }

    private byte[][] stringToChromosome(String value) {
        byte[][] chromosome = new byte[numberOfGenomes][size];

        for (int i = 0; i < numberOfGenomes; i++) {
            for (int j = 0; j < size; j++) {
                chromosome[i][j] = (byte) ((byte) value.charAt(i * size + j) == 48 ? 0 : 1);
            }
        }

        return chromosome;
    }

    private double getAverage(byte[][][] population) {
        double average = 0;

        for (byte[][] chromosome:population) {
            average += getFunctionResult(getRealValues(chromosome));
        }

        average /= population.length;

        return average;
    }

    private double getBest(byte[][][] population) {
        double best = getFunctionResult(getRealValues(population[0]));

        for (byte[][] chromosome:population) {
            best = Math.max(getFunctionResult(getRealValues(chromosome)), best);
        }

        return best;
    }

    private byte[][][] rouletteSelection(byte[][][] population) {

        double[] functionValues = new double[population.length];

        for (int i=0; i<functionValues.length; i++) {
            functionValues[i] = getFunctionResult(getRealValues(population[i]));
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
            probability[i] = improvementPercentage[i]+(1/(double)population.length);
            rangeOfSelection[i] = rangeOfSelection[i-1] + probability[i];
        }

        byte[][][] populationAfterSelection = population.clone();

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

    private byte[][] cross(byte[][] parent1, byte[][] parent2, int numberOfCrossings) {

        boolean correctCrossing;
        int[] pointOfCross = new int[numberOfCrossings];

        byte[][] child;


        String strParent1 = "";
        for(int i = 0; i<parent1.length; i++) {
            strParent1 += Arrays.toString(parent1[i]);
        }
        strParent1 = strParent1.replaceAll(("[\\[\\]\\s,]"), "");

        String strParent2 = "";
        for(int i = 0; i<parent1.length; i++) {
            strParent2 += Arrays.toString(parent1[i]);
        }
        strParent2 = strParent2.replaceAll(("[\\[\\]\\s,]"), "");


        do {
            correctCrossing = true;

            StringBuilder strChild = new StringBuilder();

            for(int i=0; i<numberOfCrossings; i++) {
                pointOfCross[i] = (int)(Math.random()*size*numberOfGenomes);
            }

            Arrays.sort(pointOfCross);
            int crossCount = 0;

            for(int i = 0; i<strParent1.length(); i++) {

                while(crossCount<numberOfCrossings && i>=pointOfCross[crossCount]) {
                    crossCount++;
                }

                if(crossCount%2 == 0) {
                    strChild.append(strParent1.charAt(i));
                } else {
                    strChild.append(strParent2.charAt(i));
                }
            }
            child = this.stringToChromosome(strChild.toString());

            for(int i = 0; i<child.length; i++) {
                if (this.getRealValue(this.getDecimal(child[i])) > this.upperBound) {
                    correctCrossing = false;
                    break;
                }
            }

        } while (!correctCrossing);

        return child;
    }

    private byte[][] mutate(byte[][] chromosome, double probabilityOfMutation) {

        byte[][] mutated = chromosome.clone();

        boolean nonAllowedValues;

        do {
            nonAllowedValues = false;
            for (int i = 0; i < mutated.length; i++) {
                for (int j = 0; j < mutated[i].length; j++) {
                    if (Math.random() < probabilityOfMutation) {
                        mutated[i][j] = (byte) ((mutated[i][j] == 1) ? 0 : 1);
                    }
                }
                double real = getRealValue(getDecimal(mutated[i]));
                if (real > upperBound) {
                    nonAllowedValues = true;
                    break;
                }
            }
        } while (nonAllowedValues);

        return mutated;
    }

    private long getDecimal(byte[] arr) {

        long result = 0;

        for (int i = 0; i < arr.length; i++) {
            result += arr[i] * Math.pow(2, arr.length - i - 1);
        }

        return result;
    }

    public double[] getRealValues(byte[][] bitValues) {
        double[] realValues = new double[bitValues.length];

        for (int i = 0; i < numberOfGenomes; i++) {
            long decimal = getDecimal(bitValues[i]);
            realValues[i] = getRealValue(decimal);
        }

        return realValues;
    }

    private double getRealValue(long decimal) {
        return lowerBound + decimal * (upperBound - lowerBound) / ((upperBound - lowerBound) * Math.pow(10, resolution));
    }

    public byte[][][] evolutionCycle(byte[][][] population, int numberOfCrossings, double probabilityOfChromosomeCrossing,
                                     double probabilityOfChromosomeMutation, double probabilityOfMutation) {

        byte[][][] selectedPopulation = this.rouletteSelection(population);

        int numberOfChromosomes = selectedPopulation.length;

        for (int i=0; i<numberOfChromosomes; i++) {
            if(Math.random()<0.6) {
                int numOfChromosome = (int)Math.floor(Math.random()*numberOfChromosomes);
                selectedPopulation[i] = this.cross(selectedPopulation[i], selectedPopulation[numOfChromosome], numberOfCrossings);
            }

            if(Math.random()<0.02) {
                selectedPopulation[i] = this.mutate(selectedPopulation[i], probabilityOfMutation);
            }
        }


        return selectedPopulation;
    }

    public byte[][][][] geneticAlgorithm(int maxEvaluations,
                                       byte[][][] population,
                                       int numberOfCrossings, double probabilityOfChromosomeCrossing,
                                       double probabilityOfChromosomeMutation, double probabilityOfMutation) {

        int numberOfChromosomes = population.length;
        int numberOfGenerations = maxEvaluations/numberOfChromosomes;
        byte[][][][] allGenerations = new byte[numberOfGenerations][][][];

        byte[][][] currentPopulation = population.clone();

        for(int i=0; i<numberOfGenerations; i++) {
            currentPopulation = evolutionCycle(currentPopulation,
                    numberOfCrossings, probabilityOfChromosomeCrossing,
                    probabilityOfChromosomeMutation,probabilityOfMutation);
            allGenerations[i] = currentPopulation.clone();
        }

        return allGenerations;
    }

    public void printInformationAboutGenerations(byte[][][][] generations) {

        double average;
        double bestCurrent;
        double bestGlobal = this.getBest(generations[0]);

        for(int i = 0; i<generations.length; i++) {

            average = this.getAverage(generations[i]);
            bestCurrent = this.getBest(generations[i]);
            bestGlobal = Math.max(bestGlobal, bestCurrent);

            System.out.println((i+1) + ";" + average + ";" + bestCurrent + ";" + bestGlobal);
        }
    }

    // abstract method
    abstract double getFunctionResult(double[] values);

}
