; Multiply an Array                (Mult.asm)

; This program multiplies each element of an array
; of 32-bit integers by a constant value.

INCLUDE Irvine32.inc
INCLUDE Macros.inc

.data
array DWORD 1,2,3,4,5,6,7,8,9,10	; test data
multiplier DWORD 10				; test data
bufor DWORD 0

.code
main PROC
	cld 						; direction = up
	mov	esi,OFFSET array  		; source index
	mov	edi,esi					; destination index
	push esi
	mov	ecx,LENGTHOF array		; loop counter
	push ecx

L1:	lodsd                   	; copy [ESI] into EAX
	mul	multiplier				; multiply by a value
	stosd                   	; store EAX at [EDI]
	loop L1

	pop ecx
	pop esi

L2:	lodsd                   	; added a second loop	
	mov bufor,eax
	mDump bufor,Y				; dumping values to check if
	loop L2						; multiplication happened

	invoke ExitProcess,0
main ENDP
END main






COMMENT @
.386					;Reverse polish notation - basic operations
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

INCLUDE Irvine32.inc
INCLUDE Macros.inc

.data
	postfixArray word 45, 10, "-", 12, "*"	;(45 - 10) * 12
	bufor word 0
.code
main proc

	mov  esi,OFFSET postfixArray		; ESI = adres tablicy
	mov  ecx,LENGTHOF postfixArray		; iterator pêtli l1

L1:
	mov ax, [esi]
    mov bufor, ax
	call IsDigit
	add  esi,TYPE postfixArray   			; przechodzimy do kolejnego elementu
	loop L1		
	
	invoke ExitProcess,0
main endp
end main

pushNumber PROC
	push ax
	ret
pushNumber ENDP
@