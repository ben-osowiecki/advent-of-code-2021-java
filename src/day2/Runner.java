package day2;

import utility.InputReader;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<String> rawInstructions = new InputReader(2).readLinesToStringList("course.txt");

        List<Instruction> instructions = rawInstructions.stream().map(i -> i.split(" ")).map(instArr -> new Instruction(Direction.valueOf(instArr[0].toUpperCase()), Integer.valueOf(instArr[1]))).toList();

        System.out.println("Part One Solution: " + calculateHorizontalPosition(instructions) * calculateVerticalPositionNoAim(instructions));
        System.out.println("Part Two Solution: " + calculateHorizontalPosition(instructions) * calculateVerticalPositionWithAim(instructions));
    }

    private static int calculateHorizontalPosition(List<Instruction> instructions) {
        return instructions.stream().filter(inst -> inst.direction().equals(Direction.FORWARD)).mapToInt(Instruction::distance).sum();
    }

    private static int calculateVerticalPositionNoAim(List<Instruction> instructions) {
        int upwardSum =  instructions.stream().filter(inst -> inst.direction().equals(Direction.UP)).mapToInt(Instruction::distance).sum();
        int downwardSum = instructions.stream().filter(inst -> inst.direction().equals(Direction.DOWN)).mapToInt(Instruction::distance).sum();

        return downwardSum-upwardSum;
    }

    private static int calculateVerticalPositionWithAim(List<Instruction> instructions) {
        int depth = 0;
        int aim = 0;

        for(Instruction instruction : instructions) {
            switch (instruction.direction()) {
                case UP -> aim-=instruction.distance();
                case DOWN -> aim+=instruction.distance();
                case FORWARD -> depth+=(aim*instruction.distance());
            }
        }
        return depth;
    }
}
