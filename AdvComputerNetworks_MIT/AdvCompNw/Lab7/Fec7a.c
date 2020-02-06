#include<stdio.h>

void main()
{

	int a[10][10],i,j,k,n,count=0;
	printf("Enter the value of n:  ");
	scanf("%d",&n);

	printf("Enter the binary values in 4 bits\n");
	for(i=0;i<n;i++)
		for(j=0;j<4;j++)
			scanf("%d",&a[i][j]);

	for(j=0;j<4;j++)
		{
		count = 0;
		for(i=0;i<n;i++)
		{
			if(a[i][j]==1)
			{
				count++;
			}
		}
		//printf("%d 1's at column %d\n",count,j);

		if(count%2>0)
		{
			a[n][j]=0;
		}
		else
			a[n][j]=1;
}
printf("The data to be sent with redundant data is\n");
		for(i=0;i<n+1;i++)
		{
			printf("\n");
			for(j=0;j<4;j++)
			printf("%d",a[i][j]);
		}
		printf("\n Sending data by deleting data at location 2\n");
		for(i=2;i<=n;i++)
			for(j=0;j<4;j++)
			{
				a[i][j]=a[i+1][j];
			}

		printf("Data array recieved is \n");
		for(i=0;i<n;i++)
		{
			printf("\n");
			for(j=0;j<4;j++)
			printf("%d",a[i][j]);
		}

		printf("\nMissing data set is:\n");
		for(j=0;j<4;j++)
		{
		count = 0;
		for(i=0;i<n;i++)
		{
			if(a[i][j]==1)
			{
				count++;
			}
		}
		//printf("%d 1's at column %d\n",count,j);

		if(count%2>0)
		{
			a[n][j]=0;

		}
		else
			a[n][j]=1;




}
for(i=0;i<4;i++)
			printf("%d",a[n][i]);

printf("\n");
}
