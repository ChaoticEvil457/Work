def removeCommon(wordlist):
    word1=wordlist[0]
    word2=wordlist[1]
    wordlist.clear()
    c=0
    while c<len(word1) and c<len(word2):
        if(word1[c]==word2[c]):
            word1=word1[:c] + word1[c+1:]
            word2=word2[:c] + word2[c+1:]
            c=0
        else:
            c+=1
    wordlist.append(word1)
    wordlist.append(word2)
    return(wordlist)


def checkNear(wordlist):
    word1=wordlist[0]
    word2=wordlist[1]
    c=0
    if word1==word2:
        wordlist.clear
        return wordlist
    elif len(word2)>len(word1):
        while c <len(word1)-1:
            if word1[c]==word2[c+1]:
                word2=word2[:c] + word2[c+1:]
                wordlist[1]=word2
                wordlist=removeCommon(wordlist)
                word1=wordlist[0]
                word2=wordlist[1]
                checkNear(wordlist)
                c=-1
                break
            if word1[c+1]==word2[c]:
                word1=word1[:c] + word1[c+1:]
                wordlist[0]=word1
                wordlist=removeCommon(wordlist)
                word1=wordlist[0]
                word2=wordlist[1]
                checkNear(wordlist)
                c=-1
                break
            c+=1
        c=0
    elif len(word2)<len(word1):
        while c<len(word2)-1:
            if word2[c]==word1[c+1]:
                word1=word1[:c] + word1[c+1:]
                wordlist[0]=word1
                wordlist=removeCommon(wordlist)
                word1=wordlist[0]
                word2=wordlist[1]
                checkNear(wordlist)
                c=-1
                break
            if word1[c]==word2[c+1]:
                word2=word2[:c] + word2[c+1:]
                wordlist[1]=word2
                wordlist=removeCommon(wordlist)
                word1=wordlist[0]
                word2=wordlist[1]
                checkNear(wordlist)
                c=-1
                break
            c+=1
        c=0
        
    else:
        while c<len(word2)-1:
            if word1[c+1]==word2[c]:
                word1=word1[:c] + word1[c+1:]
                wordlist[0]=word1
                wordlist=removeCommon(wordlist)
                word1=wordlist[0]
                word2=wordlist[1]
                checkNear(wordlist)
                c=-1
                break
            if word1[c]==word2[c+1]:
                word2=word2[:c] + word2[c+1:]
                wordlist[1]=word2
                wordlist=removeCommon(wordlist)
                word1=wordlist[0]
                word2=wordlist[1]
                checkNear(wordlist)
                c=-1
                break
            c+=1
    return wordlist

def equation(wordlist):
    val=0
    word1=wordlist[0]
    word2=wordlist[1]
    if len(wordlist[0])<len(wordlist[1]):
        for c in range(len(wordlist[0])):
            val+=ord(word1[c])-ord(word2[c])
        for c in range(len(wordlist[1])-len(wordlist[0])):
            val+=1
    else:
        for c in range(len(wordlist[1])):
            val+=ord(word1[c])-ord(word2[c])
        for c in range(len(wordlist[0])-len(wordlist[1])):
            val+=1
    return val

with open("input.txt","rt") as f:
    for line in f:
        wordlist=line.split()
        print(wordlist)
        wordlist=removeCommon(wordlist)
        print(wordlist)
        wordlist = checkNear(wordlist)
        print(wordlist)
        print(equation(wordlist))
        print("")