t = int(input())
for i in range(t):
    x,y,k,n = map(int, input().split())
    req = x-y
    flag = 0
    for j in range(n):
        p,pri = map(int, input().split())
        if(int(pri)<=k and int(p)>=req):
            flag = 1
    if(flag == 1):
        print("LuckyChef")
    else:
        print("UnluckyChef")
    