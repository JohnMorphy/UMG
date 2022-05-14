.586
.mmx
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	arrayUser byte 0h, 1h, 2h, 6h, 30 DUP(1h)
	arrayUser2 byte 5h, 5h, 3h, 2h, 30 DUP(2h)
	arrayAdded byte 40 DUP(0h)

.code
main proc
	mov edx,OFFSET arrayUser 			; EDX pointing to arrays
	mov esi,OFFSET arrayUser2 			
	mov edi,OFFSET arrayAdded
	mov ecx,SIZE arrayUser				; ECX = array byte count
	
	mov ebx,ecx
	and ebx,7							; modulo division
	shr ecx,3							; shift right 3 bits (devide by 8)
	
	call sumSameSizeOptimal
	test ebx, ebx						; czy EBX = 0?
	jz finish							; je�li tak, to ju� sko�czyli�my

	mov ecx, ebx						; ECX = resztka, co najwy�ej 7 bajt�w.
										; te kopiujemy tradycyjnie
	call sumSameSize

	invoke ExitProcess,ecx
main endp

sumSameSizeOptimal proc
	L2:
	movq mm0, [edx]		; pobierz 8 bajt�w z pierwszej tablicy
	paddb mm0, [esi]	; dodaj 8 spakowanych bajt�w z drugiej
	movq [edi], mm0		; zapisz 8 bajt�w w tablicy docelowej
	add edx, 8			; zwi�ksz indeksy do tablic o 8
	add esi, 8
	add edi, 8
	loop L2				; dzia�aj, dop�ki ECX r�ne od 0.
sumSameSizeOptimal endp

sumSameSize proc
	L1:
		mov al, [edx]	; pobierz bajt z pierwszej
		add al, [esi]	; dodaj bajt z drugiej
		mov [edi], al	; zapisz bajt w docelowej
		inc edx			; zwi�ksz o 1 indeksy do tablic
		inc esi
		inc edi
		loop L1			; dzia�aj, dop�ki ECX r�ne od 0.
		ret
sumSameSize endp

finish proc
	emms				;clear mmx - set mmx as available
	ret
finish endp

end main