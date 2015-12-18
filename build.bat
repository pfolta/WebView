@echo off

setlocal

:begin
cls
echo === Select Platform ===
echo 1  Build for Linux 32-bit (linux-x86)
echo 2  Build for Linux 64-bit (linux-x86_64)
echo 3  Build for Mac OS X 64-bit (mac-x86_64)
echo 4  Build for Windows 32-bit (win32)
echo 5  Build for Windows 64-bit (win64)
echo 6  Quit
echo;
set /P rmFunc="Selection [1-6]: "
for %%I in (1 2 3 4 5 6) do if #%rmFunc%==#%%I goto run%%I
goto begin

:run1
set profile=linux-x86
goto :runMaven

:run2
set profile=linux-x86_64
goto :runMaven

:run3
set profile=mac-x86_64
goto :runMaven

:run4
set profile=win32
goto :runMaven

:run5
set profile=win64
goto :runMaven

:run6
endlocal
goto :EOF

:runMaven
echo;
echo === Building WebView for %profile%... ===
mvn -P%profile% clean validate compile test package verify
goto :run6