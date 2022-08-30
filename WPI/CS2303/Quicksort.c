#include <stdio.h>
#include <stdlib.h>

int SIZE = 10000;

void swap(int *a, int *b);
int partition(int r[], int low, int high);
void sort(int r[], int low, int high);

int main(void)
{
    int r[SIZE];

    for (int i = 0; i < SIZE; i++)
    {
        r[i] = rand() % (SIZE * 10);
    }

    int rFinIndex = (sizeof(r) / sizeof(r[0])) - 1;

    printf("Original List:\n");

    for (int i = 0; i + 10 < rFinIndex; i += 10)
    {
        printf("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,", r[i], r[i + 1], r[i + 2], r[i + 3], r[i + 4], r[i + 5], r[i + 6], r[i + 7], r[i + 8], r[i + 9]);
    }
    for (int i = rFinIndex - rFinIndex % 10; i < rFinIndex; i++)
    {
        printf("%d,", r[i]);
    }
    printf("%d", r[rFinIndex]);

    sort(r, 0, rFinIndex);

    printf("%d\nSorted List:\n", r[rFinIndex]);

    for (int i = 0; i + 10 < rFinIndex; i += 10)
    {
        printf("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,", r[i], r[i + 1], r[i + 2], r[i + 3], r[i + 4], r[i + 5], r[i + 6], r[i + 7], r[i + 8], r[i + 9]);
    }
    for (int i = rFinIndex - rFinIndex % 10; i < rFinIndex; i++)
    {
        printf("%d,", r[i]);
    }
    printf("%d", r[rFinIndex]);
    return 0;
}

void swap(int *a, int *b)
{
    int t = *a;
    *a = *b;
    *b = t;
}

int partition(int r[], int low, int high)
{
    int pivot = r[high];
    int i = low;
    for (int j = low; j < high; j++)
    {
        if (r[j] < pivot)
        {
            swap(&r[i], &r[j]);

            i++;
        }
    }
    swap(&r[i], &r[high]);
    return (i);
}

void sort(int r[], int low, int high)
{
    if (low < high)
    {
        int index = partition(r, low, high);
        sort(r, low, index - 1);
        sort(r, index + 1, high);
    }
}