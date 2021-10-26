
@echo off

call variables.bat


echo cleaning %classes_root%
rd %classes_root% /q/s

echo cleaning %dist_root%
rd %dist_root% /q/s



