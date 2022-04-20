.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	arrayUser word 0h, 1h, 2h, 6h
	arrayUser2 word 5h, 5h, 3h, 2h
	arrayAdded word 0h, 0h, 0h, 0h

.code
main proc
	mov EDX,OFFSET arrayUser 			; EDX points to array1
	mov ESI,OFFSET arrayUser2 			; ESI points to array2
	mov EDI,OFFSET arrayAdded
	mov ECX,LENGTHOF arrayUser				; ECX = array byte count
	call sumSameSize

	invoke ExitProcess,ECX
main endp

sumSameSize proc
	L1:
		mov al, [edx]	; pobierz bajt z pierwszej
		add al, [esi]	; dodaj bajt z drugiej
		mov [edi], al	; zapisz bajt w docelowej
		inc edx			; zwiêksz o 1 indeksy do tablic
		inc esi
		inc edi
		loop L1			; dzia³aj, dopóki ECX ró¿ne od 0.
		ret
sumSameSize endp

end main