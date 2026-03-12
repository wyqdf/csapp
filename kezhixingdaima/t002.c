/*
Author :YANG KEHUA
*/
#include <stdio.h>
int sum(int x,int y)
{
	int z;
	z=x+y;
	return z;
} 
void main()
{

	int a;	//an integer
	int b;
	int c;
	a=2;
	b=3;
	c=sum(a,b);
	printf("%d\n",c);
	// no return
} 
