package com.mit.crypto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RSA3 {

	static int n,e, d;
	static int val[] = new int[50];

	static char encode(char ch) {
		int i;
		int temp = ch;
		for (i = 1; i < e; i++)
			temp = temp * ch % n;
		return ((char)temp);
	}
	
	static char decode(int ch) {
		int i;
		int temp = ch;
		for (i = 1; i < d; i++)
			ch = temp * ch % n;
		return ((char)ch);
	}

	

	public static void main(String[] args) throws Throwable {
		int i, p, q, phi;
		Scanner sc = new Scanner(System.in);
		Random rand =  new Random();

		String text, cText;

		System.out.println("Enter the text to be encoded \n");
		text = sc.nextLine();

		System.out.println(text);
		
		p=17;  q=11;
		e=7;
		n = p * q;
		phi = (p - 1) * (q - 1);
		
		do {
			d = rand.nextInt(phi);// % phi;
		} while ((d * e % phi) != 1);
		
		System.out.println("\n p="+p+"\t q="+q+" n="+n +" phi="+phi+" d="+d+" e="+e+"\n");
		
		System.out.println("\n**** encoding message*** ");
		
		
		for (i = 0; i<text.length(); i++)
			val[i]= encode(text.charAt(i));
		val[i] = -999;
		System.out.println("**** encoded message *** \n");
		for (i = 0; val[i] != -999; i++)
			System.out.print(val[i]+"  ");
		
		
		
		
		System.out.println("\n **** decoding message ****");
		
		StringBuilder sb= new StringBuilder();
		for (i = 0; val[i] != -999; i++)
		{			
			sb.append(decode(val[i]));			
		}
		cText=sb.toString();
		
		System.out.println("\n **** decoded message :****\n"+ cText);
		
		sc.close();
	}

}


/*
 *OUTPUT 
 *  
Enter the text to be encoded 

X
X

 p=17	 q=11 n=187 phi=160 d=23 e=7




**** encoding message*** 
**** encoded message *** 

11

 **** decoding message ****

 **** decoded message :****
X

2nd acct made these chabges
*/
