@ECHO OFF
setlocal

REM ��������� ��� ��������� ��室����� JAVA
REM V 1.1 - �ᯮ������ ������� �������.
REM V 1.00 - ��ࢠ� �ᯫ��樮���� �����.

REM==================================================
REM ��⠭���� ��६�����
SET RUNDIR=%~dp0
SET FILES_PATH=%RUNDIR%

REM==================================================
REM ���� 䠩��� �믮������
for /f %%a IN ('dir /o:n "%FILES_PATH%*.jar" /b') do (

REM==================================================
REM �����⨬ SQL �ਯ��
ECHO .
ECHO %date% %time% - RUN  %FILES_PATH%%%a
ECHO ==================================================
ECHO "C:\Program Files\Java\jdk1.7.0_21\bin\java.exe" -jar "%RUNDIR%%%a"
"C:\Program Files\Java\jdk1.7.0_21\bin\java.exe" -jar "%RUNDIR%%%a" || (
ECHO %date% %time% - ERROR RUN %FILES_PATH%%%a
GOTO NEXT1
)
ECHO ==================================================
ECHO %date% %time% - RUN %FILES_PATH%%%a - OK
:NEXT1
PAUSE
)

:END