#include <stdio.h>
#include <stdlib.h>
#include<string.h>

void main()
{
    unsigned int a[3][3]={{6,24,1},{13,16,10},{20,17,15}};
    unsigned int b[3][3]={{8,5,10},{21,8,21},{21,12,8}};
    int i,j,t=0;
    unsigned int c[20],d[20];
    char msg[20];
    printf("Enter the plain text: ");
    scanf("%s",msg);
    //gets(msg);
    for(i=0;i<strlen(msg);i++)
    {
        c[i]=msg[i]-65;
        printf("%d ",c[i]);
    }
    for(i=0;i<3;i++)
    {
        t=0;
        for(j=0;j<3;j++)
        {
            t=t+(a[i][j]*c[j]);
        }
        d[i]=t%26;
    }
    printf("\n\nEncrypted cipher text is: ");
    for(i=0;i<3;i++)
        printf("%c",d[i]+65);
    for(i=0;i<3;i++)
    {
        t=0;
        for(j=0;j<3;j++)
        {
            t=t+(b[i][j]*d[j]);
        }
        c[i]=t%26;
    }
    printf("\n\nDecrypted text is: ");
    for(i=0;i<3;i++)
        printf("%c",c[i]+65);
    printf("\n\n");
    return 0;

}
