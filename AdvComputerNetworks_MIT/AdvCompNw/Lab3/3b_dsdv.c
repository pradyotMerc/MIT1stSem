/*wap that updates a given routing table of a given node 
upon receiving broken link information from one  of the neighbours.
*/
#include <stdio.h>
#include <stdlib.h>

int d[10][10], via[10][10],i,j,k;

void printMatrix(int mat[10][10], int n)
{
    for(i=0;i<n;i++)
  {
    printf("\n");
    for(j=0;j<n;j++)
      printf("\t %d",mat[i][j]);
  }
  printf("\n");
}
void setRouting(int g[10][10], int n)
{ 
  int count=0;
  //Remove this later
  int temp[25]={0,2,7,5,999,2,0,999,3,1,7,999,0,6,5,5,3,6,0,4,999,1,5,6,5};
  for(i = 0; i<n; i++)
  {
    printf("Enter the record for route %c \n", i+97);
    for(j = 0; j<n;j++)
    {
      printf("(%c : %c) :: ", i+97, j+97);
      //scanf("%d", &g[i][j]);
       //remove this too
      g[i][j]=temp[count];
      printf("%d\n",temp[count++] );
      if(g[i][j] != 999)
       d[i][j] = 1;
   }
 }

}

void dsdvRouting(int g[10][10], int n)
{
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
   }
   
   void printRoutingCost(int g[10][10], int n)
   {
    for(i = 0; i<n; i++)
    {
      printf("cost of route %c :\n",i+97);
      for(j = 0; j<n;j++)
        printf("%c : %d via %c \n", j+97, g[i][j], via[i][j]+ 97);
    }
  }
  int main()
  {
   int n, g[10][10],originalMatrix[10][10];;
   printf("\nEnter the no of nodes : ");
   scanf("%d", &n);

   setRouting(g,n);


   // copy the routing table and keep it

   for(i=0;i<n;i++)
   {
    for(j=0;j<n;j++)
      originalMatrix[i][j]=g[i][j];
  }
  

//printAdjacencyMatrix
  printf("\n adjacency matrix \n");
  printMatrix(d,n);

//Print Cost Matrix
  printf("\n Cost matrix \n");
  printMatrix(g,n);

//Contructing new routing table
  dsdvRouting(g,n);
     // Print the 
  printRoutingCost(g,n);

  char brokenFlag='y', from, to;
  printf("\n***********************************************\n");
  printf("Is there any link which has been broken? (y/n) : ");
  scanf(" %c",&brokenFlag);
  printf("*********************************************** \n\n");
  if(brokenFlag=='y' || brokenFlag=='1')
  {
    printf("Enter from and to nodes which has been broken:\n");
    printf("From:");
    scanf(" %c",&from);
    printf("To:");
    scanf(" %c",&to);

//New Cost matrix
    for(i=0;i<n;i++)
    {
      for(j=0;j<n;j++)
        g[i][j]=originalMatrix[i][j];
    }

    int x = ((int)from)-97;
    int y = ((int)to)-97;

    printf("x=%d   y=%d \n",x,y );
    g[x][y]=999;
      //if(g[i][j] != 999)
    d[x][y] = 0;
    g[y][x]=999;
      //if(g[i][j] != 999)
    d[y][x] = 0;

//printAdjacencyMatrix
    printf("\n adjacency matrix \n");
    printMatrix(d,n);

//Print Cost Matrix
    printf("\n Cost matrix \n");
    printMatrix(g,n);

//Contructing new routing table
    dsdvRouting(g,n);
     // Print the 
    printRoutingCost(g,n);

  }

} 

/*
student@lplab-Lenovo-Product:~/Documents/pradyot/Lab3$ cc 3b_dsdv.c -o 3b
student@lplab-Lenovo-Product:~/Documents/pradyot/Lab3$ ./3b

Enter the no of nodes : 5
Enter the record for route a 
(a : a) :: 0
(a : b) :: 2
(a : c) :: 7
(a : d) :: 5
(a : e) :: 999
Enter the record for route b 
(b : a) :: 2
(b : b) :: 0
(b : c) :: 999
(b : d) :: 3
(b : e) :: 1
Enter the record for route c 
(c : a) :: 7
(c : b) :: 999
(c : c) :: 0
(c : d) :: 6
(c : e) :: 5
Enter the record for route d 
(d : a) :: 5
(d : b) :: 3
(d : c) :: 6
(d : d) :: 0
(d : e) :: 4
Enter the record for route e 
(e : a) :: 999
(e : b) :: 1
(e : c) :: 5
(e : d) :: 6
(e : e) :: 5

 adjacency matrix 

   1   1   1   1   0
   1   1   0   1   1
   1   0   1   1   1
   1   1   1   1   1
   0   1   1   1   1

 Cost matrix 

   0   2   7   5   999
   2   0   999   3   1
   7   999   0   6   5
   5   3   6   0   4
   999   1   5   6   5
cost of route a :
a : 0 via a 
b : 2 via a 
c : 7 via a 
d : 5 via a 
e : 3 via b 
cost of route b :
a : 2 via b 
b : 0 via b 
c : 6 via e 
d : 3 via b 
e : 1 via b 
cost of route c :
a : 7 via c 
b : 6 via e 
c : 0 via c 
d : 6 via c 
e : 5 via c 
cost of route d :
a : 5 via d 
b : 3 via d 
c : 6 via d 
d : 0 via d 
e : 4 via d 
cost of route e :
a : 3 via b 
b : 1 via e 
c : 5 via e 
d : 4 via b 
e : 2 via b 
Is there any link which has been broken? (y/n) : y
*********************************************** 

Enter from and to nodes which has been broken:
From:a
To:b
x=0   y=1 

 adjacency matrix 

   1   0   1   1   0
   0   1   0   1   1
   1   0   1   1   1
   1   1   1   1   1
   0   1   1   1   1

 Cost matrix 

   0   999   7   5   999
   999   0   999   3   1
   7   999   0   6   5
   5   3   6   0   4
   999   1   5   6   5
cost of route a :
a : 0 via a 
b : 8 via d 
c : 7 via a 
d : 5 via a 
e : 9 via d 
cost of route b :
a : 8 via d 
b : 0 via b 
c : 6 via e 
d : 3 via b 
e : 1 via b 
cost of route c :
a : 7 via c 
b : 6 via e 
c : 0 via c 
d : 6 via c 
e : 5 via c 
cost of route d :
a : 5 via d 
b : 3 via d 
c : 6 via d 
d : 0 via d 
e : 4 via d 
cost of route e :
a : 9 via b 
b : 1 via e 
c : 5 via e 
d : 4 via b 
e : 2 via b 


*/


