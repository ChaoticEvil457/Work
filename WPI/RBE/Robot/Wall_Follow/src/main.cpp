/*----------------------------------------------------------------------------*/
/*                                                                            */
/*    Module:       main.cpp                                                  */
/*    Author:       ninju                                                     */
/*    Created:      Wed Aug 31 2022                                           */
/*    Description:  V5 project                                                */
/*                                                                            */
/*----------------------------------------------------------------------------*/
#include "vex.h"
using namespace vex;
#include <iostream>
using namespace std;
// A global instance of vex::brain used for printing to the V5 brain screen
vex::brain Brain;

// define your global instances of motors and other devices here
motor m1 = motor(0, ratio18_1);
motor m2 = motor(9, ratio18_1);
line s1 = line(Brain.ThreeWirePort.G);
line s2 = line(Brain.ThreeWirePort.H);
sonar u1 = sonar(Brain.ThreeWirePort.E);
float ratio = 5;
float speed = 180;
float degree = 10;
int main()
{
    task ::sleep(250);

    m1.setVelocity(speed, rpm);
    m2.setVelocity(speed, rpm);

    while (1)
    {
        float gain = .9*(30 - (u1.distance(distanceUnits::cm)));
        m1.spin(fwd, speed + gain, rpm);
        m2.spin(reverse, speed - gain, rpm);
    }
}
