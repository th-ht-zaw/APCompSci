//Thet Htay Zaw
//APCS2 pd2
//HW17 -- So So Fast
//Due: 2018 - 03 - 11


public class FastSelect
{
//--------------v  HELPER METHODS  v--------------
//swap values at indices x, y in array o
public static void swap( int x, int y, int[] o ) {
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
}

//print input array
public static void printArr( int[] a ) {
        for ( int o : a )
                System.out.print( o + " " );
        System.out.println();
}

//shuffle elements of input array
public static void shuffle( int[] d ) {
        int tmp;
        int swapPos;
        for( int i = 0; i < d.length; i++ ) {
                tmp = d[i];
                swapPos = i + (int)( (d.length - i) * Math.random() );
                swap( i, swapPos, d );
        }
}

//return int array of size s, with each element fr range [0,maxVal)
public static int[] buildArray( int s, int maxVal ) {
        int[] retArr = new int[s];
        for( int i = 0; i < retArr.length; i++ )
                retArr[i] = (int)( maxVal * Math.random() );
        return retArr;
}
//--------------^  HELPER METHODS  ^--------------

/*
   a = starting index
   b = ending index
   c = pivot
   From the range a - c, all values are less than c
   From the range c - b, all values are greater than c
   In the range a - b, c is in its final resting position for a sorted array from range a - b.
 */

public static int partition( int arr[], int a, int b, int c)
{
        int v = arr[c];

        swap( c, b, arr);
        int s = a;

        for( int i = a; i < b; i++ ) {
                if ( arr[i] <= v) {
                        swap( i, s, arr );
                        s++;
                }
        }
        swap(s,b,arr);

        return s;
}  //end partition

/*
   When partition is run, it alters the array such that the "c" value is in its final resting
   position if the array where to be sorted from the range "a" to "b".
   So arr[a] would be index 0. So to find the yth smallest term in the array,
   you make the range 0 to the final element of the array. You then make c equal to the
   yth smallest minus one because array indexes start at 0 and not 1. And because arr[c]
   is going to be in its final resting position if this were to be a sorted array, you only need
   to call arr[y - 1] again after it's partitioned to get the yth smallest value.

   This must be O(n) time or linear this. This algorithm takes on the run time of partition, which is linear,
   In parition, you only run through each element once. Swapping elements is constant time so that part
   does not heavily affect the run time. Best case scenario and worst case scenario seem to align
   because no matter what, you are running through the array from a to b. So really, there doesn't
   seem to be a best or worst case scenario.
 */
public static int ythSmallest(int[] arr, int y) {
        partition(arr, 0, arr.length - 1, y-1);
        return arr[y - 1];
}


//main method for testing
public static void main( String[] args )
{
        //init test arrays of magic numbers
        int[] arr1 = {8,21,17,69,343};
        int[] arr3 = {1,28,33,4982,37};
        int[] arr4 = {5,4,17,9000,6};
        int[] arr5 = {3,0,16,599,1024};
        int[] arr6 = {3, 2, 7,5, 10};

        printArr(arr1);
        System.out.println("Smallest: " + ythSmallest(arr1, 1));

        System.out.println("\n");

        printArr(arr3);
        System.out.println("Second Smallest: " + ythSmallest(arr3, 2));

        System.out.println("\n");

        printArr(arr4);
        System.out.println("Third Smallest: " + ythSmallest(arr4, 3));

        System.out.println("\n");

        printArr(arr5);
        System.out.println("Fourth Smallest: " + ythSmallest(arr5, 4));

        printArr(arr6);
        System.out.println("Fourth Smallest: " + ythSmallest(arr6, 4));
}  //end main

}//end class FastSelect
