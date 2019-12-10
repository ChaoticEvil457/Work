# War program using objects
from Card import Card
import random
s = "diamonds"
n = 0
sub = 0
ray = []
while n<26:
    if n == 13:
        s = "clubs"
        sub = 13
    if n == 26:
        s = "spades"
        sub = 26
    if n == 39:
        s = "hearts"
        sub = 39
    ray.append(Card(s,(n-sub+2)))
    n+=1
def shuffle(ray):
    temp = []
    while len(ray)>0:
        r = random.randint(0,len(ray)-1)
        temp.append(ray[r])
        del(ray[r])
    return temp
ray = shuffle(ray)
cpuRay = []
for z in range(13):
    cpuRay.append(ray[0])
    del(ray[0])
playerRay = []
for g in range(13):
    playerRay.append(ray[0])
    del(ray[0])
while not len(playerRay) == 0 and not len(cpuRay) == 0:
    print("You played the",playerRay[0].getFace(),"of",playerRay[0].getSuit(),"and ",end = "")
    print("the computer played the",cpuRay[0].getFace(),"of",cpuRay[0].getSuit())
    if playerRay[0].getNum() > cpuRay[0].getNum():
        print("You won the round")
        playerRay.append(cpuRay[0])
        playerRay.append(playerRay[0])
        del(playerRay[0])
        del(cpuRay[0])
    elif playerRay[0].getNum() < cpuRay[0].getNum():
        print("The computer won the round")
        cpuRay.append(playerRay[0])
        cpuRay.append(cpuRay[0])
        del(cpuRay[0])
        del(playerRay[0])
    else:
        print("Tie")
        del(cpuRay[0])
        del(playerRay[0])
            
if len(cpuRay) == 0:
    print("You won!")
elif len(playerRay) == 0:
    print("The computer won!")