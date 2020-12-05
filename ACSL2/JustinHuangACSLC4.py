import numpy as np
board=[]
def checkPrime(n):
    if n % 2 == 0 and n > 2: 
        return False
    return all(n % i for i in range(3, int(np.sqrt(n)) + 1, 2))

    return False
def checkPerfectSquare(n):
    if n>4:
        if n==np.power(np.sqrt(n),2):
            return True
    return False
def move(roll,piece):
    if piece+roll<52:
        piece+=roll
        if checkPrime(piece):
            if piece+6>52:
                return piece
            for x in range(7):
                if board[piece+x+1]>1000:
                    return piece+x
        elif checkPerfectSquare(piece):
            if piece-6<1:
                return piece
            for x in range(7):
                if board[piece-(x+1)]>1000:
                    return piece-x
    elif piece+roll==52:
        board[piece]=piece
        return 
    elif piece+roll>52:
        return piece

with open("input.txt","rt") as f:
    for line in f:
        for x in range(52):
            board.append(x+1)
        print(board)
        pturn=False
        wordlist=line.split()
        p2m1=wordlist[0]
        p2m2=wordlist[1]
        p2m3=wordlist[2]
        p1m1=wordlist[3]
        p1m2=wordlist[4]
        p1m3=wordlist[5]
        board[wordlist[0]]=1011
        board[wordlist[1]]=1012
        board[wordlist[2]]=1013
        board[wordlist[3]]=1001
        board[wordlist[4]]=1002
        board[wordlist[5]]=1003
        wordlist=wordlist[6:]
        print(wordlist)
        for roll in wordlist:
            if pturn:
                piece=min(p2m1,p2m2,p2m3)
                pos=move(roll,piece)
                if piece==p2m1:
                    board[p2m1]=p2m1
                    board[pos]=1011
                    p2m1=pos
                elif piece==p2m2:
                    board[p2m2]=p2m2
                    board[pos]=1012
                    p2m2=pos
                else:
                    board[p2m3]=p2m3
                    board[pos]=1013
                    p2m3=pos
                pturn=False
            else:
                piece=min(p1m1,p1m2,p1m3)
                pos=move(roll,piece)
                if piece==p1m1:
                    board[p1m1]=p1m1
                    board[pos]=1001
                    p1m1=pos
                elif piece==p1m2:
                    board[p1m2]=p1m2
                    board[pos]=1002
                    p1m2=pos
                else:
                    board[p1m3]=p1m3
                    board[pos]=1003
                    p1m3=pos
                pturn=True