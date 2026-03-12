#include "stdio.h"

void swap1(int x, int y)
{
    int temp=x;
    x=y;
    y=temp;
}
void swap2(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}
 
int main() 
{
    int a=10;
    int *p;
    p = &a;  /*将变量a的地址赋值给指针p*/
    printf("a的值：%d\n", a);
    printf("a的地址：%p\n", &a);
    printf("p存储的地址：%p\n", p);
    printf("p指向的值：%d\n", *p);

    int arr[5] = {1, 2, 3, 4, 5};
    p = arr;
    for(int i = 0; i < 5; i++) {
        printf("arr[%d] = %d\n", i, *(p + i));
    }

    int b = 20;
    swap1(a,b);
    printf("swap1:a = %d, b = %d\n", a, b);
    swap2(&a, &b);
    printf("swap2:a = %d, b = %d\n", a, b);
    return 0;
}