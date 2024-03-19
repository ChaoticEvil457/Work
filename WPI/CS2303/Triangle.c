#include <stdio.h>
#include <math.h>

float length(float x1, float y1, float x2, float y2);

int main(void)
{
    float x1;
    float y1;
    float x2;
    float y2;
    float x3;
    float y3;
    printf("Enter the x- and y-coordinates of point A: ");
    scanf("%f %f", &x1, &y1);
    printf("Enter the x- and y-coordinates of point B: ");
    scanf("%f %f", &x2, &y2);
    printf("Enter the x- and y-coordinates of point C: ");
    scanf("%f %f", &x3, &y3);
    float lAB = length(x1, y1, x2, y2);                       // gets length of line AB
    float lBC = length(x2, y2, x3, y3);                       // gets length of line BC
    float lCA = length(x3, y3, x1, y1);                       // gets length of line CA
    float circ = lAB + lBC + lCA;                             // calculates circumference
    float s = 0.5 * (lAB + lBC + lCA);                        // stores circ/2
    float area = sqrt(s * (s - lAB) * (s - lBC) * (s - lCA)); // gets area
    printf("Length of AB is %.3f\n", lAB);                    //%.3f prints the number with 3 decimals
    printf("Length of BC is %.3f\n", lBC);
    printf("Length of CA is %.3f\n", lCA);
    printf("The circumference is %.3f\n", circ);
    printf("The area is %.3f\n", area);
}

float length(float x1, float y1, float x2, float y2)
{
    return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2)); // square root of (x1-x2 squared) + (y1 - y2 squared)
}