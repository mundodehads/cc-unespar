main : main.o
g++ -o main main.o -L C:\MinGW\lib\gcc\mingw32\6.3.0\include -lstdc++

main.o : main.cpp
g++ -ggdb -c main.cpp

all :
${MAKE} main

clean :
-del main.o