#include <stdio.h>

int bits(int n){
	int i = 0, l = 1;
	while(n >= l){
		l = l * 2;
		i++;
	}
	if(n + i < l){
		return i;
	}else{
		return i + 1;
	}
}

int power(int i){
	int l = 1;
	while(i >= l){
		if(i == l){
			return 1;
		}
		l = l * 2;
	}
	return 0;
}

int powerof2(int i){
	int l = 1;
	while(i >= 1){
		l = l * 2;
		i--;
	}
	return l;
}

void setbit(int r,int b[], int p, int i){
	int l, j, k = 0, s, a , c = 0, t;
	for(j = 0; j < r; j++){
		if(k == power(j + 1)){
			a = powerof2(i);
			printf("%d - %d ", b[j], j);
			t = i;
			l = j + 1;
			while(t >= 1){
                                               l = l / 2;
                                               t--;
			}
	if(b[j] % 2 == 1 && l % 2 == 1){

		c++;
	}
                            }
             }
             printf("for i - %d count is %d\n", i, c);
             if(p == 1){
             	if(c % 2 == 0){
             		b[a - 1] = 1;
             	}else{
             		b[a - 1] = 0;
             	}
             }else{
             	if(c % 2 == 0){
             		b[a - 1] = 0;
             	}else{
             		b[a - 1] = 1;
             	}
             }
}

int main(){
	int n, i, j =0, r, ex, p, l = 1;
	printf("enter the number of binary numbers to be sent\n");
              scanf("%d", &n);
              ex = bits(n);
              printf("bits to be added is %d\n", ex);
              r = ex + n;
              int b[r];
              printf("The initial binary is\n");
              for(i = 0; i < r; i++){
              	if(j == power(i + 1)){
              		printf("%d  ", i);
              		scanf("%d", &b[i]);
              	}
              }
              printf("enter 1 for odd parity else 2 for even parity\n");
              while(l){
              scanf("%d", &p);
              if(p == 1 || p == 2){
              	l = 0;
              }else{
              	printf("please enter 1 or 2\n");
              }
          }
          for(i = 0; i < ex; i++){
          	               setbit(r, b, p , i);
          }
          printf("After hamming the new binary is\n");
          for(i = 0; i < r; i++){
          	printf("%d ", b[i]);
          }
}
