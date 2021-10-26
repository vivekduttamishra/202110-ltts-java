
@echo off

call variables.bat

set myclasspath=%source_root%;%third_party_root%


javac -cp %myclasspath% -d %classes_root% %source_root%\in\conceptarchitect\app\App.java


md %dist_root%

cd %classes_root%


jar cef in.conceptarchitect.app.App %dist_root%\app2.jar .

cd %project_root%

echo @java -jar app2.jar >%dist_root%\app2.bat


rd %classes_root% /q/s