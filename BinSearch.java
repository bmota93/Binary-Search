/**
 * <pre>
 * 
 * Author:
 *  	Brandon Mota 
 *  
 * Description: 
 * 		This program will search for a given
 * 		integer from a text file. 
 * 
 * </pre>
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinSearch
{
	private int[] arr;
	private int val;
	private int compare;
	
	/**
	 * <pre>
	 * Description: 
	 * This is the constructor for the class.
	 * Pre:
	 * none. 
	 * Post:
	 * Sets the size of the new array.
	 * </pre>
	 * 
	 */
	public BinSearch()
	{
		arr = new int[20];
		val = 0;
		compare = 0;
	}
	
	/**
	 * <pre>
	 * Description: 
	 * This calls searchRec2 to begin the search
	 * using recursion.
	 * Pre:
	 * none. 
	 * Post:
	 * Returns the index value val.
	 * </pre>
	 * 
	 */
	
	public int searchRec1(int array[], int value)
	{
		return(searchRec2(array, value, 0, arraycount()));
	}
	
	/**
	 * <pre>
	 * Description: 
	 * This is the recursive method that
	 * searches for the value recursively.
	 * It also counts the number of comparisons.
	 * Pre:
	 * none. 
	 * Post:
	 * The requested value is found and the index
	 * and the index value is returned.
	 * </pre>
	 * 
	 */
	public int searchRec2(int[] array, int value, int low, int high)
	{
		int middle;
		if (low > high)
		{
			compare++; //compare counted here
			return -1;
		}
		
		middle = (high + low)/2;
		
		if (value == arr[middle])
		{
			compare++; //compare counted here
			return middle;
		}
		else if (val < array[middle])
		{
			compare++; //compare counted here
			return(searchRec2(array, value, low, middle - 1));
		}
		else
		{
			compare++; //compare counted here
			return(searchRec2(array, value, middle + 1, high));
		}
		
	}
	
	/**
	 * <pre>
	 * Description: 
	 * This prints the array.
	 * Pre:
	 * The array must not be all 0s. 
	 * Post:
	 * The array is printed.
	 * </pre>
	 * 
	 */
	public void arrayprint()
	{
		System.out.println("The array looks like this:");
		for (int i = 0; i < 20; i++)
		{
			if (arr[i] != 0)
			{
			System.out.print(arr[i]);			
			System.out.print("  ");
			}
		}
	}
	
	/**
	 * <pre>
	 * Description: 
	 * This requests the user input.
	 * Pre:
	 * none. 
	 * Post:
	 * The users integer value is stored in val.
	 * </pre>
	 * 
	 */
	public void userinput()
	{				
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\nEnter a whole number that you would like to search for: ");		
		val = scan.nextInt();		
	}
	
	/**
	 * <pre>
	 * Description: 
	 * This "shortens" the array size when the 20 indexes of the array
	 * are not filled since an integer array fills empty spaces
	 * with 0s thus creating an unsorted array.
	 * Pre:
	 * Array must not be all 0s. 
	 * Post:
	 * The "true" array size is returned.
	 * </pre>
	 * 
	 */
	public int arraycount()
	{
		for (int i = 0; i < 20; i++)
		{
			if (arr[i] == 0)
			{
				return i;
			}
		}
		return arr.length;
	}	

	/**
	 * <pre>
	 * Description: 
	 * This is the main method that controls
	 * the flow of the program. 
	 * </pre>
	 * 
	 */
	public static void main(String[] args)
	{
		BinSearch search = new BinSearch();
		int i = 0;
		
		try
		{		
			File file = new File("data.txt");		
			Scanner scan = new Scanner(file);		
			while (scan.hasNext())		
			{
				search.arr[i] = scan.nextInt();
				i++;
			}
			search.arrayprint();
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
			System.out.println("Ensure that \"data.txt\" is present and in the correct location.");
			System.out.println("Program Terminated......");
		}
		
		search.userinput();		
		System.out.println("\nValue: " + search.val);
		System.out.println("Array Index: " + search.searchRec1(search.arr, search.val));
		System.out.println("Number of compares: " + search.compare);
		
		System.out.println("\nRerun the program to search for another value");
		System.out.println("Program Terminated...");		

	}

}
