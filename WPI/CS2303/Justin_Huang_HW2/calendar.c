#include <stdio.h>

void printCalendar(int year, int skipped);
int printMonth(int year, int month, int skipped);
int printMonthName(int year, int month);

int main(void)
{
    int input = 0;
    int skipped = 3; // defines user input, days in year, and days skipped at the start of the month
                     // note that skipped variable corresponds to the start date,
                     // with 3 equalling Wednsday (starting date of 2020)

    printf("Please enter a year for a calendar of that year:\n");
    scanf("%d", &input); // gets input

    skipped += input - 2020;              // first of January starts one day later for each year and earlier for prior years
    skipped += input / 4;                 // adds leap years
    for (int i = 0; i < input / 100; i++) // adjusts for gregorian calendar
    {
        if (i % 4 != 0)
        {
            skipped--;
        }
    }
    if (input % 100 != 0 && input % 4 != 0)
    {
        skipped++;
    }
    while (skipped > 6) // prevents overflow (skipped is always going to be a number from 0 to 6)
    {
        skipped -= 7;
    }
    while (skipped < 0) // prevents underflow
    {
        skipped += 7;
    }
    printf("   ***   Calendar for %d   ***\n", input);
    printCalendar(input, skipped);
}
void printCalendar(int year, int skipped)
{
    for (int month = 0; month < 12; month++) // runs once for each month
    {

        int days = printMonth(year, month, skipped);
        skipped += days - 28; // 28/7 is 4, so we do days-28 to get the days of the week after the last group of 7
        if (skipped > 6)      // goes back to Sunday if we overflow
        {
            skipped -= 7;
        }
        printf("\n"); // more spacing
    }
}
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
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) // accounts for leap years
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
}