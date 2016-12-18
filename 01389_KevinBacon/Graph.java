import java.util.Scanner;

public class Graph {
	int[][] graph;
	Scanner sc = new Scanner(System.in);
	
	//그래프생성
	Graph(int N, int M){
		int x, y;
		graph = new int[N+1][N+1];
		
       for(int i = 1 ; i <= N; i++){
            for(int j = 1 ; j <= N; j++){
                if(i==j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = 999;
            }
        }
		
		while(M-- > 0){
			x = sc.nextInt();
			y = sc.nextInt();
			graph[x][y] = graph[y][x] = 1;
		}
	}
	
	void findPath(int N){
		
		for(int k = 1; k <= N; k++){
			for(int i = 1; i <= N; i ++){
				for(int j = 1; j <= N; j++){
					if(graph[i][j] > graph[i][k] + graph[k][j])
						graph[i][j] = graph[i][k] + graph[k][j];
				}
			}
		}	
	}
	//graph[i][j] == 0 && graph[i][k] > 0 && graph[k][j] > 0
	int findMin(int N){
		int index = 0, min = 0, sum;
		
		for(int i = 1; i <= N; i ++){
			sum = 0;
			for(int j = 1; j <= N; j++){
				sum += graph[i][j];
			}
			if(min == 0 || min > sum) {
				min = sum;
				index = i;
			}
		}
		return index;
	}
	
	void printGraph(int N){
		for(int i = 1; i <= N; i ++){
			for(int j = 1; j <= N; j++){
				System.out.print(graph[i][j] + " ");
				}
			System.out.println("");
		}
	}

}
