#include <stdio.h>
#pragma warning(disable:4996)

#define MAX 1000
#define FALSE 0
#define TRUE 1


int main() {
	int N = 0; // 100이하
	int num;
	int count = 0; //개수
	int prime_number[MAX + 1];

	//배열 초기화
	prime_number[1] = FALSE; //1은소수가아님
	for (int i = 2; i <= MAX; i++) 
		prime_number[i] = TRUE; //먼저 모두 TRUE로 초기화

	//소수가 아닌 것을 찾아 하나씩 FALSE로 지워나감
	for (int i = 2; i*i <= MAX; i++) {
		if (prime_number[i] == TRUE) {
			for (int j = i*i; j <= MAX; j += i) {
				prime_number[j] = FALSE;
			}
		}
	}

	scanf("%d", &N);
	while (N--) {
		scanf("%d", &num);
		if (prime_number[num] == TRUE)count++;
	}

	printf("%d", count);
	return 0;
}
