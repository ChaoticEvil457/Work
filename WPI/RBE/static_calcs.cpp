#include <tgmath.h>
#include <stdio.h>
#define PI 3.14159265358979
#define g 9.81
int main()
{
    float alpha = 0, a = 0, b = 0, h = 0, Mu = 0, m = 0, reqForce = 0, fForce = 0, rForce = 0, traction = 0;
    // a is front, b is rear

    /*printf("Alpha = ");
    scanf(" %f", &alpha);
    printf("a = ");
    scanf(" %f", &a);
    printf("b = ");
    scanf(" %f", &b);
    printf("h = ");
    scanf(" %f", &h);
    printf("Mu = ");
    scanf(" %f", &Mu);
    printf("m = ");
    scanf(" %f", &m);*/
    alpha = 1;
    a = .4;
    b = .16;
    h = .39;
    Mu = 0.78;
    m = 4.6;
    float rad = alpha * PI / 180;
    reqForce = m * g * sin(rad);
    fForce = (h * reqForce + b * m * g * cos(rad)) / (a + b);
    rForce = (a * m * g * cos(rad) - h * reqForce) / (a + b);
    for (alpha = 1; alpha < 61; alpha++)
    {
        rad = alpha * PI / 180;
        reqForce = m * g * sin(rad);
        fForce = (h * reqForce + b * m * g * cos(rad)) / (a + b);
        rForce = (a * m * g * cos(rad) - h * reqForce) / (a + b);
        printf("%.3f\t%.3f\t%.3f", reqForce, fForce, rForce);
        traction = Mu * fForce + Mu * rForce;
        printf(" %.3f\n", traction);
    }

    traction = Mu * fForce;
    printf("FWD:\n%.3f", traction);

    traction = Mu * rForce;
    printf("\nRWD:\n%.3f", traction);

    traction = Mu * fForce + Mu * rForce;
    printf("\n4WD:\n%.3f", traction);

    return 0;
}