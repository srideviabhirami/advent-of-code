package com.company.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SupplyStack {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(
                "/Users/abhirami/learning/adventOfCode/src/com/company/Day5/input.txt");
        Scanner sc = new Scanner(file);

        List<List<Character>> stack = getInputList(sc);
        Stack<Stack<Character>> finalStack = getFinalStack(stack);
        List<List<Character>> finalList = (List<List<Character>>) getFinalStack(stack).clone();
        System.out.println(finalStack);

        List<List<Integer>> instructions = getInstructions(sc);

        output1(instructions, finalStack);

        output2(instructions, finalList);

    }

    private static void output1(List<List<Integer>> instructions, Stack<Stack<Character>> finalStack) {
        for (int i = 0; i < instructions.size(); i++) {
            Integer crateCount = instructions.get(i).get(0);
            Integer fromStack = instructions.get(i).get(1);
            Integer toStack = instructions.get(i).get(2);
            for (int j = 0; j < crateCount; j++) {
                finalStack.get(toStack-1).push(finalStack.get(fromStack-1).pop());
            }
            // output is top of stack item for each stack
        }
        System.out.println(finalStack);
    }

    private static void output2(List<List<Integer>> instructions, List<List<Character>> finalList) {
        for (int i = 0; i < instructions.size(); i++) {
            Integer crateCount = instructions.get(i).get(0);
            Integer fromStack = instructions.get(i).get(1);
            Integer toStack = instructions.get(i).get(2);
            for (int j = crateCount; j > 0; j--) {
                finalList.get(toStack-1)
                        .add(finalList.get(fromStack-1)
                                .remove(finalList.get(fromStack-1).size()-j));

            }
            // output is top of stack item for each stack
        }
        System.out.println(finalList);
    }

    private static List<List<Integer>> getInstructions(Scanner sc){
        List<List<Integer>> instructions = new ArrayList<>();
        while (sc.hasNextLine()){
            String input = sc.nextLine();
            String[] commands = input.split(" ");
            if(input.isBlank())
                continue;
            Integer crateCount = Integer.valueOf(commands[1]);
            Integer fromStack = Integer.valueOf(commands[3]);
            Integer toStack = Integer.valueOf(commands[5]);
            instructions.add(Arrays.asList(crateCount,fromStack,toStack));
        }
        return instructions;
    }

    private static Stack<Stack<Character>> getFinalStack(List<List<Character>> stack) {
        Stack<Stack<Character>> finalStack = new Stack<>();
        for (int i = 0; i < stack.get(0).size() ; i++) {
            Stack<Character> row = new Stack<>();
            for (int j = stack.size()-1; j >= 0; j--) {
                Character crate = stack.get(j).get(i);
                if (Character.isLetter(crate))
                    row.add(crate);
            }
            finalStack.push(row);
        }
        return finalStack;
    }

    private static List<List<Character>> getInputList(Scanner sc) {
        List<List<Character>> stack = new ArrayList<>();
        while (sc.hasNextLine()){
            String input = sc.nextLine();
            if(input.isBlank()){
                break;
            }
            String[] crates = input.split(" ");
            List<Character> row = new ArrayList<>();
            for(String crate: crates){
                if(crate.length() == 0)
                    return stack;
                row.add(crate.charAt(1));
            }
            stack.add(row);
        }
        return stack;
    }
}
