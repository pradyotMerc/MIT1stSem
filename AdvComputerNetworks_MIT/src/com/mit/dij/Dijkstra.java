package com.mit.dij;

import java.util.Scanner; //Scanner Function to take in the Input Values 

public class Dijkstra {
	static Scanner scan; // scan is a Scanner Object

	public static void main(String[] args) {
		int[] preD = new int[5];
		int min = 999, nextNode = 0; // min holds the minimum value, nextNode holds the value for the next node.
		scan = new Scanner(System.in);
		int n;
		System.out.println("Enter the no. of nodes");
		n = scan.nextInt();
		int[] distance = new int[n]; // the distance cost
		int[][] cost = new int[n][n]; // the actual cost
		int[] visited = new int[n]; // the visited array

		System.out.println("Enter the cost cost");
		System.out.println(n);
		for (int i = 0; i < n; i++) {
			visited[i] = 0; // initialize visited array to zeros
			preD[i] = 0;

			for (int j = 0; j < n; j++) {
				cost[i][j] = scan.nextInt(); // fill the cost
				if (cost[i][j] == 0)
					cost[i][j] = 999; // make the zeros as 999
			}
		}

		distance = cost[0]; // initialize the distance array
		visited[0] = 1; // set the source node as visited
		distance[0] = 0; // set the distance from source to source to zero which is the starting point

		for (int counter = 0; counter < n; counter++) {
			min = 999;
			for (int i = 0; i < n; i++) {
				if (min > distance[i] && visited[i] != 1) {
					min = distance[i];
					nextNode = i;
				}
			}

			visited[nextNode] = 1;
			for (int i = 0; i < n; i++) {
				if (visited[i] != 1) {
					if (min + cost[nextNode][i] < distance[i]) {
						distance[i] = min + cost[nextNode][i];
						preD[i] = nextNode;
					}

				}

			}

		}
		System.out.println("");
		for (int i = 0; i < n; i++)
			System.out.print("|" + distance[i]);

		System.out.println("|");

		int j;
		for (int i = 0; i < n; i++) {
			if (i != 0) {

				System.out.print("Path = " + i);
				j = i;
				do {
					j = preD[j];
					System.out.print(" <- " + j);
				} while (j != 0);
			}
			System.out.println();
		}
		scan.close();
	}
}

/*

Enter the no. of nodes
5
Enter the cost cost
5
0 10 0 30 100
10 0 50 0 0
0 50 0 20 10
30 0 20 0 60
100 0 10 60 0

|0|10|50|30|60|

Path = 1 <- 0
Path = 2 <- 3 <- 0
Path = 3 <- 0
Path = 4 <- 2 <- 3 <- 0


*/