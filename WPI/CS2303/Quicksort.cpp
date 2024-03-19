#include <iostream>

using std::cout;

void swap(int &a, int &b);
int partition(int r[], int low, int high);
void sort(int r[], int low, int high);

int main()
{
    int r[3] = {1, 2, 3};
    sort(r, 0, (sizeof(r) / sizeof(r[0])) - 1);
}

void sort(int r[], int low, int high)
{
}

int partition(int r[], int low, int high)
{
}

void swap(int &a, int &b)
{
    int temp = a;
    a = b;
    b = temp;
}