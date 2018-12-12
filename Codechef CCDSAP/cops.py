t = int(input())
for i in range(t):
    M,x,y = map(int,input().split())
    dis = int(x*y)
    #print(dis)
    arr = [int(x) for x in input().split()]
    arr.sort()
    count1 = 0
    count1 = count1 + (max(0,arr[0]-dis-1))
    #print (count1)
    #print(arr)
    for j in range(1,len(arr)):
        #print(j)
        count1 = count1 + max(0,(arr[j]-dis-arr[j-1]-dis-1))
        #print(count1)
    count1 = count1+max(0,100-(arr[len(arr)-1]+dis))
    print(count1)