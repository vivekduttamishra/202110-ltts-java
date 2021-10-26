
@echo off

call variables.bat


echo cleaning %classes_root%
rd %classes_root% /q/s

rd %dist_root% /q/s



