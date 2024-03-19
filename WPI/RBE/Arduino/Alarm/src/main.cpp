#include <Arduino.h>
#include <RBE1001Lib.h>
#include <ESP32Servo.h>

// define the states in easy-to-read terms
enum AlarmState
{
  ALARM_OFF,
  ALARM_ARMED,
  ALARM_INTRUDER
};
// off <- armed or intruder
// armed <- off
// intruder <- armed
Servo servo;
AlarmState currentState = ALARM_OFF; // start off with the alarm deactivated

// Some pin definitions:
const int buttonArmingPin = 0;
const int buttonDisarmingPin = 32;
const int photoPin = 35;
const int piezoPin = 26;
const int ledPin = 33;
const int servoPin = 14;

void HandleArmingButton(void)
{
  if (currentState == ALARM_OFF)
  {
    Serial.println("Arming!");
    // take action: light the LED
    digitalWrite(ledPin, HIGH);

    // take action: you get to ADD CODE HERE to move the servo!
    servo.attach(servoPin);
    servo.write(180);
    currentState = ALARM_ARMED; // Don't forget to change the state!
  }
}

void HandleLaserBroken(void)
{
  // YOUR CODE HERE!
  if (currentState == ALARM_ARMED)
  {
    Serial.println("Intruder!");
    currentState = ALARM_INTRUDER;
    tone(piezoPin, 1200); // plays a tone
  }
}

void HandleDisarmingButton(void)
{
  // YOUR CODE HERE!
  if (currentState == ALARM_ARMED || currentState == ALARM_INTRUDER)
  {
    Serial.println("disarming");
    noTone(piezoPin); // disables tone if playing
    servo.write(0);
    digitalWrite(ledPin, LOW);
    currentState = ALARM_OFF;
  }
}

/*
 * Code for checking the button -- you don't need to edit this one
 */
bool CheckArmingButton(void)
{
  static int prevButtonState = HIGH; // button up => pin reads HIGH

  bool retVal = false;

  int currButtonState = digitalRead(buttonArmingPin);
  if (prevButtonState != currButtonState)
  {
    delay(10); // this is a cheat for debouncing -- the only place delay is allowed!
    if (currButtonState == LOW)
      retVal = true; // button is down => pin reads LOW
  }
  prevButtonState = currButtonState;

  return retVal;
}

/*
 * Code for checking the laser. YOU WILL NEED TO EDIT THIS ONE
 */
enum
{
  DARK,
  LIGHT
};

bool CheckIfLaserBroken(void)
{
  static int prevLaserSensorState = DARK; // the program starts with the laser off
  bool retVal = false;
  int adc = analogRead(photoPin); // 2420 on, 1100 off
  int currLaserSensorState;
  if (adc > 2500)
  { // check if dark
    currLaserSensorState = DARK;
  }
  else
  {
    currLaserSensorState = LIGHT;
  }
  // add code here to detect the EVENT of the laser being broken. See the button checker above for hints
  if (currLaserSensorState != prevLaserSensorState)
  {
    delay(10);
    if (currLaserSensorState == DARK)
    {
      retVal = true;
    }
  }
  prevLaserSensorState = currLaserSensorState;
  return retVal;
}

/*
 * You'll have to make your own disarming checker!
 */

bool CheckDisarmingButton(void)
{
  static int prevDisarmButtonState = HIGH; // button up => pin reads HIGH
  bool retVal = false;
  int currDisarmButtonState = digitalRead(buttonDisarmingPin);
  if (prevDisarmButtonState != currDisarmButtonState)
  {
    delay(10); // this is a cheat for debouncing -- the only place delay is allowed!
    if (currDisarmButtonState == LOW)
      retVal = true; // button is down => pin reads LOW
  }
  prevDisarmButtonState = currDisarmButtonState;

  return retVal;
}

void setup(void)
{
  Serial.begin(115200);
  Serial.println("Hello!");

  pinMode(buttonArmingPin, INPUT_PULLUP);    // if we use INPUT_PULLUP, we don't have to have an external pullup resistor
  pinMode(buttonDisarmingPin, INPUT_PULLUP); // if we use INPUT_PULLUP, we don't have to have an external pullup resistor
  pinMode(photoPin, INPUT);
  pinMode(piezoPin, OUTPUT);
  pinMode(ledPin, OUTPUT);

  delay(500);

  Serial.println("setup() complete");
}

void loop(void)
/*
 * Our loop() is just a set of checker-handler pairs.
 */
{
  if (CheckArmingButton())
    HandleArmingButton();
  if (CheckIfLaserBroken())
    HandleLaserBroken();
  if (CheckDisarmingButton())
    HandleDisarmingButton();
}