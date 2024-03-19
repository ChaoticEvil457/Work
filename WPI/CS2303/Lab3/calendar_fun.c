#include "defs.h"

/******************************
calendar_fun.c
Name: Justin Huang
Date: 9/14/22

Contains functions used by run_cal.c to create a calendar
for a given year
****************************** */

/******************************
void printCalendar(int year, int skipped):
takes in a year and number of spaces and then calls printMonth.

After getting the number of days in the month from printMonth, it adjusts
the number of spaces at the start of the next month

****************************** */
void printCalendar(int year, int skipped)
{
    for (int month = 0; month < 12; month++) // runs once for each month
    {

        int days = printMonth(year, month, skipped);
        skipped += days - 28; // 28/7 is 4, so we do days-28 to get the days of the week after the last group of 7
        skipped %= 7;
        printf("\n"); // more spacing
    }
}

/******************************
int printMonth(int year, int month, int skipped):

Takes in the year, month, and number of spaces before the first day
and calls printMonthName to get the number of days in the month

Afterwards it prints out the start of the calendar, spaces before the first day,
and each day in that month

returns number of days in the month
****************************** */

int printMonth(int year, int month, int skipped)
{
    int days = printMonthName(year, month);
    printf("Sun  Mon  Tue  Wed  Thu  Fri  Sat \n"); // prints out day names
    for (int i = 0; i < skipped; i++)               // makes spaces depending on start date
    {
        printf("     ");
    }
    for (int i = 1; i < days + 1; i++) // runs for each day in the month
    {
        if ((i + skipped - 1) % 7 == 0 && i + skipped != 1) // goes to the next line if i+skipped is not at the first
        {                                                   // position and is a multiple of 7.
            printf("\n");                                   // the -1 accounts for days starting on 1 instead of 0
        }
        printf("%3d  ", i); // prints the day using 4 allocated spaces (right aligned)
    }
    return days;
}

/******************************
int printMonthName(int year, int month):

Takes in the year and month and returns the number of days in that month.
****************************** */

int printMonthName(int year, int month)
{
    switch (month) // prints out the correct month and sets days to the number of days in that month.
    {

    case 0:
        printf("\nJanuary %d\n", year);
        return 31;
        break;
    case 1:
        printf("\nFebuary %d\n", year);
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) // accounts for leap years
        {
            return 29;
        }
        return 28;
        break;
    case 2:
        printf("\nMarch %d\n", year);
        return 31;
        break;
    case 3:
        printf("\nApril %d\n", year);
        return 30;
        break;
    case 4:
        printf("\nMay %d\n", year);
        return 31;
        break;
    case 5:
        printf("\nJune %d\n", year);
        return 30;
        break;
    case 6:
        printf("\nJuly %d\n", year);
        return 31;
        break;
    case 7:
        printf("\nAugust %d\n", year);
        return 31;
        break;
    case 8:
        printf("\nSeptember %d\n", year);
        return 30;
        break;
    case 9:
        printf("\nOctober %d\n", year);
        return 31;
        break;
    case 10:
        printf("\nNovember %d\n", year);
        return 30;
        break;
    case 11:
        printf("\nDecember %d\n", year);
        return 31;
        break;
    }
    return 0;
}