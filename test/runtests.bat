@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
del actualADT.txt
del actualSharedData.txt

REM compile the code into the bin folder
javac -cp ..\src -Xlint:none -d ..\bin ..\src\nus\cs3219\KWIC\ADT\Ui.java
javac -cp ..\src -Xlint:none -d ..\bin ..\src\nus\cs3219\KWIC\SharedData\Main.java

echo Testing ADT implementation:
REM run the program, feed commands from input.txt file and redirect the output to a file
java -classpath ..\bin nus.cs3219.KWIC.ADT.Ui < input.txt > actualADT.txt

REM compare the output to the expected output
FC actualADT.txt expected.txt

echo Testing shared data implementation:
REM run the program, feed commands from input.txt file and redirect the output to a file
java -classpath ..\bin nus.cs3219.KWIC.SharedData.Main < input.txt > actualSharedData.txt

REM compare the output to the expected output
FC actualSharedData.txt expected.txt