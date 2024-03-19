#include <stdio.h>
#include <stdlib.h>

struct node
{
    int value; // number of times we've seen key
    int key;   // number in the dataset
    struct node *next;
};

typedef struct node Node;

void add_item(Node *start, int new_val, int key);
int length(Node *start);
Node *delete_item(Node *start, int key);

int main(void)
{

    Node firstItem;
    firstItem.value = 0;
    firstItem.key = 12;
    firstItem.next = NULL;

    add_item(&firstItem, 0, 15);
    printf("%d\n", length(&firstItem));
    
    printf("hello");
    return 0;
}

void add_item(Node *start, int new_val, int key)
{
    Node *curr_item = start;
    while (curr_item->next != NULL)
    {
        curr_item = curr_item->next;
    }
    Node *new_item = malloc(sizeof(Node));
    new_item->value = new_val;
    new_item->key = key;
    new_item->next = NULL;
    curr_item->next = new_item;
    free(new_item);
}

int length(Node *start)
{
    int count;
    Node *curr_item;
    while (curr_item->next !=NULL)
    {
        curr_item = curr_item->next;
        count++;
    }
    return count;
}

Node *delete (Node *start, int key)
{
    Node *curr_item = start;
    while (curr_item->next != NULL)
    {
        if (curr_item->next->key == key)
        {
            curr_item->next = curr_item->next->next;
            return curr_item->next;
        }
        else
        {
            curr_item = curr_item->next;
        }
    }
    return NULL;
}