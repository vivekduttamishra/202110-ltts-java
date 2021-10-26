
@echo off

call variables.bat

set myclasspath=%source_root%;%third_party_root%


javac -cp %myclasspath% -d %classes_root% %source_root%\App.java


