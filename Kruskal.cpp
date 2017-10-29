#include<bits/stdc++.h>

using namespace std;

const int MAX=1e6+5;
pair<long long,pair<long long,long long>>adj[MAX];
int id[MAX],nodes,edges;

void initialize()
{
    for(int i=0;i<MAX;i++)
    {
        id[i]=i;
    }
}
int root(int x)
{
    if(x==id[x])
        return x;

    return id[x]=root(id[x]);

}
void join(int x,int y)
{
    int p=root(x);
    int q=root(y);
    id[p]=id[q];
}
long long Kruskal()
{
    int x,y;
    
    long long cost=0,mincost=0;
    for(int i=0;i<edges;i++)
    {
        x=adj[i].second.first;
        y=adj[i].second.second;
        cost=adj[i].first;
        //cout<<cost<<endl;
        if(root(x)!=root(y))
        {
            mincost+=cost;
            join(x,y);
        }
    }
    return mincost;
}



int main(void)
{
    initialize();
    cin>>nodes>>edges;
    for(int i=0;i<edges;i++)
    {
        int x,y,weight;
        cin>>x>>y>>weight;
        adj[i]=make_pair(weight,make_pair(x,y));
    }
    sort(adj,adj+edges);
    cout<<Kruskal();
}
