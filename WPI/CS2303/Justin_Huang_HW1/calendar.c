#include <stdio.h>

int main(void)
{
    int input = 0;
    int days = 0;
    int skipped = 3; // defines user input, days in year, and days skipped at the start of the month
                     // note that skipped variable corresponds to the start date,
                     // with 3 equalling Wednsday (starting date of 2020)

    while (input < 2020 || input > 2030) // accounts for years going too low or too high
    {
        printf("Please enter a year from 2020 to 2030 for a calendar of that year:\n");
        scanf("%d", &input);              // gets input
        if (input < 2020 || input > 2030) // error message
        {
            printf("\nThat is not a valid date\n");
        }
    }

    skipped += input - 2020; // first of January starts one day later for each year

    for (int i = 0; i < input - 2020; i += 4) // runs once for each leap year (2020, 2024, 2028)
    {
        skipped += 1; // first of January starts an extra day later after a leap year
    }

    while (skipped > 6) // prevents overflow (skipped is always going to be a number from 0 to 6)
    {
        skipped -= 7;
    }

    printf("   ***   Calendar for %d   ***\n", input);

    for (int month = 0; month < 12; month++) // runs once for each month
    {
        switch (month) // prints out the correct month and sets days to the number of days in that month.
        {              // I REALLY want to put this in a method just to make it look better

        case 0:
            printf("\nJanuary %d\n", input);
            days = 31;
            break;
        case 1:
            printf("\nFebuary %d\n", input);
            days = 28;
            if (input == 2020 || input == 2024 || input == 2028) // accounts for leap years
            {
                days++; // notably doesn't need to increment skipped days because skipped relies on the final day count
            }
            break;
        case 2:
            printf("\nMarch %d\n", input);
            days = 31;
            break;
        case 3:
            printf("\nApril %d\n", input);
            days = 30;
            break;
        case 4:
            printf("\nMay %d\n", input);
            days = 31;
            break;
        case 5:
            printf("\nJune %d\n", input);
            days = 30;
            break;
        case 6:
            printf("\nJuly %d\n", input);
            days = 31;
            break;
        case 7:
            printf("\nAugust %d\n", input);
            days = 31;
            break;
        case 8:
            printf("\nSeptember %d\n", input);
            days = 30;
            break;
        case 9:
            printf("\nOctober %d\n", input);
            days = 31;
            break;
        case 10:
            printf("\nNovember %d\n", input);
            days = 30;
            break;
        case 11:
            printf("\nDecember %d\n", input);
            days = 31;
            break;
        }
        printf("Sun  Mon  Tue  Wed  Thu  Fri  Sat \n"); // prints out day names
        for (int i = 0; i < skipped; i++)                        // makes spaces depending on start date
        {
            printf("     ");
        }

        for (int i = 1; i < days + 1; i++) // runs for each day in the month
        {
            if ((i + skipped - 1) % 7 == 0 && i + skipped != 1) // goes to the next line if i+skipped is not at the first
            {                                                   // position and is a multiple of 7.
                printf("\n");                                  // the -1 accounts for days starting on 1 instead of 0
            }
            printf("%3d  ", i); // prints the day using 4 allocated spaces (right aligned)
        }
        skipped += days - 28; // 28/7 is 4, so we do days-28 to get the days of the week after the last group of 7
        if (skipped > 6)      // goes back to Sunday if we overflow
        {
            skipped -= 7;
        }
        printf("\n"); // more spacing
    }
}