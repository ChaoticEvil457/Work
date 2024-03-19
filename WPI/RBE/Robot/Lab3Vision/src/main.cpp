/*----------------------------------------------------------------------------*/
/*                                                                            */
/*    Module:       main.cpp                                                  */
/*    Author:       ninju                                                     */
/*    Created:      Wed Sep 14 2022                                           */
/*    Description:  V5 project                                                */
/*                                                                            */
/*----------------------------------------------------------------------------*/
#include "vex.h"

using namespace vex;
using signature = vision::signature;
using code = vision::code;

// A global instance of vex::brain used for printing to the V5 brain screen
vex::brain Brain;
signature YELLOW = signature(1, 1545, 1773, 1659, -3381, -3183, -3282, 2.5, 0);
signature RED = signature(2, 9813, 12345, 11079, -1103, -681, -892, 2.5, 0);
signature BLUE = signature(3, -2163, -1507, -1835, 9079, 11893, 10486, 2.5, 0);

// define your global instances of motors and other devices here

vision VISION_SENSOR = vision(10, 50, YELLOW, RED, BLUE);
motor LEFT_MOTOR = motor(9);
motor RIGHT_MOTOR = motor(0);

struct robot
{
    float width = 11.125;
    motor l = motor(9);                           // left motor
    motor r = motor(0);                           // right motor
    vision v = vision(10, 50, YELLOW, RED, BLUE); // vision sensor
    int s = 210;                                  // speed

} b;

int main()
{
    while (1)
    {
        b.v.takeSnapshot(RED);
        // Allow other tasks to run
        if (b.v.objectCount > 0)
        {
            Brain.Screen.printAt(50, 50, "x: %d, y: %d", b.v.largestObject.centerX, b.v.largestObject.centerY);
            printf("x: %d, y: %d", b.v.largestObject.centerX, b.v.largestObject.centerY);
            b.l.spin(fwd, (160 - b.v.largestObject.centerX) * 1.5 - (b.v.largestObject.width - 50) * 3, rpm);
            b.r.spin(reverse, (160 - b.v.largestObject.centerX) * 1.5 - (b.v.largestObject.width - 50) * 3, rpm);
        }
        else
        {
            b.l.spin(fwd, b.s, rpm);
            b.r.spin(fwd, b.s, rpm);
        }
    }
}
