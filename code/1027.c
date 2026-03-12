#include "stdio.h"

void main()
{
	int a=3,b=4;
	int c=sum(b,a);
	printf("The sum is %d\n",c);
}

int sum(int x,int y)
{
	int z=0;
	z=x+y;
	return z;
}


