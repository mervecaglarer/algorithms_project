/*Your program will get 2 numbers (low and high) 
as input and generate 20 random numbers
within the range of low to high and load 
the numbers to a Hash and LinkedList. 
Next it will print the numbers greater than 15
and their ranks for each data structure. 
Then print how long it took to print each 
data structure. Write the outputs to a file. 
*/

package algorithms;

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.HashMap;

public class Main {
	
	public static void main (String[] args) throws InterruptedException,IOException {
	    //int low = Integer.parseInt(args[0]); 
	    //int high = Integer.parseInt(args[1]);
		Scanner input = new Scanner(System.in);
    	System.out.print("Enter low: ");
    	int low = input.nextInt();
    	System.out.print("Enter high: ");
    	int high = input.nextInt();
    	
    	HashMap<Integer,Integer> hashmap = new HashMap<>();
    	LinkedList<Integer> numbers = new LinkedList<>();

    	Random randomGenerator = new Random();

    	for (int i = 0; i < 20; i++) {
    	    int randomInt = randomGenerator.nextInt(high - low);
    	    numbers.add(randomInt);
    	    hashmap.put(i, randomInt);
    	}
    	
    	System.out.println(numbers);
    	
    	File file = new File("output.txt");
        if(file.createNewFile()){
            System.out.println("File Created in Project root directory");
        }else 
        	System.out.println("File already exists in the project root directory");
        
    	FileWriter data=new FileWriter("output.txt",false);
    	PrintWriter print_line=new PrintWriter(data);
    	
    	print_line.printf("%s"+"%n", "LinkedList");
    	long startTime = System.nanoTime();
	System.out.println("LinkedList");
		for(int j = 0; j < 20; j++) { 
			if(numbers.get(j) > 15) { 
				System.out.println(j + " - " +numbers.get(j));
				print_line.println(j + " - " + numbers.get(j));
			}
		}
		
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		print_line.println("Execution time in nanoseconds  : " + timeElapsed);
		System.out.println("Execution time in nanoseconds  : " + timeElapsed);
		System.out.println("--------------------");
		print_line.println("--------------------");
		
		print_line.printf("%s"+"%n", "Hash");
		long startTime2 = System.nanoTime();
		System.out.println("HashMap");
		for(int j = 0; j < 20; j++) { 
			if(numbers.get(j) > 15) { 
				System.out.println(j + " - " +hashmap.get(j));
				print_line.println(j + " - " + hashmap.get(j));
			}
		}
		
		long endTime2 = System.nanoTime();
		long timeElapsed2 = endTime2 - startTime2;
		print_line.println("Execution time in nanoseconds  : " + timeElapsed2);
		System.out.println("Execution time in nanoseconds  : " + timeElapsed2);
		 
		print_line.close();

	}
}