package day1;

import utility.InputReader;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(1);

        List<Integer> depths = inputReader.readLinesToIntegerList("sea-floor-depth.txt");

        System.out.println("Part One Solution: " + getNumIncreasedMeasurements(depths));
        System.out.println("Part Two Solution: " + getNumIncreasedMeasurementsWindowed(depths));
    }

    private static int getNumIncreasedMeasurements(List<Integer> depths) {
        int count = 0;

        for(int i=0; i<depths.size()-1; i++) {
            if(depths.get(i+1) > depths.get(i)) {
                count++;
            }
        }

        return count;
    }

    private static int getNumIncreasedMeasurementsWindowed(List<Integer> depths) {
        int count = 0;

        for(int i=2; i<depths.size()-1; i++) {
            int lowerSum = depths.get(i-2) + depths.get(i-1) + depths.get(i);
            int upperSum = depths.get(i-1) + depths.get(i) + depths.get(i+1);

            if(upperSum > lowerSum) {
                count++;
            }
        }

        return count;
    }
}
