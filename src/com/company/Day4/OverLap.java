package com.company.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OverLap {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(
                "/Users/abhirami/learning/adventOfCode/src/com/company/Day4/input.txt");
        Scanner sc = new Scanner(file);

        int count =0,count1=0;
        while (sc.hasNextLine()){

            String input = sc.nextLine();
            String[] ranges = input.split(",");
            String[] firstElfRange = ranges[0].split("-");
            String[] secondElfRange = ranges[1].split("-");

            int elfx1 = Integer.parseInt(firstElfRange[0]);
            int elfy1 = Integer.parseInt(firstElfRange[1]);
            int elfx2 = Integer.parseInt(secondElfRange[0]);
            int elfy2 = Integer.parseInt(secondElfRange[1]);

            count = fullyOverlap(count, elfx1, elfy1, elfx2, elfy2);
            count1 = partialOverlap(count1, elfx1, elfy1, elfx2, elfy2);

        }
        System.out.println(count);
        System.out.println(count1);
    }

    private static int fullyOverlap(int count, int elfx1, int elfy1, int elfx2, int elfy2) {
        if(elfx1 >= elfx2 && elfy1 <= elfy2){
            count += 1;
        }else if(elfx2 >= elfx1 && elfy2 <= elfy1){
            count += 1;
        }
        return count;
    }

    private static int partialOverlap(int count, int elfx1, int elfy1, int elfx2, int elfy2) {
        if(elfx2 <= elfy1 && elfx1 <= elfy2){
            count += 1;
        }
        return count;
    }
}
