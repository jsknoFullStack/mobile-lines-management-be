@echo off

SET BDNAME=%~1

echo Configuration:
echo BDNAME=%BDNAME%
echo.

set ERROR=0

echo Setting environment variables
SET PGPASSWORD=test

echo Droping Tables and Schema.....
psql -U testuser -d db_mobile_lines -h localhost -f ../scripts/dropTables.sql 1> ../logs/dropTables.log 2>&1
call :checkLogBBDD ../logs/dropTables.log

echo Creating Database Structure.....
psql -U testuser -h localhost -d db_mobile_lines -f ../scripts/createTables.sql 1> ../logs/createTables.log 2>&1
call :checkLogBBDD ../logs/createTables.log

echo Inserting Minimum Data.....
psql -U testuser -h localhost -d db_mobile_lines -f ../scripts/insertConfigData.sql 1> ../logs/insertConfigData.log 2>&1
call :checkLogBBDD ../logs/insertConfigData.log


echo Finishing off the process for %BDNAME%.
exit /b %ERROR%

goto :eof

:checkLogBBDD
::Check there are no errors
FindStr /c:"no se reconoce" %1
IF %ERRORLEVEL% EQU 0 (
  echo ERROR: An error has been produced while executing scripts. Check %1 for details
  set ERROR=1
  exit /b 1
)
FindStr /c:"error" %1
IF %ERRORLEVEL% EQU 0 (
  echo ERROR: An error has been produced while executing scripts. Check %1 for details
  set ERROR=1
  exit /b 1
)


