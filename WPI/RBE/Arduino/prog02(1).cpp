#include <Arduino.h>
#include <RBE1001Lib.h>
#include <button.h>


int ADC_PIN = 35;

void setup()
{
    // This will initialize the Serial at a baud rate of 115200 for prints
    // Be sure to set your Serial Monitor appropriately in platformio.ini
    Serial.begin(115200);

    pinMode(ADC_PIN, INPUT);
}

float getVoltage(int p, float volts)
{
    return (analogRead(p) * volts) / 4096;
}

unsigned long long int factorial(int num)
{
    if (num <= 2)
    {
        return num;
    }
    return num * factorial(num - 1);
}