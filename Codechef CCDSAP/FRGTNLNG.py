t = int(input())

for i in range(t):
    n,k = map(int, input().split())
    dic = [x for x in input().split()]
    tot = []
    for j in range(k):
        temp = [x for x in input().split()]
        temp = temp[1:]
        tot.extend(temp)
    t1 = set(tot)
    for x in dic:
        if(any( x in s for s in t1)):
            print("YES", end =" ")
        else:
            print("NO", end =" ")
    print()