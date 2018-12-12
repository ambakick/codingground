#include<bits/stdc++.h>
using namespace std;

int main(void)
{
    int t;
    cin>>t;
    for(int i=0;i<t;i++)
    {
        int n;
        cin>>n;
        int arr[n];
        for(int j=0;j<n;j++)
        {
            cin>>arr[j]
        }
        int l=0;
        int r = n-1;
        int flag=0;
        int x=1;
        while(l!=r){
            if(arr[l]==arr[r]&&(arr[l]==x))
            {
                if(arr[l+1]==x+1)
                x=x+1;
            }
            else
            {
                flag=1;
                break;
            }
        }
        if(n%2==1&&l==r){
            if(arr[l]!=x)
                flag =1;
        }
        if(flag==1)
            print("no")
        else
            print("yes")
    }
}