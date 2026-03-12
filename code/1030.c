#include <stdio.h>
int sum(int r, int s, int t, int u, int v, int x, int y)
{
	int z=0;
	z=r+s+t+u+v+x+y;
	return z;
}

int main()
{
	int a=3;
	int b=4;
	int c=sum(b,a,b+a,b-a,a*b,a,2*b);
	return 0;
}