import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MyHashMap {
	//LinkedHashMap�� ����ϸ� �Է��� ������� ���ҵ��� �����ȴ�.
	Map<String, Integer> map = new LinkedHashMap<String, Integer>();

	//�ؽøʿ� �������� �߰��ϴ� �޼ҵ�
	public void pushItem(String name, int id){
		map.put(name, id);
	}
	
	//�̸��� �Է������� ��ȣ�� ������ִ� �޼ҵ�
	public int findNumber(String name){
		return map.get(name);		
	}
	
	public String findName(int num){
		String myKey= "0";
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		//iterator�� ����� ó������ num��°���� �Űܰ���
		while(num-- > 0 && iter.hasNext()){
			myKey = iter.next();
		}
		//num��°���� �Űܰ� ���� key(name)���� ã���� �ϴ� key(name)���̴�.
		return myKey;
	}
	
}
