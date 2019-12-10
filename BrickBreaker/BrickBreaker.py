import time
import pygame
import random
from random import randint
from BrickPaddle import Paddle
from BrickBall import Ball
from Bricks import Bricks

ray = []

pygame.init()
BLACK = (0,0,0)
WHITE = (255,255,255)
size = (700, 500)
screen = pygame.display.set_mode(size)
pygame.display.set_caption("Brick Breaker")

paddle = Paddle(WHITE, 100, 10)
paddle.rect.x = 300
paddle.rect.y = 480

ball = Ball(WHITE,10,10)
ball.rect.x = 350
ball.rect.y = 450

all_sprites_list = pygame.sprite.Group()
all_sprites_list.add(paddle)
all_sprites_list.add(ball)

for z in range(4):
    for f in range(5):
        ray.append(Bricks(WHITE,20,30))
        ray[z+f].rect = [20+(f*130),20+(z*30)]
        all_sprites_list.add(ray[z+f])


loop=True
clock = pygame.time.Clock()
score = 0
start_time=time.time()
elapsed_time=0
boo=True
starting=True
lives=3

while loop:
    if starting:
        if elapsed_time<2:
            elapsed_time=time.time()-start_time
        else:
            ball.velocity = [0,4]
            start_time=0
            elapsed_time=0
            starting=False
    for event in pygame.event.get():
        if event.type == pygame.QUIT or event.type==pygame.KEYDOWN and event.key==pygame.K_x:
            loop = False
    
    keys = pygame.key.get_pressed()
    if keys[pygame.K_a] or keys[pygame.K_LEFT]:
        paddle.moveLeft(7)
    if keys[pygame.K_d] or keys[pygame.K_RIGHT]:
        paddle.moveRight(7)
    
    all_sprites_list.update()

    if ball.rect.y<=490:
        if boo:
            start_time=time.time()
            boo=False
        ball.velocity[0]=0
        ball.velocity[1]=0
        if elapsed_time<2:
            elapsed_time=time.time()-start_time
        else:
            lives-=1
            ball.rect.x = 350
            ball.rect.y = 450
            ball.velocity[0] = 0
            ball.velocity[1] = -3
            start_time=0
            elapsed_time=0
            boo=True
    elif ball.rect.x>=690:
        ball.velocity[0] = -ball.velocity[0]
    elif ball.rect.x<0:
        ball.velocity[0] = -ball.velocity[0]
    elif ball.rect.y<0:
        ball.velocity[1] = -ball.velocity[1]
    
    if pygame.sprite.collide_mask(ball, paddle):
        ball.bounce()
    for brickmaskcheck in ray:
        if pygame.sprite.collide_mask(ball,brickmaskcheck):
            ball.bounce()
            ray[ray.index(brickmaskcheck)].rect = [-1000,-1000]
            ray.remove(brickmaskcheck)
    screen.fill(BLACK)
    all_sprites_list.draw(screen)

    pygame.display.flip()
    clock.tick(60)
pygame.quit()