package com.mit.finalpush;

import java.util.Arrays;
import java.util.Scanner;

public class FEC {

	public static void displayData(int a[]) {
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(Integer.toBinaryString(a[i])+"  ");
//		}

		System.out.println(Arrays.toString(a));
	}

	public void transmit(int a[]) throws InterruptedException {
		System.out.println();
		for (int i = 0; i < 6; i++) {

			System.out.print(".");
	
		}
		System.out.println("\n----Transmition complete---");


			System.out.println("Data recieved is:\n");
			displayData(a);

			int lostPacket = 0;
			int pos = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] == -1) {
					System.out.println(
							"Data loss has been detected, Please wait while we try to bring back the lost data");
					
					pos = i;
				}
			}

			for (int i = 0; i < a.length; i++) {
				if (i != pos)
					lostPacket = lostPacket ^ a[i];
			}
			a[pos]=lostPacket;
			System.out.println("Lost packet has been retrieved :");
			displayData(a);
		}
	

	public static void main(String[] args) throws InterruptedException {
		// int []originalData=new int[3];
		FEC ob = new FEC();
		int originalData[] = { 10, 9, 14 };
		int redundant = 0;
		Scanner sc = new Scanner(System.in);

//		*****Remove this if you dont want hard coded value********	

//		System.out.println("Enter three numbers you want to transmit:");
//		for (int i = 0; i < a.length; i++) {
//			originalData[i]= sc.nextInt();
//		}

		System.out.println("Given Data Chunks:");
		System.out.println("|-----------------------------|");
		System.out.println("|Number			Bits  |");
		System.out.println("|-----------------------------|");
		for (int i = 0; i < originalData.length; i++) {

			System.out
					.println("| " + originalData[i] + "			" + Integer.toBinaryString(originalData[i]) + "  |");
			// a[i]= sc.nextInt();

			// Calculating Redundant Value
			redundant = redundant ^ originalData[i];
		}

		System.out.println(
				"Redundant data chunk: \n|" + redundant + "			" + Integer.toBinaryString(redundant) + "  |");
		System.out.println("|-----------------------------|");

		// Calculate Transmitting data
		int transmitingData[] = new int[originalData.length + 1];
		for (int i = 0; i < originalData.length; i++) {
			transmitingData[i] = originalData[i];
		}
		transmitingData[originalData.length] = redundant;


		System.out.println("Now Transmitting data (with loss)");
		transmitingData[2] = -1;
		ob.displayData(transmitingData);
		ob.transmit(transmitingData);

		sc.close();
	}
}
