@ECHO OFF
setlocal enabledelayedexpansion

REM �������� JAR 䠩��.
REM V 1.00 - ��ࢠ� �ᯫ��樮���� �����.

REM==================================================
REM ��⠭���� ��६�����
SET RUNDIR=%~dp0
SET FILES_PATH=%RUNDIR%
CD "%RUNDIR%"|| ECHO %date% %time% - ERROR CD %RUNDIR%

REM==================================================
REM ���� 䠩��� �믮������
for /f %%a IN ('dir /o:-n "%FILES_PATH%*.class" /b') do (
SET "NAME=!NAME! %%a"
ECHO ������ 䠩� - %%a
SET /A FILECOUNT=FILECOUNT+1
)

REM==================================================
REM �᫨ ����� 䠩��� ��� � ��室
if %FILECOUNT% == 0 (
ECHO %date% %time% - ����� 䠩��� �� �������
EXIT /B 1
)

REM==================================================
REM ������ ���� JAR
DEL /Q %FILES_PATH%Progect.jar|| ECHO %date% %time% - ERROR DELETE %FILES_PATH%Progect.jar

REM==================================================
REM �������� JAR 䠩��
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