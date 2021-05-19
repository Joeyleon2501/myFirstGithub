package threads;

public class MergeList implements Runnable{

	Integer [] mergedList; 
	SortedLists [] list; 
	
	MergeList(Integer [] list){
		
		mergedList = list; 
		
	}
	
	public void setList( SortedLists [] list) {
		this.list = list; 
	}
	
	public void display() {
		
		for( int i = 0; i < mergedList.length; i++) {
			System.out.println("index: " + i + " value: " + mergedList[i]);
		}
	}
	
	@Override
	public void run() {

		int size = 0;
		Integer [] temp = list[0].getList();

		for( int i = 1; i < list.length; i++) {
			
				size = temp.length + list[i].getList().length;
				temp = merge(temp, list[i].getList(), size );
				
			}
		
			mergedList = temp; 
		}
	
	
	
	private Integer [] merge(Integer [] left, Integer [] right, int size) {
		
		
		
		Integer [ ] temp = new Integer [size];
		int k =0;
		int i = 0;
		int j = 0;
		
		while( i < left.length && j < right.length) {
			
			if( left[i] <= right[j]) 
				temp[k++] = left[i++]; 
			else 
				temp[k++] = right[j++]; 
		}

			while(i < left.length) 
				temp[k++] = left[i++];
			
			while(j < right.length) 	
				temp[k++] = right[j++];

		return temp;
	
	}

}
