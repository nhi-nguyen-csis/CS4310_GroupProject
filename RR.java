package com.company.nnguyen;

import java.util.*;

class Process{
    int id;
    int burstTime;
    public Process(int id, int burstTime){
        this.id = id;
        this.burstTime = burstTime;
    }
}

public class RR extends Thread{
    String name;
    ArrayList<Integer> processes;
    ArrayList<Integer> burstTime;
    int timeQuantum;

    public RR(String name, ArrayList<Integer> processes, ArrayList<Integer> burstTime, int timeQuantum) {
        this.name = name;
        this.processes = processes;
        this.burstTime = burstTime;
        this.timeQuantum = timeQuantum;
    }

    public void run(){
        // create a queue
        Queue<Process> queue = new ArrayDeque<> ();
        for (int i = 0; i < processes.size(); i++) {
            // create an object
            queue.add(new Process(processes.get(i), burstTime.get(i)));
        }

        while(!queue.isEmpty()){
            Process currentProcess = queue.poll();
            System.out.printf("%s (RR) is working on process %d\n", name, currentProcess.id);
            currentProcess.burstTime -= timeQuantum;
            if (currentProcess.burstTime > 0) {
                queue.add(currentProcess);
            }
        }
        System.out.printf("%s (RR) is done\n", name);
    }
}
