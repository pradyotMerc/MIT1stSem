package com.mit.railfence;


import java.util.Scanner;

public class RailfenceTest {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter plain text");
		String pt=input.nextLine();
		System.out.println("Enter key");
		int key=input.nextInt();
		
		RailFence rf=new RailFence();
		rf.encrypt2(pt, key);
		rf.printMatrix();
		rf.decrypt2(key);
		
	}
}