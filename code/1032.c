#include <stdio.h>

void foo()
{
	int a;
	static int *p;
	/*32 bit*/
	//p=(int*)((int)&a+8);
	//*p+=12;
	//64bit  -m32
	p=(int*)((int)&a+20);
	*p+=18;
}
int main()
{
	foo();
	printf("Print 1\n");
	printf("Print 2\n");
	printf("Print 3\n");
	printf("Print 4\n");
	return 0;
}
