import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final int INF = 9999;
		Scanner sc = new Scanner(System.in);
		
		int[][] graph;
		int V, E, K;
		int u, v, w;
		
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		
		//배열초기화
		graph = new int[V+1][V+1];
		for(int i = 1; i <= V; i++){
			for(int j = 1; j <= V; j++){
				if(i == j) graph[i][j] = 0;
				else graph[i][j] = INF;
			}
		}
		
		while(E-- > 0){
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();
			graph[u][v] = w;
		}
		
		for(int k = 1; k <= V; k++){
			for(int i = 1; i <= V; i++){
				for(int j = 1; j <= V; j++){
					if(graph[i][k] + graph[k][j] < graph[i][j]){
						graph[i][j] = graph[i][k] + graph[k][j];
					}
					
				}
			}
		}
		
		for(int i = 1; i <= V; i++){
			if(graph[K][i] == INF)System.out.println("INF");
			else System.out.println(graph[K][i]);
		}

	}

}
