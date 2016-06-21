@ECHO OFF
setlocal

REM ��������� ��� ��������� ��室����� JAVA/
REM V 1.1 - �ᯮ������ ������� �������.
REM V 1.00 - ��ࢠ� �ᯫ��樮���� �����.

REM==================================================
REM ��⠭���� ��६�����
SET RUNDIR=%~dp0
SET FILES_PATH=%RUNDIR%

REM==================================================
REM ���� 䠩��� �믮������
for /f %%a IN ('dir /o:n "%FILES_PATH%*.java" /b') do (

REM==================================================
REM �����⨬ SQL �ਯ��
ECHO .
ECHO %date% %time% - COMPILE %FILES_PATH%%%a
"C:\Program Files\Java\jdk1.7.0_21\bin\javac.exe" %%a -cp %FILES_PATH% && ECHO %date% %time% - OK
)
)

:END
PAUSE