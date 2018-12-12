t = int(input())

for i in range(t):
    n,c = map(int, input().split())
    a = [int(x) for x in input().split()]
    for j in a:
        c = c-j
    if(c<0):
        print("No")
    else:
        print("Yes")
