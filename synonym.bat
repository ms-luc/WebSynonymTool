@echo off
::setlocal enabledelayedexpansion
::%~1

goto :main


:relevance

	echo.
	echo ===============
	if %~1==3 echo RELEVANT
	if %~1==2 echo LESS RELEVANT
	if %~1==1 echo irrelevant?
	echo ===============
	echo.

goto :eof

:find

	call :relevance %~1

	break>%TEMP%\temp.txt

	set find=relevant-%~1

	for /f "delims=/ tokens=4" %%g in ( 'findstr %find% %TEMP%\file.html' ) do (
	
		echo %%g >> %TEMP%\temp.txt
	
	)

	for /f tokens^=1^ delims^=^" %%i in ( %TEMP%\temp.txt ) do (

		echo %%i
	
	)

goto :eof


:main

	java -cp c:/Users/Luciant ReadWebPage %1 > %TEMP%\file.html

	:: 1 for irrelevant
	for %%g in ( 2 3 ) do (
	
		call :find %%g
	
	)

	del %TEMP%\temp.txt
	del %TEMP%\file.html
	
goto :eof