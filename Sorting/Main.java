	
public class Main {
	public static void main(String[] args) {
		int[] original = {25, 5, 37, 1, 61, 11, 59, 15, 48, 19};
		Sort sorting = new Sort();
		
		System.out.println("------------- Insertion Sort -------------");
		sorting.insertionSort(original);
		
		System.out.println("--------------- Quick Sort ---------------");
		sorting.quickSort(original);
		
		System.out.println("--------------- Merge Sort ---------------");
		sorting.mergeSort(original);
	}
}
class Sort{
	int[] list = new int[10];
	int comparison = 0;        //비교횟수
	
	void insertionSort(int[] original){
		System.arraycopy(original, 0, list, 0, original.length);  //배열복사
		int next, i, j;
		comparison = 0;  //비교횟수 초기화
		
		for(i = 1; i < list.length; i++){	
			next = list[i];
			for(j = i-1; j >= 0 && next < list[j]; j--){
				comparison++;        //비교횟수증가
				list[j+1] = list[j];
			}//end for
			list[j+1] = next;   
			printList(list, 0, list.length);  //중간출력
		}//end for
		
		//최종출력
		System.out.println();
		printList(list, 0, list.length); 
		System.out.println("   Total number of comparison : " + comparison);
		System.out.println();
	}
	
	void quickSort(int[] original){
		System.arraycopy(original, 0, list, 0, original.length); //배열복사
		comparison = 0;    //비교횟수 초기화
		
		recursiveQuickSort(0, list.length-1 );
		
		//최종출력
		System.out.println();
		printList(list, 0, list.length);  
		System.out.println("   Total number of comparison : " + comparison);
		System.out.println();
	}
	
	void recursiveQuickSort(int left, int right){	
		if(left < right){
			int j = partition(left, right);
			recursiveQuickSort(left, j-1);
			recursiveQuickSort(j+1, right);	
		}
	}
	
	int partition(int left, int right){
		int i = left, j = right + 1, temp;
		int pivot = list[left];   //가장왼쪽원소를 기준으로 
		
		//pivot과 비교하여 더 작은것은 왼쪽, 큰것은 오른쪽에 오도록
		while(i < j){
			while(list[++i] < pivot)comparison++;  //비교횟수증가
			while(list[--j] > pivot)comparison++;
			if(i<j){		
				temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}//end if
		}//end while
		
		//pivot과 중간인덱스(j)값을 swap
		temp = list[left];
		list[left] = list[j];
		list[j] = temp;
		
		printList(list, left, right+1);  //중간출력
		return j;
		
	}
	
	void mergeSort(int[] original){
		System.arraycopy(original, 0, list, 0, original.length);  //배열복사
		comparison = 0;   //비교횟수 초기화
		
		recursiveMergeSort(0, list.length-1);
		
		//최종출력
		System.out.println();
		printList(list, 0, list.length);  
		System.out.println("   Total number of comparison : " + comparison);
		System.out.println();
	}
	
	void recursiveMergeSort(int left, int right){
		if(left < right){
			int mid = (left + right) / 2;		
			//두 부분으로 나눔
			recursiveMergeSort(left, mid);
			recursiveMergeSort(mid + 1, right);
			
			//나뉜 부분을 합병
			merge(left, mid, right);
		}
	}
	
	void merge(int left, int mid, int right){
		int[] temp = new int[list.length];
		int i = left, j = mid + 1, k = left, n;
	
		//두 부분을 비교해서 더 작은 원소를 temp배열에 차례로 삽입
		while(i <= mid && j <= right){
			if(list[i] <= list[j])temp[k++] = list[i++];
			else                  temp[k++] = list[j++];
			comparison++;  //비교횟수증가
		}
		//남은부분처리
		if(i > mid) for(n = j; n <= right; n++) temp[k++] = list[n];
		else for(n = i; n <= mid; n++) temp[k++] = list[n];
		
		//temp를 list로 복사
		for(n = left; n <= right; n++)list[n] = temp[n];
		printList(list, left, right+1);   //중간출력
	}
	
	
	//배열출력
	void printList(int[] sortedList, int left, int right){
		for(int i = 0; i < left; i++){
			System.out.print("    ");
		}
		for(int i = left; i < right; i++){
			System.out.printf("%4d",sortedList[i]);
		}System.out.println();
	}
}
