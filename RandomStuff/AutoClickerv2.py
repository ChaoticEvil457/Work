import pyautogui, time
import threading
from pynput.mouse import Button, Controller
from pynput.keyboard import Listener, KeyCode


delay = 0.03
button = Button.left
start_stop_key = KeyCode(char='s')
exit_key = KeyCode(char='`')


class ClickMouse(threading.Thread):
    def __init__(self, delay, button):
        super(ClickMouse, self).__init__()
        self.delay = delay
        self.button = button
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
        while self.program_running:
            while self.running:
                ############################################### 1
                pyautogui.moveTo(1231,1914) #job
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1447,978) #button
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(851,1901) #main
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2186,960) #talk
                time.sleep(self.delay)
                for i in range(3): #click
                    mouse.click(self.button)
                    time.sleep(self.delay)
                pyautogui.moveTo(3030,1723) #advance
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                ############################################## 1
                pyautogui.moveTo(1549,1893) #hobby
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1467,1031) #button
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(851,1901) #main
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2186,960)
                for i in range(14):
                    mouse.click(self.button)
                    time.sleep(self.delay)
                pyautogui.moveTo(3030,1723) #advance
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                #################################################### 1
                pyautogui.moveTo(1549,1893) #hobby
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1472,1229) #1
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1450,1434) #2
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1491,1600) #3
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1231,1914) #job
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2474,989) #button
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(851,1901) #main
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2186,960)
                time.sleep(self.delay)
                for i in range(20):
                    mouse.click(self.button)
                    time.sleep(self.delay)
                pyautogui.moveTo(2150,1158) #gift
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1403,1114) #gift 1
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2471,1234) #pay
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(3030,1723) #advance
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                ################################################## 1
                pyautogui.moveTo(2150,1158) #gift
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1793,1097) #gift 2
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2471,1234) #pay
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2186,960)
                time.sleep(self.delay)
                for i in range(30):
                    mouse.click(self.button)
                    time.sleep(self.delay)
                pyautogui.moveTo(3030,1723) #advance
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                ############################################################ 1
                pyautogui.moveTo(2916,775) #exit
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1549,1893) #hobby
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2082,1021)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2133,1245)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(851,1901) #main
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2150,1158) #gift
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1381,1289) #gift 3
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2471,1234) #pay
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2132,1277) #date
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1670,1148) #moon
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2471,1234) #pay
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2474,1604) #end
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2186,960)
                time.sleep(self.delay)
                for i in range(30):
                    mouse.click(self.button)
                    time.sleep(self.delay)
                pyautogui.moveTo(3030,1723) #advance
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                ############################################ 2
                pyautogui.moveTo(895,1277) #next
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2186,960) #oops
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(3030,1723) #advance
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                ################################################# 2
                pyautogui.moveTo(2186,960) #oops x2
                time.sleep(self.delay)
                for i in range(10):
                    mouse.click(self.button)
                    time.sleep(self.delay)
                pyautogui.moveTo(3030,1723) #advance
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                ####################################################### 2
                pyautogui.moveTo(2150,1158) #gift
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1793,1097) #gift 2
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2471,1234) #pay
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2186,960)
                time.sleep(self.delay)
                for i in range(10):
                    mouse.click(self.button)
                    time.sleep(self.delay)
                pyautogui.moveTo(3030,1723) #advance
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                ################################################# 2
                pyautogui.moveTo(2186,960)
                time.sleep(self.delay)
                for i in range(30):
                    mouse.click(self.button)
                    time.sleep(self.delay)
                pyautogui.moveTo(2150,1158) #gift
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1381,1289) #gift 3
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2471,1234) #pay
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(3030,1723) #advance
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2916,775) #exit
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                ################################################## 2
                pyautogui.moveTo(2132,1277) #date
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1670,1148) #moon
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2471,1234) #pay
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1330,1594) #continue
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2474,1604) #end
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2150,1158) #gift
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1805,1297) #gift 4
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2471,1234) #pay
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2186,960)
                time.sleep(self.delay)
                for i in range(20):
                    mouse.click(self.button)
                    time.sleep(self.delay)
                pyautogui.moveTo(3030,1723) #advance
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                ############################################### 3
                pyautogui.moveTo(872,1541) #next
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2186,960) #oops
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(3030,1723) #advance
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                ################################################# 3
                pyautogui.moveTo(2186,960) #oops
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(3030,1723) #advance
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                ################################################### end
                pyautogui.moveTo(1846,1955) #stat
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(2919,1371) #reset
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(self.delay)
                pyautogui.moveTo(1636,1627)
                time.sleep(self.delay)
                mouse.click(self.button)
                time.sleep(6.5)
            time.sleep(0.1)


mouse = Controller()
click_thread = ClickMouse(delay, button)
click_thread.start()


def on_press(key):
    if key == start_stop_key:
        if click_thread.running:
            click_thread.stop_clicking()
        else:
            click_thread.start_clicking()
    elif key == exit_key:
        click_thread.exit()
        listener.stop()


with Listener(on_press=on_press) as listener:
    listener.join()