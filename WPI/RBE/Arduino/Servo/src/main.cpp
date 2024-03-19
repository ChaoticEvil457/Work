#include <Arduino.h>
#include <RBE1001Lib.h>
#include <button.h>
#include <ESP32Servo.h>
Servo servo;
#define SERVO_PIN 14
const int ADC_PIN = 35;
const int BUZZ_PIN = 26;

Button bootButton(BOOT_FLAG_PIN);

enum SYSTEM_STATE
{
    SYS_IDLE,
    SYS_ACTIVE
};

// Declare a variable, robotState, of our new type, ROBOT_STATE. Initialize it to ROBOT_IDLE.
SYSTEM_STATE state = SYS_IDLE;

void setup()
{
    Serial.begin(115200);
    // pin definitions https://wpiroboticsengineering.github.io/RBE1001Lib/RBE1001Lib_8h.html#define-members
    pinMode(ADC_PIN, INPUT);
    bootButton.Init();
}

/*
 * The main loop for the program. The loop function is repeatedly called
 * once the ESP32 is started.
 */
void handleButtonPress(){
    if(state == SYS_IDLE){
        Serial.println("Active");
        servo.attach(SERVO_PIN);
        state = SYS_ACTIVE;
    }
    else{
        Serial.println("Idle");
        servo.detach();
        noTone(BUZZ_PIN);
        state = SYS_IDLE;
    }
}
void handleTimerExpired()
{
    if (state==SYS_ACTIVE)
    {
        uint16_t angle = (analogRead(ADC_PIN)*180.0)/4096;
        servo.write(angle);
        tone(BUZZ_PIN,analogRead(ADC_PIN));
    }
}

void loop()
{
    if (bootButton.CheckButtonPress())
        handleButtonPress();
    static unsigned long lastRead = 0;
    unsigned long currRead = millis();
    if (currRead - lastRead > 200)
    {
        lastRead = currRead;
        handleTimerExpired();
    }
}