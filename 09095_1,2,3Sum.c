#include <stdio.h>

void recurSum(int n, int sum);

int count = 0;

int main(){
	int T = 0, n = 0;
	
	scanf("%d",&T); //Test Case

	while(T--){
		scanf("%d",&n);
		recurSum(n, 0);
		printf("%d\n", count);
		count = 0;
	}
	
	return 0;
}

void recurSum(int n, int sum){
	if(sum == n){
		count++;
		return;
	}
	if(sum > n)return;

	recurSum(n, sum+1);
	recurSum(n, sum+2);
	recurSum(n, sum+3);
}

/* rf
        int[] nums = new int[12];
        
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 4;
        
        for(int i = 4 ; i <= 11; i++){        
            for(int j = 1; j <= 3; j++)
            {
                nums[i] += nums[i-j];
            }
        }
        


출처: http://minemi.tistory.com/52 
*/