import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int red, green, blue, min;
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //집의개수(1~1000)
	
		int[][] cost = new int[3][N];
		
		cost[0][0] = sc.nextInt();
		cost[1][0]= sc.nextInt();
		cost[2][0] = sc.nextInt();
		
		for(int i = 1; i < N; i++){
			red = sc.nextInt();
			green = sc.nextInt();
			blue = sc.nextInt();		
			cost[0][i] = red + Math.min(cost[1][i-1], cost[2][i-1]);
			cost[1][i] = green + Math.min(cost[0][i-1], cost[2][i-1]);
			cost[2][i] = blue + Math.min(cost[0][i-1], cost[1][i-1]);
		}
		
		min = Math.min(Math.min(cost[0][N-1], cost[1][N-1]), cost[2][N-1]);
		System.out.println(min);
		
	}
}

	