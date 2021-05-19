package threads;



class SortedLists implements Runnable{
	private static int index = 0; 
	private Integer [] array; 
	
	public void diplay() {
		for( int i = 0; i < array.length; i++) {
			System.out.println("index: " + i + " value: " + array[i]);
		}
	}
	
	Integer[] getList() { return array; }
	 
	SortedLists(Integer [] list, int size ){
		
		
		Integer [] array = new Integer[size]; 
		
		int count = 0; 
		size += index; 
		
		while( index < size) {
			
			array [count++] = list[ index++];  
			
		}
		
		
		 this.array = array;
	}
	
	
	@Override
	public void run() {
		
		for(int i = 0; i < array.length; i++){ 
            int victim = array[i];
            int j = i-1;
    
            while(j >= 0 && array[j] > victim){
                array[j + 1] = array[j];
                j = j-1;
            }
            array[j+1] = victim;
        }
		
		
		
		
	}
	
	
	
	public static SortedLists [] create( Integer [] array, int size, int numberOfThreads ) {

		int listSize = 0; 
		boolean oddFlag = false; 
		SortedLists [] tempList = new SortedLists [numberOfThreads]; 
	
		listSize = size / numberOfThreads; 

		if ( size % 2 != 0 )
			oddFlag = true; 
		

		for( int i = 0; i < numberOfThreads; i++) {
			
			if( i == numberOfThreads - 1 && oddFlag == true)
				listSize++; 
	
			tempList[i] = new SortedLists(array, listSize);

		}

		
		return tempList; 
	}

	
}