all:
	make clean
	make cal 
	make run
# lab3 has dependancies run_cal.c and calendar_fun.c

cal: run_cal.c calendar_fun.c
	gcc -Wall -o cal.o run_cal.c calendar_fun.c -lm
# run has a dependency: cal.o

run: cal.o
	./cal.o

clean:
	rm -f *.o