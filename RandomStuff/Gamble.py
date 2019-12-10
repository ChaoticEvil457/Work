import time
import threading
from pynput.keyboard import Listener, KeyCode, Key, Controller


delay = 31
delay2 = 1
start_stop_key = KeyCode(char='s')
exit_key = KeyCode(char='`')
keyboard = Controller()

class KeyPress(threading.Thread):
    def __init__(self, delay,delay2):
        super(KeyPress, self).__init__()
        self.delay = delay
        self.delay2 = delay2
        self.running = False
        self.program_running = True

    def start_clicking(self):
        self.running = True
        
    def stop_clicking(self):
        self.running = False

    def exit(self):
        self.stop_clicking()
        self.program_running = False

    def run(self):
        time.sleep(3)
        while self.program_running:
            keyboard.press(Key.enter)
            keyboard.release(Key.enter)
            while self.running:
                time.sleep(self.delay2)
                keyboard.type("!with 100")
                keyboard.press(Key.enter)
                keyboard.release(Key.enter)
                #################################################
                time.sleep(self.delay2)
                keyboard.type("!roulette 100 1st")
                keyboard.press(Key.enter)
                keyboard.release(Key.enter)
                #################################################
                time.sleep(self.delay2)
                keyboard.type("!work")
                keyboard.press(Key.enter)
                keyboard.release(Key.enter)
                #################################################
                time.sleep(self.delay2)
                keyboard.type("!slut")
                keyboard.press(Key.enter)
                keyboard.release(Key.enter)
                ########################################################
                time.sleep(self.delay2)
                keyboard.type("!crime")
                keyboard.press(Key.enter)
                keyboard.release(Key.enter)
                ##########################################################
                time.sleep(self.delay2)
                keyboard.type("!dep all")
                keyboard.press(Key.enter)
                keyboard.release(Key.enter)
                time.sleep(self.delay)
            time.sleep(0.1)


cont = Controller()
key_thread = KeyPress(delay,delay2)
key_thread.start()


def on_press(key):
    if key == start_stop_key:
        if key_thread.running:
            key_thread.stop_clicking()
        else:
            key_thread.start_clicking()
    elif key == exit_key:
        key_thread.exit()
        listener.stop()


with Listener(on_press=on_press) as listener:
    listener.join()