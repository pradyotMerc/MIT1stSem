package com.mit.dij;

import java.util.Scanner; //Scanner Function to take in the Input Values 

public class DijkstraFloat 
{ 
    static Scanner scan; // scan is a Scanner Object 
  
    public static void main(String[] args) 
    { 
        
        double min = 999;
        int nextNode = 0; // min holds the minimum value, nextNode holds the value for the next node. 
        scan = new Scanner(System.in); 
        int n;
        System.out.println("Enter the no. of nodes");
        n=scan.nextInt();
        
        int[] preD = new int[n]; 
        double[] distance = new double[n]; // the distance matrix 
        double[][] matrix =      {	{0,1.5,0,0,2,6},
        							{1.5,0,2.5,0,3.5,0},
        							{0,2.5,0,3.5,0,0},
        							{0,0,3.5,0,4.5,0},
        							{2,3.5,0,4.5,0,5.5},
        							{6,0,5.5,0,5.5,0}};//new double[n][n]; // the actual matrix 
        int[] visited = new int[n]; // the visited array 
  
        System.out.println("Enter the cost matrix"); 
  System.out.println(distance.length);
        for (int i = 0; i < distance.length; i++) 
        { 
            visited[i] = 0; //initialize visited array to zeros 
            preD[i] = 0; 
  
            for (int j = 0; j < distance.length; j++) 
            { 
                //matrix[i][j] = scan.nextDouble(); //fill the matrix 
                if (matrix[i][j]==0) 
                    matrix[i][j] = 999; // make the zeros as 999 
                System.out.print(matrix[i][j]+"\t");
            } 
            System.out.println();
        } 
  
        distance = matrix[0]; //initialize the distance array 
        visited[0] = 1; //set the source node as visited 
        distance[0] = 0; //set the distance from source to source to zero which is the starting point 
  
        for (int counter = 0; counter < n; counter++) 
        { 
            min = 999; 
            for (int i = 0; i < n; i++) 
            { 
                if (min > distance[i] && visited[i]!=1) 
                { 
                    min = distance[i]; 
                    nextNode = i; 
                } 
            } 
  
            visited[nextNode] = 1; 
            for (int i = 0; i < n; i++) 
            { 
                if (visited[i]!=1) 
                { 
                    if (min+matrix[nextNode][i] < distance[i]) 
                    { 
                        distance[i] = min+matrix[nextNode][i]; 
                        preD[i] = nextNode; 
                    } 
  
                } 
  
            } 
  
        } 
  
        for(int i = 0; i < n; i++) 
            System.out.print("|" + distance[i]); 
  
        System.out.println("|"); 
  
        int j; 
        for (int i = 0; i < n; i++) 
        { 
            if (i!=0) 
            { 
  
                System.out.print("Path = " + i); 
                j = i; 
                do
                { 
                    j = preD[j]; 
                    System.out.print(" <- " + j); 
                } 
                while(j != 0); 
            } 
            System.out.println(); 
        } 
        scan.close();
    }
} 