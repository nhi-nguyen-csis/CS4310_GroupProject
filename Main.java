package com.company.nnguyen;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // create 1 thread of each computer
        // pid array and burst time array

        // read input.txt
        // read the text file
        File file = new File("src/com/company/nnguyen/input.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // read each line and store them into s1, s2, s3, s4
        String s1, s2, s3, s4;
        s1 = sc.nextLine();
        s2 = sc.nextLine();

        //convert each line from string to integer array by calling the helper() function
        ArrayList<Integer> pid = helper(s1);
        ArrayList<Integer> burst = helper(s2);

        ArrayList<Integer> pid1 = new ArrayList<Integer>();
        ArrayList<Integer> burst1 = new ArrayList<>();
        ArrayList<Integer> pid2 = new ArrayList<Integer>();
        ArrayList<Integer> burst2 = new ArrayList<>();
        ArrayList<Integer> pid3 = new ArrayList<Integer>();
        ArrayList<Integer> burst3 = new ArrayList<>();

        // loop through all processes and alternately assign them to each computer
        for (int i = 0; i < pid.size(); i++) {
            if (i % 3 == 1) { // assign to computer 1
                pid1.add(pid.get(i));
                burst1.add(burst.get(i));
            }
            else if (i % 3 == 2) { // assign to computer 2
                pid2.add(pid.get(i));
                burst2.add(burst.get(i));
            } else { // assign to computer 3
                pid3.add(pid.get(i));
                burst3.add(burst.get(i));
            }
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%s (FCFS) is assigned to the processes%n", "Computer 1");
        System.out.printf("pid = %s%n", pid1.toString());
        System.out.printf("burst time = %s%n", burst1.toString());
        System.out.println("------------------------------------------------------");
        System.out.printf("%s (SJF) is assigned to the processes%n", "Computer 2");
        System.out.printf("pid = %s%n", pid2.toString());
        System.out.printf("burst time = %s%n", burst2.toString());
        System.out.println("------------------------------------------------------");
        System.out.printf("%s (RR) is assigned to the processes%n", "Computer 3");
        System.out.printf("pid = %s%n", pid3.toString());
        System.out.printf("burst time = %s%n", burst3.toString());
        System.out.println("------------------------------------------------------\n");

        Thread computer1 = new Thread(new FCFS("Computer 1",pid1, burst1 ));
        Thread computer2 = new Thread(new SJF("Computer 2",pid2, burst2 ));
        Thread computer3 = new Thread(new RR("Computer 3",pid3, burst3, 2 ));
        computer1.start();
        computer2.start();
        computer3.start();

        try {
            computer1.join();
            computer2.join();
            computer3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Integer> helper(String s1) {
        // calling split() method on string
        String[] string = s1.split(" ");

        // declaring an integer array list to return to the calling method
        //int[] arr = new int[string.length];
        ArrayList<Integer> arr = new ArrayList<Integer>();

        // parsing the String into an integer
        for (int i = 0; i < string.length; i++) {
            arr.add(Integer.valueOf(string[i]));
        }
        return arr;
    }

}
