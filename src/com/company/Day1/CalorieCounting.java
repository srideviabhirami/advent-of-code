package com.company.Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCounting {

    public static void main(String[] args) throws IOException {
        // File path is passed as parameter
        File file = new File(
                "/Users/abhirami/learning/adventOfCode/src/com/company/Day1/input.txt");

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader br
                = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        List<Integer> lst = output1(br);
        output2(lst);

    }

    private static void output2(List<Integer> lst) {
        Collections.sort(lst);
        Collections.reverse(lst);
        // Print the string
        System.out.println(lst.get(0)+ lst.get(1)+ lst.get(2));
    }

    private static List<Integer> output1(BufferedReader br) throws IOException {
        String st;
        int sum = 0, max = 0;
        List<Integer> lst = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            if (st.isBlank()) {
                lst.add(sum);
                sum=0;
            } else {
                sum += Integer.valueOf(st);
            }
            if (sum >= max) {
                max = sum;
            }
        }
        System.out.println(max);
        return lst;

    }
}
