#include <iostream>
#include <string>
#include <iomanip>

#include "Cat.h"

/*******************************************************************************
 * Cat(string tp, string c) : Animal(c)
 * Creates a new Cat which is an Animal Object with color c and type tp
 ********************************************************************************/

Cat::Cat(string tp, string c) : Animal(c)
{

    type = tp;
}

/*******************************************************************************
 * Cat() : Animal("black")
 * Creates a new Cat whith color black and type "unk"
 ********************************************************************************/

Cat::Cat() : Animal("black")
{
    type = "unk";
}

/*******************************************************************************
 * void setType(string tp)
 * sets type for a Cat Object to tp
 ********************************************************************************/

void Cat::setType(string tp)
{
    type = tp;
}

/*******************************************************************************
 * void displayInfo(string c)
 * prints out the Cat object's type and color
 ********************************************************************************/

void Cat::displayInfo(string c)
{
    cout << "I am a " << type << endl;
    cout << "My color is " << c << endl;
}

/*******************************************************************************
 * void meow()
 * prints out "I can speak! Meow meow!!"
 ********************************************************************************/

void Cat::meow()
{
    cout << "I can speak! Meow meow!!" << endl;
}