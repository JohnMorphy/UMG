; Program template

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	witam sword -1
	value sword 0
.code
main proc
	test word ptr witam,8000h
	pushfd
	popfd

	invoke ExitProcess,value
main endp
end main