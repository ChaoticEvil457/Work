import time
import pygame
import random
from random import randint
from Paddle import Paddle
from Ball import Ball

#creating a list that randomizes the direction of the ball at start
ray = [4,-4]

#declaring colors
BLACK=(0,0,0)
WHITE=(255,255,255)

#initializing pygame
pygame.init()

sizex = 888
sizey = 500
size = (sizex,sizey)

#setting the background
image = pygame.image.load(r'C:\Users\ninju\Pictures\pong screensaver.jpg')
size = (sizex,sizey)
screen=pygame.display.set_mode(size)
pygame.display.set_caption("Pong")

#create player 1's paddle
paddleA = Paddle(WHITE, 10, 100)
paddleA.rect.x = 20
paddleA.rect.y = 200

#create player 2's paddle
paddleB = Paddle(WHITE, 10, 100)
paddleB.rect.x = sizex-30
paddleB.rect.y = 200

#creates the ball
ball = Ball(WHITE,10,10)
ball.rect.x = sizex/2
ball.rect.y = sizey/2

#creates a list of sprites and adds sprites to it
all_sprites_list = pygame.sprite.Group()

all_sprites_list.add(paddleA)
all_sprites_list.add(paddleB)
all_sprites_list.add(ball)

#declaring variables

loop=True #makes the game run multiple times
clock = pygame.time.Clock() #creates time
scoreA=0 #creates player 1's score
scoreB=0 #creates player 2's score
start_time=time.time() #starts a timer
elapsed_time=0 #finds the current time of the timer
boo=True #boolean that causes a pause before the game starts again
starting=True #makes the ball move in a random direction on the first run
while loop: #loop start, will run until someone wins 3 times
    if starting: #if it's the first run
        if elapsed_time<2:#checks if 2 seconds have passed since the start of the program, declared by start_time
            elapsed_time=time.time()-start_time 
        else:
            ball.velocity = [random.choice(ray),randint(-8,8)]#move the ball in a random direction
            image = pygame.image.load(r'C:\Users\ninju\Pictures\pong background.jpg')

            #resets the time variables and turns off this if statement perminantly.
            start_time=0
            elapsed_time=0
            starting=False

    for event in pygame.event.get(): #allows the window to be closed with the x button in the courner or with pressing the x key
        if event.type == pygame.QUIT:
            loop=False
        elif event.type==pygame.KEYDOWN and event.key==pygame.K_x:
            loop=False

    keys=pygame.key.get_pressed() #gets user key input

    #player 1's input
    if keys[pygame.K_w]:
        paddleA.moveUp(7)
    if keys[pygame.K_s]:
        paddleA.moveDown(7)

    #player 2's input
    if keys[pygame.K_UP]:
        paddleB.moveUp(7)
    if keys[pygame.K_DOWN]:
        paddleB.moveDown(7)

    #updates the sprite locations after movements and inputs
    all_sprites_list.update()

    #checks if the ball hits the right edge
    if ball.rect.x>=sizex-10:

        #starts the timer
        if boo:
            start_time=time.time()
            boo=False

        #stops the ball
        ball.velocity[0]=0
        ball.velocity[1]=0

        #checks if 2 seconds have passed
        if elapsed_time<2:
            elapsed_time=time.time()-start_time
        #ends the timer
        else:

            #increase player 1's score, reset the ball, make the ball move right
            scoreA+=1
            ball.rect.x = sizex/2
            ball.rect.y = sizey/2
            ball.velocity[0] = 3
            ball.velocity[1] = 0
            start_time=0
            elapsed_time=0
            boo=True

    #checks if the ball hits the left edge
    elif ball.rect.x<=0:

        #starts the timer
        if boo:
            start_time=time.time()
            boo=False

        #stops the ball
        ball.velocity[0]=0
        ball.velocity[1]=0
        if elapsed_time<2:
            elapsed_time=time.time()-start_time
        #ends the timer
        else:
            #increase player 2's score, resets the ball, makes the ball move left
            scoreB+=1
            ball.rect.x = sizex/2
            ball.rect.y = sizey/2
            ball.velocity[0] = -3
            ball.velocity[1] = 0
            start_time=0
            elapsed_time=0
            boo=True

    #checks if the ball hits the bottom of the screen and reverses its y velocity
    if ball.rect.y>sizey-10:
        ball.velocity[1] = -ball.velocity[1]
    
    #checks if the ball hits the top of the screen and reverses its y velocity
    elif ball.rect.y<0:
        ball.velocity[1] = -ball.velocity[1] 
    
    #checks if the ball hits either paddle and causes it to bounce, reversing its x velocity and randomizing its y velocity
    if pygame.sprite.collide_mask(ball, paddleA) or pygame.sprite.collide_mask(ball, paddleB):
        ball.bounce()

    #Reprints the image
    screen.blit(image,(0,0))

    #Reprints the sprites on top of the image
    all_sprites_list.draw(screen)

    #prints the score for player 1
    font = pygame.font.Font(None, 74)
    text = font.render(str(scoreA), 1, WHITE)
    screen.blit(text, (sizex/2-107,10))

    #prints the score for player 2
    text = font.render(str(scoreB), 1, WHITE)
    screen.blit(text, (sizex/2+93,10))

    #if player 1 wins print that they win and the game ends after 10 seconds
    if(scoreA>2):
        font = pygame.font.Font(None, 54)
        text = font.render("Player 1 Wins!",1,WHITE)
        screen.blit(text, (sizex/2-120,sizey/2-100))
        ball.velocity[0]=0
        ball.velocity[1]=0
        ball.changeColor()
        ball.rect.x = sizey/2
        ball.rect.y = sizex/2
        if boo:
            start_time=time.time()
            boo = False
        if elapsed_time<10:
            elapsed_time = time.time()-start_time
        else:
            loop = False

    #if player 2 wins print that they win and ends the game after 10 seconds
    elif(scoreB>2):
        font = pygame.font.Font(None, 54)
        text = font.render("Player 2 Wins!",1,WHITE)
        screen.blit(text, (sizex/2-120,sizey/2-100))
        ball.velocity[0]=0
        ball.velocity[1]=0
        ball.changeColor()
        ball.rect.x = sizex/2
        ball.rect.y = sizey/2
        if boo:
            start_time=time.time()
            boo = False
        if elapsed_time<10:
            elapsed_time = time.time()-start_time
        else:
            loop = False

    
    #updates the contents of the entire screen
    pygame.display.flip()

    #makes the game run at 60 FPS
    clock.tick(60)

#ends the game
pygame.quit()