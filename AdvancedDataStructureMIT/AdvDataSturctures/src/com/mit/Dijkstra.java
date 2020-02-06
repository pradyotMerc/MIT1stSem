package com.mit;

import java.util.Scanner;

public class Dijkstra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, i, j, v, k, min, u=0;
		int cost[][] = new int[10][10];
		int dist[] = new int[10];
		int s[] = new int[10];
		System.out.println("Enter the no of vertices:");
		n = sc.nextInt();
		System.out.println("Enter the adjacency matrix:");
		System.out.println("Enter 999 if no edge between vertices:");
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				cost[i][j] = sc.nextInt();
				;
			}
		}
		System.out.println("Enter the source vertex");
		v = sc.nextInt();
		;
		for (i = 0; i < n; i++) {
			s[i] = 0;
			dist[i] = cost[v][i];
		}
		dist[v] = 0;
		s[v] = 1;
		for (k = 2; k <= n; k++) {
			min = 999;
			for (i = 1; i <= n; i++) {
				if (s[i] == 0 && dist[i] < min) {
					min = dist[i];
					u = i;
				}
			}
			s[u] = 1;
			for (i = 1; i <= n; i++) {
				if (s[i] == 0) {
					if (dist[i] > (dist[u] + cost[u][i]))
						dist[i] = dist[u] + cost[u][i];
				}
			}
		}
		System.out.println("The shortest distance from" + v + "" + i + "is:");
		for (i = 2; i <= n; i++)
			System.out.println(v + "-->" + i + "=" + dist[i]);
		sc.close();
	}
}
