.386
.model flat,stdcall
.stack 4096
ExitProcess PROTO, dwExitCode:dword

.data
array dword 1h,2h,3h,4h,10h
theSum dword ?

.code
main proc
	mov   esi,OFFSET array 			; ESI points to array
	mov   ecx,LENGTHOF array		; ECX = array count
	call  ArraySum					; calculate the sum
	mov   theSum,eax				; returned in EAX
	call  ArraySum
	add   theSum,eax
	
	invoke ExitProcess,theSum
main endp
		
ArraySum proc
	push  esi 				; save ESI, ECX
	push  ecx
	mov   eax,0				; set the sum to zero

L1:
	add   eax,[esi]			; add each integer to sum
	add   esi,TYPE DWORD	; point to next integer
	loop  L1				; repeat for array size
	pop   ecx				; restore ECX, ESI
	pop   esi
	ret 					; sum is in EAX
ArraySum endp

end main