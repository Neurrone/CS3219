@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
del actualADT.txt
del actualSharedData.txt

REM compile the code into the bin folder
javac -cp ..\src -Xlint:none -d ..\bin ..\src\Ui.java
javac -cp ..\src -Xlint:none -d ..\bin ..\src\SharedData.java

echo Testing ADT implementation:
REM run the program, feed commands from input.txt file and redirect the output to a file
java -classpath ..\bin Ui < input.txt > actualADT.txt

REM compare the output to the expected output
FC actualADT.txt expected.txt

echo Testing shared data implementation:
REM run the program, feed commands from input.txt file and redirect the output to a file
java -classpath ..\bin SharedData < input.txt > actualSharedData.txt

REM compare the output to the expected output
FC actualSharedData.txt expected.txt