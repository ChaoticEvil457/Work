# Merge Sort
import random
ray = [random.randint(1,1001) for x in range(16)]
length = len(ray)
def merge(ray):
    if len(ray)>1:
        mid = int(len(ray)/2)
        left = ray[:mid]
        right = ray[mid:]
        merge(left)
        merge(right)
        i = j = k = 0

        while i<len(left) and j<len(right):
            if left[i]<right[j]:
                ray[k] = left[i]
                i+=1
            else:
                ray[k] = right[j]
                j+=1
            k+=1
        while i<len(left):
            ray[k] = left[i]
            i+=1
            k+=1
        while j<len(right):
            ray[k] = right[j]
            j+=1
            k+=1
    if len(ray) == length:
        return ray
def pivot(ray,low,high):
    i = low -1
    pivot = ray[high]
    for j in range(low, high):
        i+=1
        ray[i],ray[j] = ray[j],ray[i] 
    ray[i+1],ray[high] = ray[high],ray[i+1] 
    return i+1
#def quickSort(ray):
    
def printRay(ray):
    print(ray[0],end = "")
    for x in range(1,len(ray)):
        print(", ",ray[x],end = "")
    print("\n")
printRay(ray)
ray = merge(ray)
printRay(ray)