/*
2. Write a program to implement INCREMENT operation in a k-bit binary counter that counts upward from 0. What happens to the counter as it is incremented 16 times? Find the amortized cost of this operation if sequences of n increment operations are performed.
*/
package com.mit;

import java.util.Scanner;

public class BinaryCounter {

	public static void main(String[] args) {

		int length, i, j, n, k, count;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the value k for K bit counter:");
		k = sc.nextInt();

		char str[] = new char[k];

		for (i = 0; i < k; i++)
			str[i] = '0';
		System.out.println("Enter the number of increments");
		n = sc.nextInt();

		length = str.length;
		i = length - 1;
		count = 0;
		for (j = 0; j < n; j++) {
			while (str[i] == '1') {
				count++;
				str[i] = '0';
				i--;

			}
			if (i >= 0) {
				count++;
				str[i] = '1';
				System.out.println(str);
				i = length - 1;
			}
		}
		System.out.println("Total Cost = " + count);

		sc.close();
	}
}

/*
 * Enter the value k for K bit counter: 5 Enter the number of increments 16
 * 00001 00010 00011 00100 00101 00110 00111 01000 01001 01010 01011 01100 01101
 * 01110 01111 10000 Total Cost = 31
 */
