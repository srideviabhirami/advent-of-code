package com.company.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class RuckSack {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(
                "/Users/abhirami/learning/adventOfCode/src/com/company/Day3/input.txt");
        Scanner sc = new Scanner(file);

        Map<Character, Integer> lowerCase = new HashMap<>();
        Map<Character, Integer> upperCase = new HashMap<>();
        int value = 1;
        for (Character ch = 'a'; ch <= 'z'; ++ch)
            lowerCase.put(ch, value++);
        for (Character ch = 'A'; ch <= 'Z'; ++ch)
            upperCase.put(ch, value++);

        int score = output1(sc, lowerCase, upperCase);
        sc = new Scanner(file);
        int score1 = output2(sc, lowerCase, upperCase);



        System.out.println(score);
        System.out.println(score1);
    }

    private static int output1(Scanner sc, Map<Character, Integer> lowerCase, Map<Character, Integer> upperCase) {
        int score = 0;
        while (sc.hasNextLine()) {

            String input = sc.nextLine();
            int length = input.length();
            List<Character> firstCompartment = new ArrayList<>();
            for (char ch : input.substring(0, length / 2).toCharArray()) {
                firstCompartment.add(ch);
            }
            List<Character> secondCompartment = new ArrayList<>();
            for (char ch : input.substring(length / 2, length).toCharArray()) {
                secondCompartment.add(ch);
            }

            Set<Character> result = firstCompartment.stream()
                    .distinct()
                    .filter(secondCompartment::contains)
                    .collect(Collectors.toSet());

            for(char ch: result){
                if(Character.isLowerCase(ch)){
                    score += lowerCase.get(ch);
                }else{
                    score += upperCase.get(ch);
                }
            }

        }
        return score;
    }

    private static int output2(Scanner sc, Map<Character, Integer> lowerCase, Map<Character, Integer> upperCase) {
        int score1 = 0;

        while (sc.hasNextLine()) {
            List<Character> firstLine = new ArrayList<>();
            List<Character> secondLine = new ArrayList<>();
            List<Character> thirdLine = new ArrayList<>();
            String input = sc.nextLine();
            for(char ch: input.toCharArray()){
                firstLine.add(ch);
            }

            if(sc.hasNextLine()){
                input = sc.nextLine();
                for(char ch: input.toCharArray()){
                    secondLine.add(ch);
                }
            }

            if(sc.hasNextLine()){
                input = sc.nextLine();
                for(char ch: input.toCharArray()){
                    thirdLine.add(ch);
                }
            }

            Set<Character> intersection = firstLine.stream()
                    .distinct()
                    .filter(secondLine::contains)
                    .filter(thirdLine::contains)
                    .collect(Collectors.toSet());


            for(char ch: intersection){
                if(Character.isLowerCase(ch)){
                    score1 += lowerCase.get(ch);
                }else{
                    score1 += upperCase.get(ch);
                }
            }
        }
        return score1;
    }
}
