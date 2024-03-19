/*----------------------------------------------------------------------------*/
/*                                                                            */
/*    Module:       main.cpp                                                  */
/*    Author:       ninju                                                     */
/*    Created:      Sat Sep 24 2022                                           */
/*    Description:  V5 project                                                */
/*                                                                            */
/*----------------------------------------------------------------------------*/
#include "vex.h"

using namespace vex;

// A global instance of vex::brain used for printing to the V5 brain screen
vex::brain Brain;
motor r = motor(11);
motor l = motor(14);
motor h = motor(10);
motor intake = motor(6);
motor intakeLift = motor(4);
motor liftLift = motor(19);
motor liftLift2 = motor(18);
motor arm = motor(15);
controller cont = controller();

// define your global instances of motors and other devices here

int main()
{
    r.setBrake(hold);
    l.setBrake(hold);
    intake.setBrake(hold);
    liftLift.setBrake(hold);
    liftLift2.setBrake(hold);
    intakeLift.setBrake(hold);
    arm.setBrake(hold);
    while (1)
    {
        // Allow other tasks to run
        r.spin(fwd, cont.Axis2.position() * 1.2, rpm);
        l.spin(reverse, cont.Axis3.position() * 1.2, rpm);

        if (cont.ButtonR2.pressing())
        {
            intake.spin(reverse, 200, rpm);
        }
        else if (cont.ButtonL2.pressing())
        {
            intake.spin(fwd, 200, rpm);
        }
        else
        {
            intake.stop();
        }
        if (cont.ButtonDown.pressing())
        {
            intakeLift.spin(reverse, 100, rpm);
        }
        else if (cont.ButtonUp.pressing())
        {
            intakeLift.spin(fwd, 100, rpm);
        }
        else
        {
            intakeLift.stop();
        }
        if (cont.ButtonRight.pressing())
        {
            liftLift.spin(fwd, 160, rpm);
            liftLift2.spin(reverse, 160, rpm);
        }
        else if (cont.ButtonLeft.pressing())
        {
            liftLift.spin(reverse, 160, rpm);
            liftLift2.spin(fwd, 160, rpm);
        }
        else
        {
            liftLift.stop();
            liftLift2.stop();
        }
        if (cont.ButtonR1.pressing())
        {
            arm.spin(reverse, 60, rpm);
        }
        else if (cont.ButtonL1.pressing())
        {
            arm.spin(fwd, 60, rpm);
        }
        else
        {
            arm.stop();
        }
        if (cont.ButtonY.pressing())
        {
            h.spin(fwd, 60, rpm);
        }
        else if (cont.ButtonA.pressing())
        {
            h.spin(reverse, 60, rpm);
        }
        else
        {
            h.stop();
        }
    }
}
