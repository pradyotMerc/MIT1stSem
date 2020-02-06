/*
LAB -2 

WAP in which a BGP router receives tables from its peer and updates
its own routing table. Display all the routing tables. Display the 
path information for a given intra domain packet/inter domain packet. 
Assume a completely connected metwork.
*/


#include <stdio.h>

void printMatrix(int a[4][4],int n)
{
	int i,j;
	for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				printf("%d\t",a[i][j]);
			}
			printf("\n");
		}
}
void main()
{
	int n=4;
	int i,j,k;
	int b[4][4];

	int a[4][4]={
		0, 9, 6, 5,
		2, 0, 1, 3,
		6, 8, 0, 2,
		4, 1, 8, 0};

		/*
		printf("\n Enter the number of nodes:");
		scanf("%d",&n);

		printf("\n Enter the distance matrix  \n");
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				scanf("%d",&a[i][j]);

/*
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			printf("\n Enter the distance between the host %d - %d:",i+1,j+1);
			scanf("%d",&a[i][j]);
		}
	}


*/
		printf("\n Entered distance matrix:  \n");
		printMatrix(a,n);
		
		printf("\n");
		for(k=0;k<n;k++)
		{
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					if(a[i][j]>a[i][k]+a[k][j])
					{
						a[i][j]=a[i][k]+a[k][j];
					}
				//	printf("%d\t",a[i][j]);
				}
				//printf("\n");



			}
			// printf("i=%d , j=%d , k=%d\n\n",i,j,k);
			// printf("\n");
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				b[i][j]=a[i][j];
				if(i==j)
				{
					b[i][j]=0;
				}
			}
		}
		printf("\n The output matrix:\n");
		printMatrix(b,n);

	}
