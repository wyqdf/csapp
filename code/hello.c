/*
第一步：预编译     gcc -E hello.c -o hello.i
第二步：编译       gcc -S hello.i -o hello.s
第三步：汇编       gcc -c hello.s -o hello.o
第四步：链接       gcc hello.o -o hello
*/
#include "stdio.h"

int main()
{
	printf("hello world!\n");
	//pri("hello world!\n");
	return 0;
}
