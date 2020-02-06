package com.mit.dsr_5;

import java.util.Random;
import java.util.Scanner;

public class BackOff {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = 1;
		// create instance of Random class
		Random rand = new Random();

		System.out.println("Enter the collision number n: ");
		// n = sc.nextInt();

		System.out.println("Now, both the station randomly pick an integer from the set K i.e. {0, 1}.");
		System.out.print("A chooses K = ");
		int A_backOffTime = rand.nextInt((int) Math.pow(2, n));

		System.out.println(A_backOffTime);

		System.out.print("B chooses K = ");
		int B_backOffTime = rand.nextInt((int) Math.pow(2, n));

		System.out.println(B_backOffTime);
		 
		System.out.print("Waiting time for A = "+A_backOffTime + " * Tslot = ");
		if (A_backOffTime==0)
			System.out.println("0");
		else
			System.out.println(A_backOffTime+".Tslot");
		System.out.print("Waiting time for B = "+B_backOffTime + " * Tslot = ");
		if (B_backOffTime==0)
			System.out.println("0");
		else
			System.out.println(B_backOffTime+".Tslot");
		
		sc.close();
	}
}