.section .data
	value1:
		.int 10
.section .text    
   
.global _start   
 _start:      
   nop
   movl value1,%eax
	movl $value1,%edi

	leal value1,%esi 	
	# lealָ 指令，将value1的地址值赋值给%esi寄存器
	movl $1,%edx
	leal 5(%edx, %edx, 2), %eax
	# 假设%edx的值为x，上面的指令会计算3*x+5，将结果赋值给%eax
	# 后面会看到有加法/乘法指令直接进行计算，为什么要采用lea指令来进行计算？
	
    movl $1, %eax  
    movl $0, %ebx 
    int $0x80  
