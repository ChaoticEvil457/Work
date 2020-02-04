f=open("input.txt","r")
fin,n,p="","",""
count=False
for line in f:
    for word in line:
        if count and word!="\n":
            p=word
        if(word!=" " and not count and word!="\n"):
            n+=word
        elif word!="\n":
            count=True
    p=int(p)
    b=int(n[len(n)-p])
    for num in n:
        if n.index(num)<len(n)-p:
            if int(num)+b>10:
                fin+=str((int(num)+b)%10)
            else:
                fin+=str(int(num)+b)
        elif n.index(num)==len(n)-p:
            if b>10:
                fin+=str(b%10)
            else:
                fin+=str(b)
        else:
            if int(num)-b>10:
                fin+=str(abs((int(num)-b)%10))
            else:
                fin+=str(abs(int(num)-b))
    print(fin)
    fin,n,p="","",""
    count =False
f.close()