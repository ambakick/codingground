from sys import stdin
t = int(input())
for i in range(t):
    x,y,k,n = map(int, stdin.readline().split())
    req = x-y
    flag = 0
    for j in range(n):
        p,pri = map(int, stdin.readline().split())
        if(int(pri)<=k and int(p)>=req):
            flag = 1
    if(flag == 1):
        print("LuckyChef")
    else:
        print("UnluckyChef")
    