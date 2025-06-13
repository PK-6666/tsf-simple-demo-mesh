@echo off
:loop
curl http://localhost:8080/scg/test-7-6/ServiceA/echo-rest
timeout /t 1 >nul
echo