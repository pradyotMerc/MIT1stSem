
#include<stdio.h>
#include <stdlib.h>
#define INT_MAX 9999
struct Graph {
	int src;
	int dest;
	int pnode;
	int cost;
};
struct RoutingTable {

	struct Graph *graph;
};

int main() {
	struct RoutingTable *rt = (struct RoutingTable*) malloc(
			sizeof(struct RoutingTable));
	int n, d, src, dest, pnode, cost;
	printf("Enter the number of verticies\n");
	scanf("%d", &n);
	rt->graph = (struct Graph*) malloc(n*n * sizeof(struct Graph));


	printf("Enter the routing table in following order\n");

	printf("Source\tDestination\tPenultimate Node\tCost\n");
	for (int i = 0; i < n * n; i++) {
		scanf("%d", &src);
		rt->graph[i].src = src;
		scanf("%d", &dest);
		rt->graph[i].dest = dest;
		scanf("%d", &pnode);
		rt->graph[i].pnode = pnode;
		scanf("%d", &cost);
		rt->graph[i].cost = cost;
	}
	printf("Enter the destination node\n");
	scanf("%d", &d);
	printf("Source\t\tcost\n");
	for (int i = 0; i < n*n; i++) {
		if (d == rt->graph[i].dest) {
			printf("%d\t\t%d\n", rt->graph[i].src, rt->graph[i].cost);
		}/*
		 else
		 {
		 printf("%d\t\t\t\t%d",rt->graph[i].src,INT_MAX);
		 }*/
	}
	return 0;
}