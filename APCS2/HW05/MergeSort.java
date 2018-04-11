//Thet Htay Zaw
//APCS2 pd2
//HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
//2018-02-06


/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  First to explain merge: 
  merge() will compare two sorted arrays, comparing the two values at the "front"
  (i.e. the leftmost values from both arrays that are not already in the combined array), 
  and insert them into the combined array. If one array is fully present in the combined array,
  merge() will place the remaining values from the other array in the remaining spots of the
  combined array. 

  sort() is a recursive method. If the length of the array you are trying to sort is greater than 1, 
  split it in half, and have those two halves go through sort() too. Once those two halves have gone
  though sort(), merge those two halves. An array of length 1 is already sorted, so merge() will make it
  so the combined array of length 2 (or 3), will also be sorted. This continues on until the original
  starting array has merged its two halves (both of which  may or may not have its own two halves). This
  final merged array will be sorted fully.

  ======================================*/

public class MergeSort
{
    /******************************************************
     * int[] merge(int[],int[])
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b )
    {
	int counterA = 0; //counter for int[] a
	int counterB = 0; //counter for int[] b
	int counterC = 0; //counter for int[] combined
	int[] combined = new int[a.length + b.length];
      
	while (counterC < combined.length) {
	  
	    if ( a[counterA] <  b[counterB] ) {
		combined[counterC] = a[counterA];
		counterA += 1;
	    }

	    else {
		combined[counterC] = b[counterB];
		counterB += 1;
	    }

	    counterC += 1;

	    if (counterA >= a.length || counterB >= b.length ) {
		break;
	    }

	}

	if (counterB < b.length) {
	    while (counterC < combined.length) {
		combined[counterC] = b[counterB];
		counterC += 1;
		counterB += 1;
	    }
	}

	else if (counterA < a.length) {
	    while (counterC < combined.length) {
		combined[counterC] = a[counterA];
		counterC += 1;
		counterA += 1;
	    }
	}

	return combined;	 
      
    }//end merge()


    /******************************************************
     * int[] sort(int[])
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr )
    {
	if (arr.length > 1) {
	    int[] firsthalf = new int[arr.length / 2];
	    int[] secondhalf = new int[arr.length - firsthalf.length];
	    int counter = 0;
	    
	    for (int i = 0; i < firsthalf.length ; i++) {
		firsthalf[i] = arr[counter];
		counter++;
	    }
	    
	    for (int j = 0; j < secondhalf.length ; j++) {
		secondhalf[j] = arr[counter];
		counter++;
	    }

	    firsthalf = sort(firsthalf);
	    secondhalf = sort(secondhalf);
	    arr = merge(firsthalf,secondhalf);
	}

	return arr;
	  

    }//end sort()

    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------
    
    //main method for testing
    public static void main( String [] args ) {

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr2 ");
	printArray( merge(arr4,arr2) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
    }//end main()

}//end class MergeSort
