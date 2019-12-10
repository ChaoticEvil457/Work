# Card class used in War
class Card:
    def __init__(self,suit,num):
        self.suit = suit
        self.num = num
    def getSuit(self):
        return self.suit
    def getNum(self):
        return self.num
    def getFace(self):
        if self.num == 11:
            return "jack"
        elif self.num == 12:
            return "queen"
        elif self.num == 13:
            return "king"
        elif self.num == 14:
            return "ace"
        else:
            return str(self.num)