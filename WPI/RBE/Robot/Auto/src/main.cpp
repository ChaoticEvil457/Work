/*----------------------------------------------------------------------------*/
/*                                                                            */
/*    Module:       main.cpp                                                  */
/*    Author:       ninju                                                     */
/*    Created:      10/7/2022, 3:31:08 PM                                     */
/*    Description:  V5 project                                                */
/*                                                                            */
/*----------------------------------------------------------------------------*/
#include "vex.h"

using namespace vex;

// A global instance of vex::brain used for printing to the V5 brain screen
vex::brain Brain;

// define your global instances of motors and other devices here
enum dir
{
    RIGHT,
    LEFT
};
int dir = LEFT;
motor r = motor(11);
motor l = motor(14);
motor h = motor(10);
motor intakeLift = motor(4);
motor liftLift = motor(19);
motor liftLift2 = motor(18);
motor arm = motor(15);
sonar s = sonar(Brain.ThreeWirePort.F);
line rs = line(Brain.ThreeWirePort.G);
line ls = line(Brain.ThreeWirePort.H);
controller cont = controller();
int speed = 70;
float width = 0.20;
float wheelRad = 0.05;
int gain = 0;
void strafe();
void kill();
void collect();
void correct();
int standoff = 100;
int num = 0;
int num2 = 0;

int main()
{
    r.setBrake(hold);
    l.setBrake(hold);
    liftLift.setBrake(hold);
    liftLift2.setBrake(hold);
    intakeLift.setBrake(hold);
    arm.setBrake(hold);
    rs.reflectivity();
    ls.reflectivity();
    while (1)
    {
        if (num == 2)
        {
            dir = LEFT;
        }
        Brain.Screen.printAt(10, 100, "%3d, %3d", rs.reflectivity(), ls.reflectivity());
        Brain.Screen.printAt(10, 150, "%4.4f", s.distance(mm));
        if (rs.reflectivity() > 90 && ls.reflectivity() > 90 && rs.reflectivity() != 100)
        {
            r.spinFor(-speed * 4, deg, speed, rpm, false);
            l.spinFor(speed * 4, deg, speed, rpm);
            kill();
            strafe();
            num++;
            speed = abs(speed);
        }
        else if (s.distance(mm) < 200 && s.distance(mm) > 20 && num < 10 && speed == abs(speed) && num2 < 2)
        {
            kill();
            collect();
            speed *= -1;
        }
        else
        {
            r.spin(fwd, -speed, rpm);
            l.spin(reverse, -speed, rpm);
            h.stop();
        }
    }
}

void strafe()
{
    if (num == 1)
    {
        correct();
        h.spinFor(3200, deg, speed * 2, rpm);
        r.spinFor(-500, deg, speed, rpm, false);
        l.spinFor(500, deg, speed, rpm);
        speed *= -1;
        num++;
    }

    if (dir == LEFT)
    {
        while (ls.reflectivity() < 90)
        {
            h.spin(reverse, speed / 2, rpm);
        }
        while (rs.reflectivity() < 90)
        {
            h.spin(fwd, speed / 2, rpm);
        }
        dir = RIGHT;
    }
    else if (dir == RIGHT)
    {
        r.spinFor(-300, deg, speed, rpm);
        l.spinFor(300, deg, speed, rpm);
        while (rs.reflectivity() < 90)
        {
            h.spin(fwd, speed / 2, rpm);
        }
        while (ls.reflectivity() < 90)
        {
            h.spin(reverse, speed / 2, rpm);
        }
        dir = LEFT;
    }
    kill();
}

void collect()
{
    if (num2 == 1)
    {
        while (ls.reflectivity() < 90)
        {
            h.spin(fwd, speed / 2, rpm);
        }
    }
    else if (dir == RIGHT)
    {
        while (rs.reflectivity() < 90)
        {
            h.spin(reverse, speed / 2, rpm);
        }
    }
    else
    {
        while (ls.reflectivity() < 90)
        {
            h.spin(fwd, speed / 2, rpm);
        }
    }
    num2++;
    kill();
    s.distance(mm);
    Brain.Screen.printAt(10, 150, "%4.4f", s.distance(mm));
    liftLift.spinFor(-4250, deg, 160, rpm, false);
    liftLift2.spinFor(4250, deg, 160, rpm);
    intakeLift.spinFor(740, deg, 160, rpm);
    while (s.distance(mm) > standoff)
    {
        Brain.Screen.printAt(10, 150, "%4.4f", s.distance(mm));
        r.spin(fwd, -10, rpm);
        l.spin(reverse, -10, rpm);
    }
    standoff += 10;
    Brain.Screen.printAt(10, 150, "%4.4f", s.distance(mm));
    kill();
    arm.spinFor(-570, deg, 90, rpm);
    liftLift.spinFor(1100, deg, 160, rpm, false);
    liftLift2.spinFor(-1100, deg, 160, rpm);
    intakeLift.spinFor(-300, deg, 90, rpm);
    h.spinFor(320, deg, 45, rpm);
    arm.spinFor(570, deg, 90, rpm);
    r.spinFor(350, deg, 100, rpm, false);
    l.spinFor(-350, deg, 100, rpm);
    kill();
    Brain.Screen.printAt(10, 150, "%4.4f", s.distance(mm));
    liftLift.spinFor(3150, deg, 160, rpm, false);
    liftLift2.spinFor(-3150, deg, 160, rpm);
    intakeLift.spinFor(-450, deg, 160, rpm, false);
    kill();
}

void correct()
{
    if (dir == LEFT)
    {
        h.spinFor(-400, deg, 45, rpm);
    }
    else
    {
        h.spinFor(400, deg, 45, rpm);
    }
    while (rs.reflectivity() > 90)
    {
        r.spin(fwd, -speed / 4, rpm);
        l.spin(reverse, -speed / 4, rpm);
    }
    kill();
    while (ls.reflectivity() > 90)
    {
        r.spin(fwd, -speed / 4, rpm);
        l.spin(reverse, -speed / 4, rpm);
    }
    kill();
    while (rs.reflectivity() < 90)
    {
        l.spin(fwd, -speed / 4, rpm);
        r.spin(reverse, -speed / 4, rpm);
    }
    kill();
    while (ls.reflectivity() < 90)
    {
        r.spin(reverse, -speed / 4, rpm);
        l.spin(fwd, -speed / 4, rpm);
    }
    r.spinFor(300, deg, speed, rpm, false);
    l.spinFor(-300, deg, speed, rpm);
    kill();
}
void kill()
{
    r.stop();
    l.stop();
    h.stop();
}