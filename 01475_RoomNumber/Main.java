import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int count[] = new int[10];
		
		for(int i = 0; i < N.length(); i++){
			count[N.charAt(i) - '0']++;
		}
		
		count[6] = count[9] = (count[6] + count[9])/2 + (count[6] + count[9])%2;
		
		//�ִ밪
		int max = count[0];
		for(int i = 1; i < 10; i++){
			if(count[i] > max) max = count[i];
		}
		System.out.println(max);

	}

}
