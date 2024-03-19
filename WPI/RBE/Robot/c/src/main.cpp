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

float ratio = 5;
float speed = 180;
float degree = 10;
int main()
{
    task ::sleep(250);

    m1.setVelocity(speed, rpm);
    m1.spinTo(degree, rev, false);
    m2.setVelocity(speed, rpm);
    m2.spinTo(-degree, rev, false);

    while (1)
    {
        // Allow other tasks to run
        // this_thread::sleep_for(10);
        // printf("m1 velocity + power: %f", m1.velocity(rpm));
        // printf(" %f\n", m1.power(watt));
        // printf("m2 velocity + power: %f", m2.velocity(rpm));
        // printf(" %f\n", m2.power(watt));
        // if (m1.velocity(rpm) == 0 && m1.power(watt) == 0)
        // {
        //     break;
        // }
        float gain = 0.5 * (s1.reflectivity() - s2.reflectivity());
        m1.spin(fwd, speed + gain, rpm);
        m2.spin(reverse, speed - gain, rpm);
    }
}
