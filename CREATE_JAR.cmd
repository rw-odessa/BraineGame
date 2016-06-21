@ECHO OFF
setlocal enabledelayedexpansion

REM Создание JAR файла.
REM V 1.00 - Первая эксплуатационная версия.

REM==================================================
REM Установка переменных
SET RUNDIR=%~dp0
SET FILES_PATH=%RUNDIR%
CD "%RUNDIR%"|| ECHO %date% %time% - ERROR CD %RUNDIR%

REM==================================================
REM Поиск файлов выполнения
for /f %%a IN ('dir /o:-n "%FILES_PATH%*.class" /b') do (
SET "NAME=!NAME! %%a"
ECHO Найден файл - %%a
SET /A FILECOUNT=FILECOUNT+1
)

REM==================================================
REM Если новых файлов нет то выход
if %FILECOUNT% == 0 (
ECHO %date% %time% - новых файлов не найдено
EXIT /B 1
)

REM==================================================
REM Удалим старый JAR
DEL /Q %FILES_PATH%Progect.jar|| ECHO %date% %time% - ERROR DELETE %FILES_PATH%Progect.jar

REM==================================================
REM Создание JAR файла
ECHO .
ECHO %date% %time% - CREATE %FILES_PATH%Progect.jar
"C:\Program Files\Java\jdk1.7.0_21\bin\jar.exe" cfv Progect.jar %NAME% || (
ECHO %date% %time% - ERORR CREATE %FILES_PATH%Progect.jar
EXIT /B 1
)
ECHO %date% %time% - CREATE %FILES_PATH%Progect.jar - OK
PAUSE
)

:END
EXIT /B 0