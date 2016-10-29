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


int *queue;          //큐
int _front, _back;   //


int main() {

	int N,             //명령의 수 (1~10,000)
		x,             //큐에 삽입할 정수
		_size,         //큐의 크기
	    index = 0;     //출력배열의 인덱스
	int *output;       //출력할 내용

	char command[10];     //명령어

	scanf("%d", &N);   //명령어 갯수 입력받음
	if (N < 1 || N > 10000)return;  //예외범위처리

	_size = N;
	init(_size);       //큐 초기화(크기는 명령어 갯수만큼)
	output = (int*)malloc(sizeof(int)*_size);  //출력배열 초기화

	while (N--) {
		scanf("%s", command);    //명령어 읽기

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
		//큐가 꽉찼음
		return;
	}

	queue[_back++] = x;
}

int pop() {
	if (empty()) return -1;  //큐가비어있으면 -1 출력
	return queue[_front++];  //가장앞에있는 원소 출력
}

int size() {
	return (_back - _front); //큐에 들어있는 원소의 갯수
}

int front() {
	if (empty()) return -1;
	return queue[_front];    //첫번째 원소
}

int back() {
	if (empty()) return -1;
	return queue[_back - 1]; //마지막 원소
}

int empty() {
	if (_front == _back) return 1;  //큐가비어있으면 1 출력
	else return 0;                  //아니면 0 출력
}