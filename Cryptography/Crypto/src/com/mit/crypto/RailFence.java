package com.mit.crypto;

import java.util.Scanner;

public class RailFence {

	int key;

	public static String Encryption(String plainText, int key) throws Exception {
		int r = key, len = plainText.length();
		float l = len / key;
		int c = len / key;
		if(l%2==1)
			c= (int) (l+1);
		char mat[][] = new char[r][c];
		int k = 0;

		String cipherText = "";

		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if (k != len)
					mat[j][i] = plainText.charAt(k++);
				else
					mat[j][i] = 'X';
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				cipherText += mat[i][j];
			}
		}
		return cipherText;
	}

	public static String Decryption(String cipherText, int key) throws Exception {
		int r = key, len = cipherText.length();
		float l = len / key;
		int c = len / key;
		if(l%2==1)
			c= (int) (l+1);
		
		char mat[][] = new char[r][c];
		int k = 0;

		String plainText = "";

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				mat[i][j] = cipherText.charAt(k++);
			}
		}
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				plainText += mat[j][i];
			}
		}

		return plainText;
	}

	public static void main(String args[]) throws Exception {
		Scanner scn = new Scanner(System.in);
		int key;

		String plainText, cipherText, decryptedText;

		System.out.println("Enter plain text:");
		plainText = scn.nextLine();

		System.out.println("Enter key for Encryption:");
		key = scn.nextInt();

		cipherText = Encryption(plainText, key);
		System.out.println("Encrypted text is:\n" + cipherText.substring(0, cipherText.length()-1));

		decryptedText = Decryption(cipherText, key);

		System.out.println("Decrypted text is:\n" + decryptedText.substring(0, cipherText.length()-1));
scn.close();
	}

}

/*

Enter plain text:
railfencecipher
Enter key for Encryption:
2
Encrypted text is:
rifneihraleccpe
Decrypted text is:
railfencecipher

*/