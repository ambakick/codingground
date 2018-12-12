def check(str):
    l=int(0)
    r=int(len(str)-1)
    #print(r)
    flag = int(0)
    x=int(1)
    while(l!=r and flag==0):
        if str[l] == str[r] and (str[l]==x):
            if(str[l+1])==x+1:
                x=x+1
            #print(x)
        else:
            flag=1
        l = l+1
        r = r-1
    if(l==r):
        if(str[l]!=x and str[l]!=x+1):
            flag=1
    #print(flag)
    if flag==1:
        return False
    else:
        return True

t = int (input())
for i in range(t):
    n = int(input())
    a = list(map(int,input().strip().split(" ")))
    if(check(a)):
        print("yes")
    else:
        print("no")