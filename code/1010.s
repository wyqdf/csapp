.section .data

	values:
		.int 10,15,20,25,30,35,40,45,50,55,60
		
.section .text    
   
.global _start   
 _start:      
    nop
    movl values,%eax
	movl $values,%edi
	# leal values,%edi 
	# leal指令，将values的地址放到寄存器中
	movl $1,%edx
	leal 5(%edx, %edx, 2), %eax
	# 假设%edx的值为x, 上面这行会将%eax的值设置为3*x+5??
	movl $100,4(%edi)
	movl $1,%edi
	movl values(,%edi,4),%ebx
	# 假设%edi的值为i，则上述指令会将M[values+4*i]的值赋值给%ebx
	# 即values数组中的第i个元素的值（注意：values的第一个元素为values[0]	
	# leal values(%edi,4),%ebx
    # 此指令完成什么功能？运行后的结果是什么？

    movl $1, %eax   
    movl $0, %ebx
    int $0x80  
