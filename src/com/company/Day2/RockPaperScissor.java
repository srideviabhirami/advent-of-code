package com.company.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RockPaperScissor {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(
                "/Users/abhirami/learning/adventOfCode/src/com/company/Day2/input.txt");

        Map<String , String> winningMap = new HashMap<>();
        winningMap.put("X", "C");
        winningMap.put("Y", "A");
        winningMap.put("Z", "B");

        Map<String , String> winningMaps = new HashMap<>();
        winningMaps.put("C","X");
        winningMaps.put("A","Y");
        winningMaps.put("B","Z");

        Map<String , String> losingMap = new HashMap<>();
        losingMap.put("A", "Z");
        losingMap.put("B", "X");
        losingMap.put("C", "Y");

        Map<String , String> drawMap = new HashMap<>();
        drawMap.put("X", "A");
        drawMap.put("Y", "B");
        drawMap.put("Z", "C");

        Map<String , Integer> map1 = new HashMap<>();
        map1.put("X", 1);
        map1.put("Y", 2);
        map1.put("Z", 3);

        Map<String , Integer> map2 = new HashMap<>();
        map2.put("A", 1);
        map2.put("B", 2);
        map2.put("C", 3);



        Scanner sc = new Scanner(file);

        int score = output1(winningMap, drawMap, map1, sc);
        int score1 = output2(winningMaps, losingMap, map1, map2, sc);
        System.out.println(score);
        System.out.println(score1);

    }

    private static int output2(Map<String, String> winningMaps, Map<String, String> losingMap, Map<String, Integer> map1, Map<String, Integer> map2, Scanner sc) {
        int score1 =0 ;
        while (sc.hasNextLine()){
            String input = sc.nextLine();
            String[] inputs = input.split(" ");
            if(inputs[1].equals("X")){
                score1 += map1.get(losingMap.get(inputs[0])) ;
            }
            else if(inputs[1].equals("Y")) {
                score1 += map2.get(inputs[0]) + 3;
            }
            else if(inputs[1].equals("Z")) {
                score1 += map1.get(winningMaps.get(inputs[0])) + 6;
            }
        }
        return score1;
    }

    private static int output1(Map<String, String> winningMap, Map<String, String> drawMap, Map<String, Integer> map1, Scanner sc) {
        int score = 0;
        while (sc.hasNextLine()){
            String input = sc.nextLine();
            String[] inputs = input.split(" ");
            if(winningMap.get(inputs[1]).equals(inputs[0])){
                score += 6;
            }
            else if(drawMap.get(inputs[1]).equals(inputs[0])) {
                score += 3;
            }
            score += map1.get(inputs[1]);
        }
        return score;
    }
}
