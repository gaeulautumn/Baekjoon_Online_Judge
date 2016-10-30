#pragma warning(disable: 4996)
#include <stdio.h>

#define MAX_LENGTH 1000001    //최대문자열길이

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
			case '<':  //스택이 비어있지 않을 경우 스택1에서 하나꺼내 스택2로
				if (top_1 > -1) stack_2[++top_2] = stack_1[top_1--]; 
				break;
			case '>':
				if (top_2 > -1) stack_1[++top_1] = stack_2[top_2--];  
				break;
			case '-':
				if (top_1 > -1) stack_1[top_1--] = 0;
				break;
			default:  //일반문자들
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