#include <stdio.h>
#include <stdlib.h>
#define MAX_N 1000

 
void PreOrder(char *tree, int index);   //전위순회
void InOrder(char *tree, int index);    //중위순회
void PostOrder(char *tree, int index);  //후위순회
int Search(char *tree, char data);

int main() {
	int N, index;
	char data;
	char tree[MAX_N + 1] = {'\0', };

	scanf("%d", &N); //N: 1~26
	
	//트리만들기
	for(int i = 1; i <= N; i++){
		scanf(" %c", &data);

		index = Search(tree, data); //해당문자가있는 인덱스를찾음
		if (index == 0) {  //배열에 해당문자가 없을때(root를뜻함)
			index = 1;
			tree[index] = data;
		}

		scanf(" %c", &data);
		if (data == '.');
		else tree[2 * index] = data;

		scanf(" %c", &data);
		if (data == '.');
		else tree[2 * index + 1] = data;
	}
	
	PreOrder(tree, 1);
	printf("\n");
	InOrder(tree, 1);
	printf("\n");
	PostOrder(tree, 1);
	printf("\n");
	return 0;
}

void PreOrder(char *tree, int index) {
	if (tree[index] != '\0') {
		printf("%c", tree[index]);
		PreOrder(tree, 2 * index);
		PreOrder(tree, 2 * index + 1);
	}
}

void InOrder(char *tree, int index) {
	if (tree[index] != '\0') {
		InOrder(tree, 2 * index);
		printf("%c", tree[index]);
		InOrder(tree, 2 * index + 1);
	}
}

void PostOrder(char *tree, int index) {
	if (tree[index] != '\0') {
		PostOrder(tree, 2 * index);	
		PostOrder(tree, 2 * index + 1);
		printf("%c", tree[index]);
	}
}

int Search(char *tree, char data) {
	int index = 0;

	if (tree[1] == '\0')return 0;  //트리가비었을때 0반환
	//배열을 돌며 해당 문자를 찾음
	while (index++ <= MAX_N) 	
		if (tree[index] == data) return index;

}