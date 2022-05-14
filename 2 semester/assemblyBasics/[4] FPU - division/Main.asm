INCLUDE Irvine32.inc
INCLUDE Macros.inc

.data
division dword 0
compare dword 0
truth dword 0

.code
main PROC

	FLDPI				; ³adujemy PI na stos - 
	FLDPI				; st(0) = PI i st(1) = PI
	FDIVP st(1),st(0)	; st(1) = PI/PI, po czym zdejmujemy, czyli ostatecznie st(0)=PI/PI
	FSTP division		; teraz division = PI/PI

	FLD1				; ³adujemy 1
	FSTP compare		; zdejmujemy st(0) ze stosu i wstawiamy do compare

	mov eax, compare	; w instrukcji cmp co najmniej jedna wartoœæ musi byæ z rejestru
						; dlatego jesteœmy zmuszeni do tej operacji

	cmp eax,division	; sprawdzamy defacto, czy wynik dzielenia jest równy 1
						; jeœli tak, to zwracamy jeden

	jne finish			; jeœli liczby s¹ ró¿ne, to wynik dzielenia nie jest równy jeden
						; w takim wypadku pomijamy przypisanie wartoœci i na koñcu wyœwietlamy 0
	
	mov truth,1

	finish:

	mDump compare, Y
	mDump division, Y

	invoke ExitProcess,truth
main ENDP
END main

