#pragma warning(disable: 4996)
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void push(int N, int x, int index);
int pop();
int empty();

typedef struct{
	int index;
	int num;
}element;

element *stack;
int _top = -1;

int main() {
	int N, t;
	int *output;

	scanf("%d", &N);   //��ɾ� ���� �Է¹���
	if (N < 1 || N>500000)return;  //���ܹ���ó��
	stack = (element*)malloc(sizeof(element)*N);  //�����ʱ�ȭ 
	output = (int*)malloc(sizeof(int)*N);

	for (int i = 0; i < N; i++) {
		scanf("%d", &t);

		while (empty()) {
			if (stack[_top].num > t) {		
				output[i] = stack[_top].index;
				push(N, t, i+1);
				break;
			}
			else {
				pop();
			}

		}
		if (!empty()) {//������ ������� ��
			output[i] = 0;
			push(N, t, i+1);
		}
	
	}//end for
	
	for (int i = 0; i < N; i++) {
		printf("%d ", output[i]);
	}



	return 0;
}

void push(int N, int x, int index) {
	if (_top + 1 == N) return; //���ò�á��


	stack[++_top].num = x;
	stack[_top].index = index;
}

int pop() {
	if (!empty()) return; //���ú������ 
	return stack[_top--].num;
}

int empty() {
	if (_top < 0) return 0;  //��������� 0 ��ȯ
	else return 1;           //�ƴϸ� 1 ��ȯ
}
