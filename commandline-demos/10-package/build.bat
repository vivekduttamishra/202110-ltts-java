
@echo off

call variables.bat

set myclasspath=%source_root%


javac -cp %myclasspath% -d %classes_root% %source_root%\App.java


