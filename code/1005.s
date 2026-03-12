# as -g -32 1005.s  -o 1005.o
# ld -m elf_i386 1005.o -o 1005
 .section .text    
   
 .global _start   
 _start:      
     nop
     movl $4, %eax      # eax寄存器赋值为4
     movl $1, %ebx      # ebx寄存器赋值为1
     movl $5, %ecx  
     movl $13, %edx  
     movl %eax,%ebx   # 将eax寄存器的值赋值给ebx寄存器
    
   # 准备退出，等价于return 0
     movl $1, %eax  # eax 寄存器赋值为1，这是sysexit的中断号
     movl $0, %ebx  # ebx 寄存器赋值为0，表示成功的状态码
     int $0x80         # 系统中断，根据eax寄存器的值，确定转向系统调用sysexit，即退出
