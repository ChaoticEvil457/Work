#include <stdio.h>
#include <stdlib.h>

float get_average(float A[], int size);

int main(int argc, char *argv[])
{
    FILE *f = fopen("data.txt", "r");
    int numVals = atoi(argv[1]); // store number of data values
    float data[numVals];         // create array to store values
    for (int i = 0; i < numVals; i++)
    {
        fscanf(f, "%f", &data[i]);
    }
    printf("Your values are: ");
    for (int i = 0; i < numVals; i++)
    {
        printf("%7.2f ", data[i]);
    }
    printf("\n");

    float thisAv = get_average(data, numVals);
    printf("Your average is %6.2f\n", thisAv);
    fclose(f);
}

float get_average(float A[], int size)
{
    float total = 0;
    for (int i = 0; i < size; i++)
    {
        total = total + A[i];
    }
    return total / (float)size;
}