var = True
def sqr(a):
    print("\t" + str(a) + "\n________________")
    print("|" + str(a-20) + "\t|1\t|12\t|7\t|")
    print("|11\t|8\t|"+ str(a-21) +"\t|2\t|")
    print("|5\t|10\t|3\t|" + str(a-18) + "\t|")
    print("|4\t|" + str(a-19) + "\t|6\t|9\t|")
while var:
    n = int(input("Input the number you would like to create a magic square out of or type 0 to stop.\n"))
    if n == 0:
        var=False
    else:
        sqr(n)