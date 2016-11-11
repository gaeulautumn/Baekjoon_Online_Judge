import java.util.Scanner;

public class PokemonMaster {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();   //포켓몬개수(1~100,000)
		int M = sc.nextInt();   //맞춰야할문제수
		String name, findName;
		int num, findNum;
		
		MyHashMap hmap = new MyHashMap();
		
		//입력받아서 해시맵 만들기
		for(int i = 1; i <= N; i++){
			name = sc.next();
			hmap.pushItem(name, i);
		}
		
		//문제답하기
		for(int i = 0; i < M; i++){
			name = sc.next();
			//입력이 숫자일 경우 
			if(name.charAt(0) < 58 && 47<name.charAt(0)){
				num = Integer.parseInt(name);
				findName = hmap.findName(num);
				System.out.println(findName);
			}
			//입력이 포켓몬 이름(문자열)일 경우
			else{
				findNum = hmap.findNumber(name);
				System.out.println(findNum);
			}
		}//end for
	}//end main
}
