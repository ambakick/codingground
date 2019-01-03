#include<bits/stdc++.h>

using namespace std;

struct node{
    int data;
    struct node* left;
    struct node* right;
    node(int data){
        this->data = data;
        this->left = NULL; 
        this->right = NULL;
    }
};
bool check_full(node* root){
    if(root == NULL){
        return false;
    }
    if (root->left == NULL && root->right == NULL) 
        return true; 
    if ((root->left) && (root->right)) 
        return (check_full(root->left) && check_full(root->right)); 
    //return ((!check_full(root->left)&&!check_full(root->right))||(check_full(root->left)&&check_full(root->right)));
    return false;
}
int main (void){
    struct node *root = new node(1);
    root->left	 = new node(2); 
    root->right	 = new node(3); 
    root->left->left = new node(4);
    root->left->right = new node(5);
    root->right->left = new node(6);
    root->right->right = new node(7); 
    root->left->left->left = new node(8);
    root->left->left->right = new node(9);
    root->right->right->right = new node(10);
    root->right->right->right->left = new node(11);
    printf("%d",check_full(root));
    return 0;
}