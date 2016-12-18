#include <stdio.h>
#pragma warning(disable:4996)

#define MAX 1000
#define FALSE 0
#define TRUE 1


int main() {
	int N = 0; // 100����
	int num;
	int count = 0; //����
	int prime_number[MAX + 1];

	//�迭 �ʱ�ȭ
	prime_number[1] = FALSE; //1���Ҽ����ƴ�
	for (int i = 2; i <= MAX; i++) 
		prime_number[i] = TRUE; //���� ��� TRUE�� �ʱ�ȭ

	//�Ҽ��� �ƴ� ���� ã�� �ϳ��� FALSE�� ��������
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
