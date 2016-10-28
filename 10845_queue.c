#pragma warning(disable: 4996)
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void init(int _size);
void push(int _size, int x);
int pop();
int size();
int front();
int back();
int empty();


int *queue;          //ť
int _front, _back;   //


int main() {

	int N,             //����� �� (1~10,000)
		x,             //ť�� ������ ����
		_size,         //ť�� ũ��
	    index = 0;     //��¹迭�� �ε���
	int *output;       //����� ����

	char command[10];     //��ɾ�

	scanf("%d", &N);   //��ɾ� ���� �Է¹���
	if (N < 1 || N>10000)return;  //���ܹ���ó��

	_size = N;
	init(_size);       //ť �ʱ�ȭ(ũ��� ��ɾ� ������ŭ)
	output = (int*)malloc(sizeof(int)*_size);  //��¹迭 �ʱ�ȭ

	while (N--) {
		scanf("%s", command);    //��ɾ� �б�

		if (strcmp(command, "push") == 0) {    //push X
			scanf("%d", &x);
			push(_size, x);
		}
		if (strcmp(command, "pop") == 0) {     //pop
			output[index++] = pop();
		}
		if (strcmp(command, "size") == 0) {    //size
			output[index++] = size();
		}
		if (strcmp(command, "empty") == 0) {   //empty
			output[index++] = empty();
		}
		if (strcmp(command, "front") == 0) {   //front
			output[index++] = front();
		}
		if (strcmp(command, "back") == 0) {    //back
			output[index++] = back();
		}
	}//end for

	for (int i = 0; i < index; i++) {
		printf("%d\n", output[i]);
	}

	return 0;
}

void init(int _size) {
	queue = (int*)malloc(sizeof(int)*_size);
	_front = 0;
	_back = 0;
}

void push(int _size, int x) {
	if (_back == _size) {
		//ť�� ��á��
		return;
	}

	queue[_back++] = x;
}

int pop() {
	if (empty()) return -1;  //ť����������� -1 ���

	return queue[_front--];  //����տ��ִ� ���� ���
}

int size() {
	return (_back - _front); //ť�� ����ִ� ������ ����
}

int front() {
	if (empty()) return;
	return queue[_front];    //ù��° ����
}

int back() {
	if (empty()) return;
	return queue[_back - 1]; //������ ����
}

int empty() {
	if (_front == _back) return 1;  //ť����������� 1 ���
	else return 0;                  //�ƴϸ� 0 ���
}