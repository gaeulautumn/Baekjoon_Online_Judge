import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		class Point{
			int x, y;
			
			Point(int x, int y){
				this.x = x;
				this.y = y;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		
		int N,M;
		ArrayDeque<Point> queue = new ArrayDeque<Point>(); //큐
		String temp;   //입력받기위한 배열
		int[][] maze;    //미로
		int[][] visit;   //방문순서, 방문여부표시
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		maze = new int[N][M];
		visit = new int[N][M];
		//temp = new String;
		
		for(int i = 0; i < N; i++){
			temp = sc.next();
			for(int j = 0; j < M; j++){
				maze[i][j] = temp.charAt(j) - '0';
			}
		}
		
		//시작점초기화
		Point start = new Point(0,0);
		queue.offer(start);
		visit[start.x][start.y] = 1;
		
		//BFS
		while(!queue.isEmpty()){
			Point cursor = queue.poll();
			
			//미로범위 안 & 길 있음 & 방문 전
			//위
			if(cursor.x - 1 >= 0 && maze[cursor.x - 1][cursor.y] == 1 && visit[cursor.x - 1][cursor.y] ==0){
				Point next = new Point(cursor.x - 1, cursor.y);
				queue.offer(next);  //큐에 넣음
				visit[next.x][next.y] += visit[cursor.x][cursor.y] + 1;
			}
			//왼쪽
			if(cursor.y - 1 >= 0 && maze[cursor.x][cursor.y - 1] == 1 && visit[cursor.x][cursor.y - 1] ==0){
				Point next = new Point(cursor.x, cursor.y - 1);
				queue.offer(next);  //큐에 넣음
				visit[next.x][next.y] += visit[cursor.x][cursor.y] + 1;
			}
			//아래
			if(cursor.x + 1 < N && maze[cursor.x + 1][cursor.y] == 1 && visit[cursor.x + 1][cursor.y] ==0){
				Point next = new Point(cursor.x + 1, cursor.y);
				queue.offer(next);  //큐에 넣음
				visit[next.x][next.y] += visit[cursor.x][cursor.y] + 1;
			}
			//오른쪽
			if(cursor.y + 1 < M && maze[cursor.x][cursor.y + 1] == 1 && visit[cursor.x][cursor.y + 1] ==0){
				Point next = new Point(cursor.x, cursor.y + 1);
				queue.offer(next);  //큐에 넣음
				visit[next.x][next.y] += visit[cursor.x][cursor.y] + 1;
			}
			
		}//end while
		
		System.out.println(visit[N-1][M-1]);

	}
	
}
