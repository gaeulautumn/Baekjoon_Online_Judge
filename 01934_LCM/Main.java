import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, A, B, result, i;
		int G = 1; //�ִ�����
		
		T = sc.nextInt();
		
		while(T-- > 0){
			A = sc.nextInt();
			B = sc.nextInt();
			
			//A, B�� ���ÿ� ������ �������� �ϴ� ���� ���� ū ���� ã�´� (== �ִ�����)
			for(i = Math.min(A,B); !(A%i == 0 && B%i == 0 && i > 0); i-- );
			G = i;
			//A�� B�� ���� �� �ִ������� �����ָ� �ּҰ������ �ȴ�
			result = (A * B) / G;
			System.out.println(result);
		}//end while
	}
}
