import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, A, B, result, i;
		int G = 1; //최대공약수
		
		T = sc.nextInt();
		
		while(T-- > 0){
			A = sc.nextInt();
			B = sc.nextInt();
			
			//A, B를 동시에 나누어 떨어지게 하는 수중 가장 큰 수를 찾는다 (== 최대공약수)
			for(i = Math.min(A,B); !(A%i == 0 && B%i == 0 && i > 0); i-- );
			G = i;
			//A와 B를 곱한 뒤 최대공약수로 나눠주면 최소공배수가 된다
			result = (A * B) / G;
			System.out.println(result);
		}//end while
	}
}
