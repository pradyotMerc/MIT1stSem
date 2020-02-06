#include<stdio.h>
#include<string.h>
#include<ctype.h>               
void main()
{
    char plain[10],cipher[10];
    int key,i, length;
    int result;

    printf("Plain Text-");
    scanf("%s",plain);

    printf("Key-");
    scanf("%d", &key);

    printf("\nPlain text: %s", plain);

    printf("\nEncrypted text:");

    length=strlen(plain);

    for(i=0;i<length;i++)
    {
        cipher[i]=plain[i]+key;
        if(isupper(plain[i])&&(cipher[i]>'Z'))
            cipher[i]=cipher[i]-26;
        if(islower(plain[i])&&(cipher[i]>'z'))
            cipher[i]=cipher[i]-26;
        printf("%c", cipher[i]);
    }

    printf("\nDecrypted text:");

    for(i=0;i<length;i++)
    {
        plain[i]=cipher[i]-key;
        if(isupper(cipher[i])&&(plain[i]<'A'))
            plain[i]=plain[i]+26;
        if(islower(cipher[i])&&(plain[i]<'a'))
            plain[i]=plain[i]+26;
        printf("%c", plain[i]);
    }

}