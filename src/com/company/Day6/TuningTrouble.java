package com.company.Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class TuningTrouble {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(
                "/Users/abhirami/learning/adventOfCode/src/com/company/Day6/input.txt");
        Scanner sc = new Scanner(file);
        String input = getInput(sc);
        output1(input,4);
        output1(input,14);
    }

    private static void output1(String input, Integer count) {
        for (int i = 0, j = count; i< input.length()-4 && j< input.length() ; i++,j++) {
            if(unique(input.substring(i,j))){
                System.out.println(input.substring(i,j));
                System.out.println(j);
                break;
            }
        }
    }

    private static String getInput(Scanner sc) {
        if(sc.hasNextLine()){
            return sc.nextLine();
        }
        return " ";
    }

    static boolean unique(String input)
    {
        Set<Character> set = input.chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());

        return set.size() == input.length();

    }

}
