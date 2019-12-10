import pyautogui, time, threading
from pynput.mouse import Button, Controller
from pynput.keyboard import Listener, KeyCode

time.sleep(2)
print(pyautogui.position())