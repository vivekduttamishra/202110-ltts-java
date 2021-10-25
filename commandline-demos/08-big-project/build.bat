
@echo off
set project_root=D:\MyWorks\Corporate\202110-ltts-java\commandline-demos\08-big-project

set source_root=%project_root%\source

set classes_folder=%project_root%\classes

set myclasspath=%source_root%;%source_root%\data;%source_root%\furnitures;

cd %source_root%
javac -cp %myclasspath% -d %classes_folder% App.java

cd %project_root%
