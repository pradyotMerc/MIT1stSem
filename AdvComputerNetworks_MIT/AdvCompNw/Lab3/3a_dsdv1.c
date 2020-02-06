#include <stdio.h>

#include <stdlib.h>

 

int d[10][10], via[10][10];

 

int main()

{

 int i,j, k, n, g[10][10];

 

 printf("\nEnter the no of nodes : ");

 scanf("%d", &n);

  

for(i = 0; i<n; i++)

 {

  printf("Enter the record for route %c \n", i+97);

  for(j = 0; j<n;j++)

  {

    printf("(%c : %c) :: ", i+97, j+97);

    scanf("%d", &g[i][j]);

    if(g[i][j] != 999)

       d[i][j] = 1;

  }

 }

printf("\n adjacency matrix \n");
for(i=0;i<n;i++)
{
printf("\n");
for(j=0;j<n;j++)
printf("\t %d",d[i][j]);
}

printf("\n Cost matrix \n");
for(i=0;i<n;i++)
{
printf("\n");
for(j=0;j<n;j++)
printf("\t %d",g[i][j]);
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

  printf("cost of route %c :\n",i+97);

  for(j = 0; j<n;j++)

    printf("%c : %d via %c \n", j+97, g[i][j], via[i][j]+ 97);

 }

return 0;

} 

/*
student@lplab-Lenovo-Product:~/Documents/pradyot/Lab3$ cc dsdv1.c -o dsdv1
student@lplab-Lenovo-Product:~/Documents/pradyot/Lab3$ ./dsdv1 

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


*/