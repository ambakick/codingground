#include<bits/stdc++.h>

using namespace std;

struct Node{
    int data;
    struct Node* next;
    Node(int data){
        this->data = data;
        this->next = NULL;
    }
};

int main(void){
    Node *head = new Node(0);
    Node* cur = head;
    //cout<<head->next->data;
    for(int i=1;i<=5;i++){
        Node* n1 = new Node(i);
        
        cur->next = n1;
        cur = cur->next;
    }
    Node* one = head;
    for(int i=0;i<6;i++){
        cout<<one->data;
        one = one->next;
    }

}