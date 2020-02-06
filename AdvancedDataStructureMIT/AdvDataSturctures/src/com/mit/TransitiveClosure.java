package com.mit;

import java.util.Scanner;

public class TransitiveClosure {

	public static void main(String[] args) {
		int n,i,j,k;
		int [][]a= new int[20][20];
		int [][]t= new int[20][20];
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter n:");
		n=sc.nextInt();
		System.out.println("\nMatrix:");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
//				scanf("%d",&a[i][j]);
				a[i][j]=sc.nextInt();
				
			}
		}
		
		for(i=0;i<n;i++)
			for(j=0;j<n;j++){
				if(i==j || a[i][j]!=0)
					t[i][j]=1;
				else
					t[i][j]=0;
		}
		for(k=0;k<n;k++)
			for(i=0;i<n;i++)
				for(j=0;j<n;j++)
					t[i][j]=t[i][j] | (t[i][k] & t[k][j]);

		for(i=0;i<n;i++)
		{
			System.out.println("\n");
			for(j=0;j<n;j++)
			{
				System.out.print("\t"+t[i][j]);
				
			}
		}
	}
}

