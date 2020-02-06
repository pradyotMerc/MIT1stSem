package com.mit.crypto;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String inputMessage, encryptedData, decryptedMessage;
		
		System.out.println("Enter message to Encrypt");
		inputMessage=sc.nextLine();
//Convert String to byte
		byte[] ibyte = inputMessage.getBytes();
//Encrypt The Input message
		System.out.println(Arrays.toString(ibyte));
		
		String []bytes = new String[inputMessage.length()];

		for (int i = 0; i < inputMessage.length(); i++) {
			bytes[i]= Integer.toBinaryString(inputMessage.charAt(i)-65);
		}
		System.out.println(Arrays.toString(bytes));
		
		
		
	}
}
