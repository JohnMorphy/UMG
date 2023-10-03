INCLUDE Irvine32.inc
INCLUDE Macros.inc

.data
number1 word ?
number2 dword ?
number3 dword ?
number4 byte ?
number5 byte ?

.code
main PROC

	mov cx, 0000000000000000b					; a)
	or cx, 0000100010010001b					; using OR we can set certain bits,
	mov number1,cx								; where we place 1 in test
	mDump number1,N

	mov esi, 11111000111111111111111111110011b	; b)
	and esi, 11111101111111111111110101111011b	; using AND we can turn certain bits to
	mov number2, esi							; zero, where we place 0 in test
	mDump number2, N
	
	mov eax, 11111111000000000000000100000000b	; c)
	xor eax, 10000000000000000000000011111111b	; using XOR we can switch certain bits,
	mov number3, eax							; where there is 1 in test
	mDump number3, N

	mov Al,18h									; d)
	shl AL,4									; shift left
	mov number4, al								
	mDump number4, N

	mov Al,18h									; e)
	rol AL,4									; shift left with rotation
	mov number5, al
	mDump number5, N

	mov edx, 0									; f)
	bsr edx, 23									; setting a certain bit and
												; getting its value to a flag

	exit
main ENDP
END main
