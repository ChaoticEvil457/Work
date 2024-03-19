#include <Arduino.h>
#include <RBE1001Lib.h>
#include <button.h>

// declare the pin for the LED
const int LED_PIN = 33;
int COUNT = 1;

// Create a button object for the built-in button on the ESP32
Button bootButton(BOOT_FLAG_PIN);

// Define two basic states. For this program, they will correspond to an LED state (on or off).
// "enum" stands for "enumerate". Basically, we define a new variable type called ROBOT_STATE.
// We prepend "ROBOT_" to everything to avoid conflicts with other variables that may be defined elsewhere.
enum SYSTEM_STATE
{
  SYS_IDLE,
  SYS_ACTIVE
};

// Declare a variable, robotState, of our new type, ROBOT_STATE. Initialize it to ROBOT_IDLE.
SYSTEM_STATE state = SYS_IDLE;

void setup()
{
  // This will initialize the Serial at a baud rate of 115200 for prints
  Serial.begin(115200);
  // TODO: Set the LED pin to be an OUTPUT
  pinMode(LED_PIN, OUTPUT);
  digitalWrite(LED_PIN, HIGH);
  // Initialize the button object
  bootButton.Init();
}
bool a = false;
void loop()
{
  static unsigned long lastRead = 0;
  static unsigned long blinkDelay = 0;
  unsigned long currRead = millis();
  if (currRead - lastRead > 250 * COUNT)
  {
    digitalWrite(LED_PIN, LOW);
    if (currRead - lastRead > 1000 + 250 * COUNT)
    {
      lastRead = currRead;
      COUNT++;
    }
  }
  else if (digitalRead(LED_PIN) == HIGH && currRead - blinkDelay >= 50)
  {
    blinkDelay = currRead;
    digitalWrite(LED_PIN, LOW);
  }
  else if (currRead - blinkDelay >= 50)
  {
    blinkDelay = currRead;
    digitalWrite(LED_PIN, HIGH);
  }
  if (COUNT == 11)
  {
    COUNT = 1;
  }
}