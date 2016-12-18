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
		ArrayDeque<Point> queue = new ArrayDeque<Point>(); //ť
		String temp;   //�Է¹ޱ����� �迭
		int[][] maze;    //�̷�
		int[][] visit;   //�湮����, �湮����ǥ��
		
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
		
		//�������ʱ�ȭ
		Point start = new Point(0,0);
		queue.offer(start);
		visit[start.x][start.y] = 1;
		
		//BFS
		while(!queue.isEmpty()){
			Point cursor = queue.poll();
			
			//�̷ι��� �� & �� ���� & �湮 ��
			//��
			if(cursor.x - 1 >= 0 && maze[cursor.x - 1][cursor.y] == 1 && visit[cursor.x - 1][cursor.y] ==0){
				Point next = new Point(cursor.x - 1, cursor.y);
				queue.offer(next);  //ť�� ����
				visit[next.x][next.y] += visit[cursor.x][cursor.y] + 1;
			}
			//����
			if(cursor.y - 1 >= 0 && maze[cursor.x][cursor.y - 1] == 1 && visit[cursor.x][cursor.y - 1] ==0){
				Point next = new Point(cursor.x, cursor.y - 1);
				queue.offer(next);  //ť�� ����
				visit[next.x][next.y] += visit[cursor.x][cursor.y] + 1;
			}
			//�Ʒ�
			if(cursor.x + 1 < N && maze[cursor.x + 1][cursor.y] == 1 && visit[cursor.x + 1][cursor.y] ==0){
				Point next = new Point(cursor.x + 1, cursor.y);
				queue.offer(next);  //ť�� ����
				visit[next.x][next.y] += visit[cursor.x][cursor.y] + 1;
			}
			//������
			if(cursor.y + 1 < M && maze[cursor.x][cursor.y + 1] == 1 && visit[cursor.x][cursor.y + 1] ==0){
				Point next = new Point(cursor.x, cursor.y + 1);
				queue.offer(next);  //ť�� ����
				visit[next.x][next.y] += visit[cursor.x][cursor.y] + 1;
			}
			
		}//end while
		
		System.out.println(visit[N-1][M-1]);

	}
	
}
