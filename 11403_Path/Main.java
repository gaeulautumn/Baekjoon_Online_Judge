import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();  //정점의개수
		
		Graph graph = new Graph(N);
		
		graph.findPath(N);
		graph.printGraph(N);
	}
}
