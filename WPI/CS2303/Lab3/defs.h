#include <stdio.h>

/******************************
void printCalendar(int year, int skipped):
takes in a year and number of spaces and then calls printMonth.

After getting the number of days in the month from printMonth, it adjusts
the number of spaces at the start of the next month

****************************** */

void printCalendar(int year, int skipped);

/******************************
int printMonth(int year, int month, int skipped):

Takes in the year, month, and number of spaces before the first day
and calls printMonthName to get the number of days in the month

Afterwards it prints out the start of the calendar, spaces before the first day,
and each day in that month

returns number of days in the month
****************************** */

int printMonth(int year, int month, int skipped);

/******************************
int printMonthName(int year, int month):

Takes in the year and month and returns the number of days in that month.
****************************** */

int printMonthName(int year, int month);