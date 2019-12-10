# Tic Tac Toe
board = [['-' for i in range(3)] for i in range(3)]
win = False
moves = 0
player = 'X'
def printBoard():
    for x in board:
        print(x)
def winCon (player):
    if board[0][0] == board[1][1] == board [2][2] == player or board[2][0] == board[1][1] == board[0][2] == player:
        return True
    for i in range(3):
        if board[i][0] == board [i][1] == board[i][2] == player or board[0][i] == board[1][i] == board[2][i] == player:
            return True
    return False
printBoard()
for i in range(9):
    x = int(input("input a x value "))
    y = int(input("input a y value "))
    while x > 3 or y > 3:
        print("That isn't a valid spot")
        x = int(input("input a x value "))
        y = int(input("input a y value "))
    while not board[y][x] == '-':
        print("That isn't a valid spot")
        x = int(input("input a x value "))
        y = int(input("input a y value "))
    board[y][x] = player
    if i == 8:
        printBoard()
        print("It's a draw!")
        break
    else :
        if winCon(player) and player == 'X':
            printBoard()
            print("X wins!")
            break
        elif winCon(player):
            printBoard()
            print("O wins")
            break
    if player == 'X':
        player = 'O'
    else:
        player = 'X'
    printBoard()