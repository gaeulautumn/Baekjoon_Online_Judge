import java.util.Scanner;

public class PokemonMaster {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();   //���ϸ󰳼�(1~100,000)
		int M = sc.nextInt();   //������ҹ�����
		String name, findName;
		int num, findNum;
		
		MyHashMap hmap = new MyHashMap();
		
		//�Է¹޾Ƽ� �ؽø� �����
		for(int i = 1; i <= N; i++){
			name = sc.next();
			hmap.pushItem(name, i);
		}
		
		//�������ϱ�
		for(int i = 0; i < M; i++){
			name = sc.next();
			//�Է��� ������ ��� 
			if(name.charAt(0) < 58 && 47<name.charAt(0)){
				num = Integer.parseInt(name);
				findName = hmap.findName(num);
				System.out.println(findName);
			}
			//�Է��� ���ϸ� �̸�(���ڿ�)�� ���
			else{
				findNum = hmap.findNumber(name);
				System.out.println(findNum);
			}
		}//end for
	}//end main
}
