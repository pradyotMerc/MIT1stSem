#include<stdio.h>

void main()
{
	int a[10][10],i,k,n,j,m;
	printf("Enter the number of packets\n");
	scanf("%d",&n);
	printf("Enter the number of bits in each packet\n");
	scanf("%d",&m);
	printf("\nEnter the data of packets\n");
	for(i=0;i<n;i++)
	{
		printf("\n");
		//printf("\nEnter the data of packed %d:",i+1);
		for(j=0;j<m;j++)
			scanf("%d",&a[i][j]);
	}

	printf("\nOriginal stream of data\n");
	for(i=0;i<n;i++)
	{
		printf("\n");
		//printf("\nOriginal stream of data at packet %d:    ",i+1);
		for(j=0;j<m;j++)
			printf("%d\t",a[i][j]);
	}

	printf("\n");
	printf("\nInterleaved stream of data\n ");
	for(j=0;j<m;j++)
	{
		//printf("\nInterleaved stream of data at packet %d: ",j+1);
		printf("\n");
		for(i=0;i<m;i++)
			printf("%d\t",a[i][j]);
	}

	printf("\nInterleaved packet number 3 is lost in transmission\n");

	for(i=0;i<m;i++)
		a[i][2]=999;
	printf("\nRecived stream of data\n");
	for(j=0;j<m;j++)
	{
		printf("\n");
		//printf("\nRecived stream of data at packet %d: ",j+1);
		for(i=0;i<m;i++)
			printf("%d\t",a[i][j]);
	}
printf("\nReconstructed stream of data\n");
	for(i=0;i<n;i++)
	{
		printf("\n");
		//printf("\nReconstructed stream of data at packet %d:    ",i+1);
		for(j=0;j<m;j++)
			printf("%d\t",a[i][j]);
	}



}
