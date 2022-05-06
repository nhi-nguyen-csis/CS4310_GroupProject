package com.company.nnguyen;

import java.util.*;

public class FCFS extends Thread {
    String s;
    ArrayList<Integer> processes;
    ArrayList<Integer>  burstTime;
    public FCFS (String s, ArrayList<Integer> processes, ArrayList<Integer>  burstTime) {
        this.s = s;
        this.processes = processes;
        this.burstTime = burstTime;
    }
    public void run() {
        // call FCFS algorithm
        // this array keeps track of which processes will be assgined to the CPU in order
        ArrayList<Integer> orderProcessing = new ArrayList<Integer>();

        // loop through each item in the arrivalTime array to find the min
        for (int i = 0; i < processes.size(); i ++){
            System.out.printf("%s (FCFS) is working on process %d\n", s, processes.get(i));
            try{
                Thread.sleep(100);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.printf("%s (FCFS) is done\n", s);
    }
}
