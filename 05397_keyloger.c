#pragma warning(disable: 4996)
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_LENGTH 1000001    //최대문자열길이

typedef struct node node;
struct node{
	char c;   //문자
	node *left; 
	node *right;
};
node *cursor;

void init(node *head);
void backward(node *head);
void forward(node *head);
void insert(node *head, char c);
void delete(node *head);
int empty(node *head);

int main() {

	int N;
	char input[MAX_LENGTH];
	node *head;

	scanf("%d", &N);
	while(N--) {
		//링크드리스트의 헤드 초기화
		head = (node*)malloc(sizeof(node));
		init(head);
		scanf("%s", input);

		for (int i = 0; input[i]; i++) {
			switch (input[i]) {
			case '<':
				backward(head);
				break;
			case '>':
				forward(head);
				break;
			case '-':
				delete(head);
				break;
			default:  //일반문자들
				insert(head, input[i]);
				break;
			}
		}
		//리스트출력
		cursor = head;
		while (cursor->right != NULL) {
			cursor = cursor->right;
			printf("%c", cursor->c);
		}
		printf("\n");
		free(head);
	}//end while
	return 0;
}


void init(node *head) {
	cursor = (node*)malloc(sizeof(node));

	head->left = head->right = NULL;
	cursor = head;
}

void backward(node *head) {
	if (empty(head))return;
	cursor = cursor->left;
}


void forward(node *head) {
	if (empty(head) || cursor->right==NULL )return;
	cursor = cursor->right;
}

void insert(node *head, char c) {  //커서 다음(right)에 노드를 삽입
	node *new = (node*)malloc(sizeof(node));

	new->c = c;
	new->right = cursor->right;
	new->left = cursor;
	if (cursor->right != NULL) 
		cursor->right->left = new;
	cursor->right = new;
	cursor = new;
}

void delete(node *head) { //커서가 가리키는 노드를 삭제
	if (empty(head))return;

	node *temp = (node*)malloc(sizeof(node));
	temp = cursor;
	temp->left->right = temp->right;
	if(cursor->right != NULL)
		temp->right->left = temp->left;
	cursor = temp->left;
	free(temp);
}

int empty(node *head) {
	if (head->right == NULL) return 1; //리스트가 비었으면 1반환
	else return 0;  //아니면 0
}

