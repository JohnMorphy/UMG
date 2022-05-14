INCLUDE Irvine32.inc
INCLUDE Macros.inc

.data
division dword 0
compare dword 0
truth dword 0

.code
main PROC

	FLDPI				; �adujemy PI na stos - 
	FLDPI				; st(0) = PI i st(1) = PI
	FDIVP st(1),st(0)	; st(1) = PI/PI, po czym zdejmujemy, czyli ostatecznie st(0)=PI/PI
	FSTP division		; teraz division = PI/PI

	FLD1				; �adujemy 1
	FSTP compare		; zdejmujemy st(0) ze stosu i wstawiamy do compare

	mov eax, compare	; w instrukcji cmp co najmniej jedna warto�� musi by� z rejestru
						; dlatego jeste�my zmuszeni do tej operacji

	cmp eax,division	; sprawdzamy defacto, czy wynik dzielenia jest r�wny 1
						; je�li tak, to zwracamy jeden

	jne finish			; je�li liczby s� r�ne, to wynik dzielenia nie jest r�wny jeden
						; w takim wypadku pomijamy przypisanie warto�ci i na ko�cu wy�wietlamy 0
	
	mov truth,1

	finish:

	mDump compare, Y
	mDump division, Y

	invoke ExitProcess,truth
main ENDP
END main

