import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final int INF = 100000000;
		boolean[] visit;  //�湮����üũ
		int[] distance;   //�ּҰŸ�
		int[][] costs;    //������� ����(����ġ)
		int n, m, start, end;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); //���ð���
		m = sc.nextInt(); //��������
		visit = new boolean[n+1];
		distance = new int[n+1];
		costs = new int[n+1][n+1];
		
		//�Ÿ� �ʱ�ȭ
		//������� ���Ѵ�� �ʱ�ȭ(�ڱ��ڽ��� 0)
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
		
		//���ͽ�Ʈ�� �˰���
		distance[start] = 0; //�������ʱ�ȭ
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
