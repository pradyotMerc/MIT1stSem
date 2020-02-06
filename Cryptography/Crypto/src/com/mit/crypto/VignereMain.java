package com.mit.crypto;

import java.util.Arrays;
import java.util.Scanner;
// see if this works
public class VignereMain {
public static String encrypt(int length, String key, String plainText)
{
	int[] c = new int[length];
	int[] d = new int[length];
	int[] e = new int[length];
	int i;

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

public static void decrypt(int ptLength, String key, String encrypted)
{
	int[] c = new int[ptLength];
	int[] d = new int[ptLength];
	int[] e = new int[ptLength];
	int i;
	
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
//	return decrypted.toString();
	
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
					i++; //jhsdhdhd
				}
		}
		System.out.println(newKey);

		String encrypted=encrypt(ptLength, newKey.toString(), plainText);
		decrypt(ptLength, newKey.toString(), encrypted);	
		sc.close();
	}

}

/*
Enter the plan text:
pradyot
Enter the Key:
key
7
keykeyk
[15, 17, 0, 3, 24, 14, 19]
[10, 4, 24, 10, 4, 24, 10]
[25, 21, 24, 13, 2, 12, 3]
Encrypted Text:ZVYNCMD
[25, 21, 24, 13, 2, 12, 3]
[10, 4, 24, 10, 4, 24, 10]
[15, 17, 0, 3, 24, 14, 19]
Decrypted Text:PRADYOT

*/
