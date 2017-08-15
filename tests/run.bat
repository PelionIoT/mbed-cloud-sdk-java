@ECHO OFF
SET DEBUG=superagent
SET DEBUG_COLORS=true

REM SET CONSOLE_COLOURING=true


IF EXIST artifacts.properties (
	FOR /F "eol=# delims== tokens=1,*" %%a IN (artifacts.properties) DO (
		IF NOT "%%a"=="" IF NOT "%%b"=="" SET %%a=%%b
	)
)

IF ["%TEST_FULL_JAR%"] == [""] (
	ECHO "Environment variable not set: TEST_FULL_JAR"
	EXIT 1
)

SET REFORMATTED_TEST_FULL_JAR=%TEST_FULL_JAR:\\=\%
SET REFORMATTED_TEST_FULL_JAR=%REFORMATTED_TEST_FULL_JAR:\:=:%
START "java_server" /B "java" "-jar" "%REFORMATTED_TEST_FULL_JAR%"
SLEEP 1

python -u "%~dp0testrunner\bin\trunner" -s http://localhost:5000

REM the following is a bit radical but I could not find any way to be more selective
TASKKILL /F /T /IM java.exe
