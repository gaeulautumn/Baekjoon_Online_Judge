#pragma warning(disable: 4996)
#include <stdio.h>

#define MAX_LENGTH 1000001    //�ִ빮�ڿ�����

int main() {

	int N;
	char input[MAX_LENGTH], stack_1[MAX_LENGTH], stack_2[MAX_LENGTH];
	int top_1, top_2;

	scanf("%d", &N);

	while (N--) {
		top_1 = top_2 = -1;
		scanf("%s", input);

		for (int i = 0; input[i]; i++) {
			switch (input[i]) {
			case '<':  //������ ������� ���� ��� ����1���� �ϳ����� ����2��
				if (top_1 > -1) stack_2[++top_2] = stack_1[top_1--]; 
				break;
			case '>':
				if (top_2 > -1) stack_1[++top_1] = stack_2[top_2--];  
				break;
			case '-':
				if (top_1 > -1) stack_1[top_1--] = 0;
				break;
			default:  //�Ϲݹ��ڵ�
				stack_1[++top_1] = input[i];
				break;
			}//end switch
		}//end for

		while (top_2 > -1) stack_1[++top_1] = stack_2[top_2--];	
		stack_1[top_1+1] = 0;  
		puts(stack_1);
	}//end while
	return 0;
}