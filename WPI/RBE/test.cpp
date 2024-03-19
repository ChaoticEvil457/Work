#include <stdio.h>

unsigned long long int factorial(int num)
{
    if (num <= 2)
    {
        return num;
    }
    return num * factorial(num - 1);
}
int main(){
    printf("%llu",factorial(20));
}