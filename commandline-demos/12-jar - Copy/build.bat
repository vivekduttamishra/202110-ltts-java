
@echo off

call variables.bat

set myclasspath=%source_root%;%third_party_root%


javac -cp %myclasspath% -d %classes_root% %source_root%\in\conceptarchitect\app\App.java


cd %classes_root%


md %dist_root%


jar cf %dist_root%\app.jar .

cd %project_root%

echo @java -cp app.jar in.conceptarchitect.app.App >%dist_root%\app.bat