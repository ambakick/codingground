t = int(input())
for i in range(t):
    n = input()
    a = [int(x) for x in input().split()]
    j = sum(a)-min(a)*len(a)
    print(j)