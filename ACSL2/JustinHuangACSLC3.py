def diagramRules(inputs,z):
    x1,x2,x3,x4,y1,y2,y3,y4=True,True,True,True,True,True,True,True
    negate=False
    for x in z:
        if(x=='~'):
            negate=True
        elif(negate==True):
            if(x=='A'):
                y1=False
                y2=False
            elif(x=='B'):
                x1=False
                x2=False
            elif(x=='C'):
                y2=False
                y3=False
            elif(x=='D'):
                x2=False
                x3=False
            negate=False
        elif(negate==False):
            if(x=='A'):
                y3=False
                y4=False
            elif(x=='B'):
                x3=False
                x4=False
            elif(x=='C'):
                y1=False
                y4=False
            elif(x=='D'):
                x1=False
                x4=False
    return(x1,x2,x3,x4,y1,y2,y3,y4)
def convertToHex(diagram):
    binarynum=0
    numadd=1
    ray=[3,2,1,0]
    for x in ray:
        for y in ray:
            if(diagram[x][y]==1):
                binarynum+=numadd
            numadd*=2
    hexnum=hex(binarynum)
    hexnum=hexnum[2:]
    while(len(hexnum)<4):
        hexnum='0'+hexnum
    print(hexnum.upper())

def createDiagram(input):
    inputs=[]
    s=0
    c=""
    for z in range(len(input[0])):
        if(input[0][z]=='+'):
            inputs+=" "
            inputs[s]=c
            s+=1
            c=""
        else:
            c+=input[0][z]
    inputs+=" "
    inputs[s]=c
    diagram=[[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
    for z in inputs:
        x1,x2,x3,x4,y1,y2,y3,y4=diagramRules(inputs,z)
        xray = [x1,x2,x3,x4]
        yray = [y1,y2,y3,y4]
        for checkx in range(len(xray)):
            for checky in range(len(yray)):
                if(xray[checkx] and yray[checky]):
                    diagram[checkx][checky]=1
    convertToHex(diagram)

with open("input.txt","rt") as f:
    for line in f:
        wordlist=line.split()
        createDiagram(wordlist)