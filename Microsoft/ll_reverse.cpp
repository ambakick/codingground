#include<bits/stdc++.h>

using namespace std;

struct Node{
    int data;
    struct Node* next;
    Node(int data){
        this->data = data;
        this->next = NULL;
    }
}
int main(void){
    Node *head = Node(5);
    cout<<head.data;

}