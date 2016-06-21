@ECHO OFF
setlocal

REM Компиляция всех найденных исходников JAVA/
REM V 1.1 - Используется конвеер комманд.
REM V 1.00 - Первая эксплуатационная версия.

REM==================================================
REM Установка переменных
SET RUNDIR=%~dp0
SET FILES_PATH=%RUNDIR%

REM==================================================
REM Поиск файлов выполнения
for /f %%a IN ('dir /o:n "%FILES_PATH%*.java" /b') do (

REM==================================================
REM Запустим SQL скрипты
ECHO .
ECHO %date% %time% - COMPILE %FILES_PATH%%%a
"C:\Program Files\Java\jdk1.7.0_21\bin\javac.exe" %%a -cp %FILES_PATH% && ECHO %date% %time% - OK
)
)

:END
PAUSE