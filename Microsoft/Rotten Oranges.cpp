//
#include<bits/stdc++.h>
using namespace std;


int main(void){
    int t;
    cin>>t;
    for (int i=0;i<t;i++)
    {
    int N,C;
    cin>>N>>C;
    int arr[N][C];
    memset(arr, 0, sizeof(arr[0][0]) * N * C);
    queue <pair<int,int> > to_pop;
    for(int i=0;i<N;i++){
        for(int j=0;j<C;j++){
            cin>>arr[i][j];
            if(arr[i][j]==2){
                to_pop.push(make_pair(i,j));
            }
        }
    }
    
    to_pop.push(make_pair(-1,-1));
    int time = 0;
    while(!to_pop.empty()){
        //cout<<to_pop.size()<<endl;
        pair<int,int>m = to_pop.front();
        //cout<<m.first<<endl;
        to_pop.pop();
        if(m.first == -1){
            if(to_pop.size()==0)
            break;
            else{
            time++;
            to_pop.push(make_pair(-1,-1));
            }
        }
        else{
            int i = m.first;
            int j = m.second;
            if(i-1>=0){
                if(arr[i-1][j]==1){ arr[i-1][j]=2;
                to_pop.push(make_pair(i-1,j));
                }
            }
            if(j-1>=0){
                if(arr[i][j-1]==1){ arr[i][j-1]=2;
                to_pop.push(make_pair(i,j-1));
                }
            }
            if(j+1<C){
                if(arr[i][j+1]==1){ arr[i][j+1]=2;
                to_pop.push(make_pair(i,j+1));
                }
            }
            if(i+1<N){
                if(arr[i+1][j]==1){ arr[i+1][j]=2;
                to_pop.push(make_pair(i+1,j));
                }
            }
        }
        //cout<<"hi"<<endl;
    }
    int flag = 0;
    for(int k=0;k<N;k++){
        for(int j=0;j<C;j++){
            //cout<<arr[k][j]<<" ";
            if(arr[k][j]==1){
                flag = 1;
                break;
            }
        }
        //cout<<endl;
    }
    //cout<<"flag "<<flag<<endl;
    if(flag == 1){
        cout<<"-1"<<endl;
    }
    else
    cout<<time<<endl;
    }
    return 0;
}
