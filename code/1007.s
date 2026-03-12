.section .data
    # 声明 value1 为数据对象，大小为 4 字节
    .type value1, @object
    .size value1, 4
value1:
    .int 1 
    
    # 声明 value2 为数据对象，大小为 2 字节
    .type value2, @object
    .size value2, 2
value2:
    .short 2
    
    # 声明 value3 为数据对象，大小为 1 字节
    .type value3, @object
    .size value3, 1
value3:
    .byte 3
#.ascii 文本字符串
#.asciz 以空字符结尾的文本字符串
#.byte  字节
#.double双精度浮点数
#.float 单精度浮点数
#.int
#.long	32位整数
#.octa	16字节整数
#.quad	8字节整数
#.short	16位整数
#.single 同float
.section .text    
   
.global _start   
 _start:      
    nop
    movl value1,%ecx
	movw value1,%bx
	movw value2,%bx
   	movb value3,%cl
	

    movl $1, %eax  
    movl $0, %ebx  
    int $0x80  
