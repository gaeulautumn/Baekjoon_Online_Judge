import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();  //�����ǰ���
		
		Graph graph = new Graph(N);
		
		graph.findPath(N);
		graph.printGraph(N);
	}
}
