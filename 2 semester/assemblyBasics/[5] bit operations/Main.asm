INCLUDE Irvine32.inc
INCLUDE Macros.inc

.data
divide DWORD ?
modulo DWORD ?
nextNumber DWORD ?


.code
main PROC

	mov edx, 129
	shr edx, 2			; division by
	mov divide, edx

	mov edx, 129
	and edx, 3			; modulo division by 4
	mov modulo, edx

	mov edx, 129
	and edx, 11111111111111111111111111111100b	; finding closest number
	mov nextNumber, edx							; that can be divided
												; by 4
	mDump divide, Y
	mDump modulo, Y
	mDump nextNumber, Y

	invoke ExitProcess,0
main ENDP

END main
