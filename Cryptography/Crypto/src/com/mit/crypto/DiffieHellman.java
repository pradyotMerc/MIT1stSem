package com.mit.crypto;

import java.util.Scanner;

public class DiffieHellman {
//	long calculateKey(int a,int x,int n) {
//		return power(a,x,n);
//	}
	
	static long power(int a, int b, int mod) {
		long t;
		if(b==1)
			return a;
		t=power(a,b/2,mod);
		if(b%2==0)
			return (t*t)%mod;
		else
			return (((t*t)%mod)*a)%mod;
		
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		//n=q,  g=alpha
		System.out.println("Enter the value of q and alpha");
		int q=scan.nextInt();
		int alpha=scan.nextInt();
		
		// get Xa  , a=xa
		System.out.println("Enter the value of Xa");
		int xa=scan.nextInt();
		
		// Calculate a=Ya
		int ya=(int) power(alpha,xa,q);
		
		//get Yb
		System.out.println("Enter the value of Xb");
		int xb=scan.nextInt();
		int yb=(int) power(alpha,xb,q);
		
		
		System.out.println("Key for the first  person is, Ka="+ power(yb,xa,q) );
		System.out.println("Key for the second person is, Kb="+power(ya,xb,q));
		scan.close();

	}

}
/*
Enter the value of q and alpha
7
9
Enter the value of Xa
6
Enter the value of Xb
15
Key for the first  person is, Ka=1
Key for the second person is, Kb=1


*/