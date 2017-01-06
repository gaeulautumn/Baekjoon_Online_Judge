import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int[] visit;
		int F,S,G,U,D,count = 0;
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		visit = new int[F + 1];
		
		while((S != G) && (visit[S] == 0)){
			visit[S] = 1;
			if(S < G && S + U <= F){
				S += U;
				count++;
			}
			else if(S - D >= 1){
				S -= D;
				count++;
			}	
		}
		
		if(S == G) System.out.println(count);
		else System.out.println("use the stairs");
	}
}
