package com.mit.finalpush;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class FCFS {
	/* This is first in first out with priority
	 * non preemptive */


	public static void main(String[] args) {
//		int arrivaltime[] = { 0, 2, 2, 4, 4 }; 
//		int bursttime[] = { 3, 5, 1, 7, 4 }; 
//		int priority[] = { 3, 4, 1, 7, 8 }; 
		
		int arrivaltime[] = { 0,0,0,0 }; 
		int bursttime[] = { 3,6,4,2 }; 
		int priority[] = { 2,4,1,3 }; 
		
		
		
		LinkedList<Process> procList=new LinkedList<Process>();
		
		for(int i=0;i<arrivaltime.length;i++) {			
			Process p=new Process(arrivaltime[i],bursttime[i],priority[i]);
			procList.add(p);
		}
		
		Collections.sort(procList);
		
		Iterator<Process> it=procList.iterator();
		int clock=procList.getFirst().arrivalTime;
		System.out.println("Start Time  Burst time   complete time  turn around time  waiting time ");
		while(it.hasNext()) {
			Process p=it.next();
			p.startTime=clock;
			p.completeTime=clock+p.burstTime;
			p.turnAroundTime=p.completeTime-p.arrivalTime;
			p.waitingTime=p.turnAroundTime-p.burstTime;
			clock=clock+p.burstTime;
			
			
			System.out.println(p);
		}	
		
		
	}
	
	class ProcessComparator implements Comparator<Process>{

		@Override
		public int compare(Process arg0, Process arg1) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

}