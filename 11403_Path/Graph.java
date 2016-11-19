import java.util.Scanner;

public class Graph {
	int[][] graph;
	Scanner sc = new Scanner(System.in);
	
	Graph(int N){
		graph = new int[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				graph[i][j] = sc.nextInt();
			}
		}
	}
	

	void findPath(int N){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				for(int k = 0; k < N; k++){
					if(graph[j][i] == 1 && graph[i][k] == 1)
						graph[j][k] = 1;
				}
			}
		}
	}
	
	void printGraph(int N){
		for(int i = 0; i < N; i++){
			System.out.print("\n");
			for(int j = 0; j < N; j++){
				System.out.print(graph[i][j] + " ");
			}
		}
	}
}
