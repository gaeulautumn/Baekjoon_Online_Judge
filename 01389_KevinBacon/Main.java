import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N, M; //유저의수, 친구관계의수
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		Graph graph = new Graph(N, M);
		graph.findPath(N);
		graph.printGraph(N);
		
		System.out.println(graph.findMin(N));
	}
}
