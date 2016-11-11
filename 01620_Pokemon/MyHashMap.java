import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MyHashMap {
	//LinkedHashMap을 사용하면 입력한 순서대로 원소들이 나열된다.
	Map<String, Integer> map = new LinkedHashMap<String, Integer>();

	//해시맵에 아이템을 추가하는 메소드
	public void pushItem(String name, int id){
		map.put(name, id);
	}
	
	//이름을 입력했을때 번호를 출력해주는 메소드
	public int findNumber(String name){
		return map.get(name);		
	}
	
	public String findName(int num){
		String myKey= "0";
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		//iterator를 사용해 처음부터 num번째까지 옮겨간다
		while(num-- > 0 && iter.hasNext()){
			myKey = iter.next();
		}
		//num번째까지 옮겨간 후의 key(name)값이 찾고자 하는 key(name)값이다.
		return myKey;
	}
	
}
