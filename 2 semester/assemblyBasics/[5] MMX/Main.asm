.586
.mmx
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	intArray BYTE 1,2,3,4,5,6,7,8
	intArray2 BYTE 2,3,4,5,6,7,8,9

.code
main proc
	
	mov edx,OFFSET intArray		
	mov esi,OFFSET intArray2
	
	MOVQ mm0, [edx]
	; paddb mm0, [esi]
	
	; emms

	invoke ExitProcess,ecx
main endp

end main