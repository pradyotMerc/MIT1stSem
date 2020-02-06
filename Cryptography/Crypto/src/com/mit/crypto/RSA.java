package com.mit.crypto;

import java.util.Random;
import java.util.Scanner;

public class RSA {

	static int n,e, d;
	static int val[] = new int[50];

	static char decode(int ch) {
		int i;
		int temp = ch;
		for (i = 1; i < d; i++)
			ch = temp * ch % n;
		return ((char)ch);
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return (gcd(a, a % b));

	}

	static boolean prime(int a) {
		int i;
		for (i = 2; i < a; i++) {
			if ((a % i) == 0)
				return false;

		}
		return true;
	}

	static char encode(char ch) {
		int i;
		int temp = ch;
		for (i = 1; i < e; i++)
			temp = temp * ch % n;
		return ((char)temp);
	}

	public static void main(String[] args) throws Throwable {
		int i;
		int p, q, phi;
		int c[] = new int[50];

		Random rand =  new Random();

		Scanner sc = new Scanner(System.in);

		String text;
		String cText;
		// char text[50],ctext[50];
		System.out.println("Enter the text to be encoded \n");
		text = sc.nextLine();
//	gets(text);
		System.out.println("text");
		do {
			p = rand.nextInt(30) + 1;
		} while (!prime(p));
		do {
			q = rand.nextInt(30) + 1;
		} while (!prime(q));

		n = p * q;
		phi = (p - 1) * (q - 1);
		System.out.println("\n p="+p+"\t q="+q+" n="+n +"phi="+phi+" \n");
		boolean checkE=false;
		
		do {
			e = rand.nextInt() % phi;
			
		} while (gcd(e, phi)!=1);


		do {
			d = rand.nextInt() % phi;
		} while ((d * e % phi) != 1);
		System.out.println("\n**** encoding message*** \n");
		Thread.sleep(1000);
		
		for (i = 0; i<text.length(); i++)
			val[i]= encode(text.charAt(i));
		val[i] = -999;
		System.out.println("\n**** encoded message *** \n");
		for (i = 0; val[i] != -999; i++)
			System.out.println(val[i]);
		System.out.println("\n decoded message");
		Thread.sleep(1000);
		StringBuilder sb= new StringBuilder();
		for (i = 0; val[i] != -999; i++)
		{
			
			sb.append(decode(val[i]));
			
		}
		cText=sb.toString();
		
		System.out.println("\n decoded message :"+ cText);
	}

}
