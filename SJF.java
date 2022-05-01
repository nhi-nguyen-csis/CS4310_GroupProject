package com.company.nnguyen;

import java.util.*;

public class SJF extends Thread{
    String name;
    ArrayList<Integer> processes;
    ArrayList<Integer> burstTime;

    public SJF(String name, ArrayList<Integer> processes, ArrayList<Integer> burstTime) {
        this.name = name;
        this.processes = processes;
        this.burstTime = burstTime;
    }

    public void run(){
        bubbleSort(processes, burstTime);
        for (int i = 0; i < processes.size(); i++) {
            System.out.printf("%s (SJF) is working on process %d\n", name, processes.get(i));
        }
        System.out.printf("%s (SJF) is done\n", name);

    }

    public void bubbleSort( ArrayList<Integer> processes, ArrayList<Integer> burstTime) {

        int n = burstTime.size();
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (burstTime.get(j-1) > burstTime.get(j)) {
                    // swap both items in processes and burstTime arrays according to the burstTime
                    temp = burstTime.get(j-1);
                    burstTime.set(j-1, burstTime.get(j));
                    burstTime.set(j, temp);

                    temp = processes.get(j-1);
                    processes.set(j-1, processes.get(j));
                    processes.set(j, temp);

                }
            }
        }

    }
}



