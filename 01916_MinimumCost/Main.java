import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final int INF = 100000000;
		boolean[] visit;  //방문여부체크
		int[] distance;   //최소거리
		int[][] costs;    //버스비용 저장(가중치)
		int n, m, start, end;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); //도시개수
		m = sc.nextInt(); //버스개수
		visit = new boolean[n+1];
		distance = new int[n+1];
		costs = new int[n+1][n+1];
		
		//거리 초기화
		//버스비용 무한대로 초기화(자기자신은 0)
		for(int i = 1; i <= n; i++){
			distance[i] = INF;
			for(int j = 1; j <= n; j++){
				costs[i][j] = (i == j)? 0 : INF;
			}
		}
		
		while(m-- > 0){
			int busStart = sc.nextInt();
			int busEnd = sc.nextInt();
			int busCost = sc.nextInt();
			if(busCost < costs[busStart][busEnd])
				costs[busStart][busEnd] = busCost;
		}
		
		start = sc.nextInt();
		end = sc.nextInt();
		
		//다익스트라 알고리즘
		distance[start] = 0; //시작점초기화
		for(int i = 0; i < n; i++){
			int min = INF+1;
			int index = -1;
			
			for(int j = 1; j <= n; j++){
				if(visit[j] == false && min > distance[j]){
					min = distance[j];
					index = j;
				}
			}//end for
			visit[index] = true;
			
			for(int j = 1; j <= n; j++){
				if((j != index) && (distance[j] > distance[index] + costs[index][j])){
					distance[j] = distance[index] + costs[index][j];
				}
			}
		}//end for
		
		System.out.println(distance[end]);

	}

}
