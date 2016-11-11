	
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
	int comparison = 0;        //��Ƚ��
	
	void insertionSort(int[] original){
		System.arraycopy(original, 0, list, 0, original.length);  //�迭����
		int next, i, j;
		comparison = 0;  //��Ƚ�� �ʱ�ȭ
		
		for(i = 1; i < list.length; i++){	
			next = list[i];
			for(j = i-1; j >= 0 && next < list[j]; j--){
				comparison++;        //��Ƚ������
				list[j+1] = list[j];
			}//end for
			list[j+1] = next;   
			printList(list, 0, list.length);  //�߰����
		}//end for
		
		//�������
		System.out.println();
		printList(list, 0, list.length); 
		System.out.println("   Total number of comparison : " + comparison);
		System.out.println();
	}
	
	void quickSort(int[] original){
		System.arraycopy(original, 0, list, 0, original.length); //�迭����
		comparison = 0;    //��Ƚ�� �ʱ�ȭ
		
		recursiveQuickSort(0, list.length-1 );
		
		//�������
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
		int pivot = list[left];   //������ʿ��Ҹ� �������� 
		
		//pivot�� ���Ͽ� �� �������� ����, ū���� �����ʿ� ������
		while(i < j){
			while(list[++i] < pivot)comparison++;  //��Ƚ������
			while(list[--j] > pivot)comparison++;
			if(i<j){		
				temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}//end if
		}//end while
		
		//pivot�� �߰��ε���(j)���� swap
		temp = list[left];
		list[left] = list[j];
		list[j] = temp;
		
		printList(list, left, right+1);  //�߰����
		return j;
		
	}
	
	void mergeSort(int[] original){
		System.arraycopy(original, 0, list, 0, original.length);  //�迭����
		comparison = 0;   //��Ƚ�� �ʱ�ȭ
		
		recursiveMergeSort(0, list.length-1);
		
		//�������
		System.out.println();
		printList(list, 0, list.length);  
		System.out.println("   Total number of comparison : " + comparison);
		System.out.println();
	}
	
	void recursiveMergeSort(int left, int right){
		if(left < right){
			int mid = (left + right) / 2;		
			//�� �κ����� ����
			recursiveMergeSort(left, mid);
			recursiveMergeSort(mid + 1, right);
			
			//���� �κ��� �պ�
			merge(left, mid, right);
		}
	}
	
	void merge(int left, int mid, int right){
		int[] temp = new int[list.length];
		int i = left, j = mid + 1, k = left, n;
	
		//�� �κ��� ���ؼ� �� ���� ���Ҹ� temp�迭�� ���ʷ� ����
		while(i <= mid && j <= right){
			if(list[i] <= list[j])temp[k++] = list[i++];
			else                  temp[k++] = list[j++];
			comparison++;  //��Ƚ������
		}
		//�����κ�ó��
		if(i > mid) for(n = j; n <= right; n++) temp[k++] = list[n];
		else for(n = i; n <= mid; n++) temp[k++] = list[n];
		
		//temp�� list�� ����
		for(n = left; n <= right; n++)list[n] = temp[n];
		printList(list, left, right+1);   //�߰����
	}
	
	
	//�迭���
	void printList(int[] sortedList, int left, int right){
		for(int i = 0; i < left; i++){
			System.out.print("    ");
		}
		for(int i = left; i < right; i++){
			System.out.printf("%4d",sortedList[i]);
		}System.out.println();
	}
}
