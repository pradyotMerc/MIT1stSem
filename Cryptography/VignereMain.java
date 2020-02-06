package com.mit.crypto;

import java.util.Arrays;
import java.util.Scanner;

public class VignereMain {
public static String encrypt(int length, String key, String plainText)
{
	int[] c = new int[length];
	int[] d = new int[length];
	int[] e = new int[length];
	int i,j;

	StringBuilder encrypted = new StringBuilder(length);

	for (i = 0; i < length; i++) {
		c[i]= ((int)(plainText.toUpperCase().charAt(i)))-65;
	}
	System.out.println(Arrays.toString(c));

	for (i = 0; i < length; i++) {
		d[i]= ((int)(key.toUpperCase().charAt(i)))-65;
	}
	System.out.println(Arrays.toString(d));
	
	for (i = 0; i < length; i++) {
		e[i]= Math.abs(c[i] + d[i]) % 26;
	}
	
	System.out.println(Arrays.toString(e));
	for (i = 0; i < length; i++) {
		encrypted.append((char)(e[i]+65));
		
	}
	System.out.println("Encrypted Text:"+encrypted.toString());

	return encrypted.toString();
}

public static String decrypt(int ptLength, String key, String encrypted)
{
	int[] c = new int[ptLength];
	int[] d = new int[ptLength];
	int[] e = new int[ptLength];
	int i,j;
	
	StringBuilder decrypted = new StringBuilder(ptLength);

	for (i = 0; i < ptLength; i++) {
		c[i]= ((int)(encrypted.toString().toUpperCase().charAt(i)))-65;
	}
	System.out.println(Arrays.toString(c));

	for (i = 0; i < ptLength; i++) {
		d[i]= ((int)(key.toUpperCase().charAt(i)))-65;
	}
	System.out.println(Arrays.toString(d));
	
	for (i = 0; i < ptLength; i++) {
		int diff = c[i] - d[i];
		if(diff < 0)
			diff+=26;
		
		e[i]= diff % 26;
	}
	
	System.out.println(Arrays.toString(e));
	for (i = 0; i < ptLength; i++) {
		decrypted.append((char)(e[i]+65));
		
	}
	System.out.println("Decrypted Text:"+decrypted.toString());
	return decrypted.toString();
	
}
	public static void main(String[] args) {

		String plainText, key;
		Scanner sc = new Scanner(System.in);
		int ptLength, keyLength, i, j;

		System.out.println("Enter the plan text:");
		plainText = sc.nextLine();
		//System.out.println(plainText);
		ptLength = plainText.length();

		System.out.println("Enter the Key:");
		key = sc.nextLine();
		// System.out.println(key);
		keyLength = key.length();
		System.out.println(plainText.length());
		StringBuilder newKey = new StringBuilder(ptLength);
		if (ptLength > keyLength) {

			// System.out.println("In if condi");

			for (i = 0; i < ptLength;)
				for (j = 0; j < keyLength && i < ptLength; j++) {
					newKey.append(key.charAt(j));
					i++;
				}

		}

		System.out.println(newKey);

		String encrypted=encrypt(ptLength, newKey.toString(), plainText);
				
		
		String decrypted=decrypt(ptLength, newKey.toString(), encrypted);
		
		
		
	}

}
