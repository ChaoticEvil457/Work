#include "defs.h"

/******************************
run_cal.c
Name: Justin Huang
Date: 9/14/22

run_cal.c prints out a calendar for a given year using calendar_fun.c
****************************** */

int main(void)
{
    int input = 0;
    int skipped = 3; // defines user input, days in year, and days skipped at the start of the month
                     // note that skipped variable corresponds to the start date,
                     // with 3 equalling Wednsday (starting date of 2020)

    printf("Please enter a year for a calendar of that year:\n");
    scanf("%d", &input); // gets input

    skipped += input - 2020;           // first of January starts one day later for each year and earlier for prior years
    skipped += (input - 2020) / 4 + 1; // adds leap years
    if (input > 2020 && input % 4 != 0)
    {
        skipped++;
    }

    for (int i = 0; i < input / 100; i++) // adjusts for gregorian calendar
    {
        if (i % 4 != 0)
        {
            skipped--;
        }
    }
    skipped %= 7;
    if (skipped < 0)
    {
        skipped += 7;
    }

    printf("   ***   Calendar for %d   ***\n", input);
    printCalendar(input, skipped);
}