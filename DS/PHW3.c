#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define RMAX 100

typedef struct node
{
    int data;
    struct node *left,*right;
    int ht;
}node;
 
node *insert(node *,int);
void preorder(node *);
void inorder(node *);
void postorder(node *);
int height( node *);
node *rotateright(node *);
node *rotateleft(node *);
node *RR(node *);
node *LL(node *);
node *LR(node *);
node *RL(node *);
int BF(node *);


int main() {
    int list[200];
    list[0] = 15;
    list[1] = 50;

    srand(time(NULL));
    for (int i = 0; i < 198; i++) {
    int random_no = 1 + (int) rand() % RMAX;
    list[i+2] = random_no;
    }
    
    node *root = NULL;
    root = NULL;
    for (int i = 0; i < 50; i++) {
        root = insert(root, list[i]);
    }
    
    printf("\nPreorder\n");
    preorder(root);
    printf("\nInorder\n");
    inorder(root);
    printf("\nPostorder\n");
    postorder(root);

    //traverse까지만 구현함.. search는 나중에 혼자서 꼭 해보자

    return 0;
}

node * insert(node *T,int x)
{
if(T==NULL)
    {
    T=(node*)malloc(sizeof(node));
    T->data=x;
    T->left=NULL;
    T->right=NULL;
    }
else if(x > T->data) // insert in right subtree
    {
    T->right=insert(T->right,x);
    if(BF(T)==-2)
        if(x>T->right->data)
            T=RR(T);
        else
            T=RL(T);
    }
else if(x<T->data)
    {
    T->left=insert(T->left,x);
    if(BF(T)==2)
        if(x < T->left->data)
            T=LL(T);
        else
            T=LR(T);
    }

T->ht=height(T);
return(T);
}
 
 
int height(node *T)
{
int lh,rh;
if(T==NULL)
return(0);
if(T->left==NULL)
lh=0;
else
lh=1+T->left->ht;
if(T->right==NULL)
rh=0;
else
rh=1+T->right->ht;
if(lh>rh)
return(lh);
return(rh);
}
 
node * rotateright(node *x)
{
node *y;
y=x->left;
x->left=y->right;
y->right=x;
x->ht=height(x);
y->ht=height(y);
return(y);
}
 
node * rotateleft(node *x)
{
node *y;
y=x->right;
x->right=y->left;
y->left=x;
x->ht=height(x);
y->ht=height(y);
return(y);
}
 
node * RR(node *T)
{
T=rotateleft(T);
return(T);
}
 
node * LL(node *T)
{
T=rotateright(T);
return(T);
}
 
node * LR(node *T)
{
T->left=rotateleft(T->left);
T=rotateright(T);
return(T);
}
 
node * RL(node *T)
{
T->right=rotateright(T->right);
T=rotateleft(T);
return(T);
}
 
int BF(node *T)
{
int lh,rh;
if(T==NULL)
return(0);
 
if(T->left==NULL)
lh=0;
else
lh=1+T->left->ht;
 
if(T->right==NULL)
rh=0;
else
rh=1+T->right->ht;
 
return(lh-rh);
}
 
void preorder(node *T)
{
if(T!=NULL)
{
printf("%d(Bf=%d)",T->data,BF(T));
preorder(T->left);
preorder(T->right);
}
}
 
void inorder(node *T)
{
if(T!=NULL)
{
inorder(T->left);
printf("%d(Bf=%d)",T->data,BF(T));
inorder(T->right);
}
}

void postorder(node *T)
{
    if(T!=NULL)
    {
        postorder(T->left);
        postorder(T->right);
        printf("%d(Bf=%d)",T->data,BF(T));
    }
}