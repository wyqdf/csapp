/*
Author :YANG KEHUA
*/
#include <stdio.h>
int minus(int x,int y)
{
	int z;
	z=x-y;
	return z;
} 
void main()
{

	int a;	//an integer
	int b;
	int c;
	a=8;
	b=10;
	c=minus(b,a);
	printf("%d\n",c);
	// no return
} 