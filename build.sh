#!/bin/sh

while true; do

    clear
    echo "=== Select Platform ==="
    echo "1  Build for Linux 32-bit (linux-x86)"
    echo "2  Build for Linux 64-bit (linux-x86_64)"
    echo "3  Build for Mac OS X 64-bit (mac-x86_64)"
    echo "4  Build for Windows 32-bit (win32)"
    echo "5  Build for Windows 64-bit (win64)"
    echo "6  Quit"
    echo;
    
    printf "Selection [1-6]: "
    read -r option
    
    case $option in
        1)
            profile="linux-x86"
            ;;
        2)
            profile="linux-x86_64"
            ;;
        3)
            profile="mac-x86_64"
            ;;
        4) 
            profile="win32"
            ;;
        5) 
            profile="win64"
            ;;
        6) 
            exit
            ;;
    esac
    
    if [ -n "$profile" ]; then
        echo;
        echo "=== Building WebView for $profile... ==="
        mvn -P$profile clean validate compile test package verify
        exit
    fi
    
done
