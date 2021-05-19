package threads;

import java.util.Random;



public class Main {

	public static void main(String[] args) {
		int size = 200; 
		Integer [] array = new Integer[size];
		MergeList merged; 
		Random rand = new Random(); 
	    int upperbound = size * 2;
	    int numberOfThreads = 20;  
	    SortedLists [] tempList;
	    Thread [] t_lists = new Thread [numberOfThreads]; 
	    Thread t, t2;  
	    long sTime = System.nanoTime() / 1000000;
		long current;
	    
	    System.out.println("Lista desordenada:\n");
	    
	    for( int i = 0; i < size; i ++ ) 
			array[i] = rand.nextInt(upperbound);
			
	    
	    
	    tempList = SortedLists.create(array, size, numberOfThreads);
	    merged = new MergeList(array);
	    
	    for( int i = 0; i < numberOfThreads; i ++ ) {	
			t = new Thread(tempList[i]);
			t_lists[i] = t; 
	    }
	    
	    
	    
	    Thread mainThread = new Thread( new Runnable() {
	    	
			@Override
			public void run() {
				for( int i = 0; i < numberOfThreads; i ++ ) {	
					
					t_lists[i].start(); 
			    }
				
			}
	    });
	    
	    
	    
	    mainThread.start();
	    
	    try {
			mainThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    merged.setList(tempList);
	    t2 = new Thread(merged); 
		
	    
	    t2.start();
	    try {
			t2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	    
	    
	    
	    
	    current = System.nanoTime() / 1000000;
		System.out.println("Sorting if for " +  numberOfThreads + " threads, time used: " + ( current - sTime) + "ms" );
	    
	    System.out.println("\nLista ordenada usando " + numberOfThreads + " hilos:\n");
	    merged.display();
	}
	
	
	

}


