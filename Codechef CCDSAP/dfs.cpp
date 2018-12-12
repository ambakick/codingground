#include<bits/stdc++.h>
using namespace std;
#define ROW 5;
#define COL 5;
list <int> *adj;
int COL;
void dfs(int M[][COL], bool visited[][COL],int row,int col){
    static int rw[]={-1,-1,-1,0,0,1,1,1};
    static int cl[]={-1,0,1,1,-1,-1,0,1};
    visited[row][col]=1;
    for(int i=0;i<8;i++)
    {
        if(isSafe(M,visited, row+rw[i], col+cl[i])){
            dfs(M,visited,row+rw[i],col+cl[i]);
        }
    }
}
void count1(int M[][COL]){
    bool visited[ROW][COL];
    memset(visited, 0, sizeof(visited));

    int count = 0;
    for (int i=0;i <ROW;i++)
    {
        for(int j=0;j<COL;j++)
        {

        }
    }
}
int main(void){
    COL = 5;
    int M[][COL]= {  {1, 1, 0, 0, 0}, 
        {0, 1, 0, 0, 1}, 
        {1, 0, 0, 1, 1}, 
        {0, 0, 0, 0, 0}, 
        {1, 0, 1, 0, 1} 
    count1(M);
}