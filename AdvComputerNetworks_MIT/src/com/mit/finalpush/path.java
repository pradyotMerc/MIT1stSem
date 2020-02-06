package com.mit.finalpush;

import java.util.Scanner;

public class path {

	
	
	

	 

	int main()

	{

	 int i,j, k, n;

	 Scanner sc=new Scanner(System.in);

	 System.out.print("\nEnter the no of nodes : ");

	 n=sc.nextInt();

	 int[][] d= new int[10][10];
	 int[][] via=new int[10][10];
	 int[][]g= new int[10][10];

	for(i = 0; i<n; i++)

	 {

	  System.out.println("Enter the record for route "+i+97);

	  for(j = 0; j<n;j++)

	  {

	    System.out.println("("+i+97+":"+ j+97+") :: ");

	    g[i][j]=sc.nextInt();

	    if(g[i][j] != 999)

	       d[i][j] = 1;

	  }

	 }

	System.out.println("\n adjacency matrix \n");
	for(i=0;i<n;i++)
	{
	System.out.println("\n");
	for(j=0;j<n;j++)
	System.out.print("\t "+d[i][j]);
	}

	System.out.println("\n Cost matrix \n");
	for(i=0;i<n;i++)
	{
	System.out.println("\n");
	for(j=0;j<n;j++)
	System.out.print("\t "+g[i][j]);
	}

	 

	 for(i = 0; i<n; i++)

	    for(j = 0; j<n;j++)

	         via[i][j] = i;

	 

	 for(i = 0; i<n; i++)

	 {

	  for(j = 0; j<n;j++)

	    if(d[i][j] == 1)

	       for(k = 0; k<n; k++)

	          if(g[i][j] + g[j][k] < g[i][k])

	           {

	             g[i][k] = g[i][j] + g[j][k];

	             via[i][k] = j;

	           }

	 }

	  

	 for(i = 0; i<n; i++)

	 {

	  System.out.print("cost of route "+i+97+" :\n");

	  for(j = 0; j<n;j++)

	    System.out.print(j+97+" : "+g[i][j]+" via "+via[i][j]+ 97+" \n");

	 }

	return 0;

	} 
	
	
	
}
