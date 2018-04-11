//Thet Htay Zaw
//APCS2 pd2
//HW18 -- So So Quick
//2018-03-13

/*****************************************************
* class QuickSort
* Implements quicksort algo to sort an array of ints in place
*
* 1. Summary of QuickSort algorithm:
* QSort(arr): The algorithm works similar to QuickSelection such that where you start from the
* rightmost position and starts partitioning from there. Since we know that after a partition,
* value is in its final resting position, we continue on. That final resting position is noted,
* and the array is divided into two, both of which exclude that final resting position.Those two arrays
* are then quicksorted too.
*
* 2a. Worst pivot choice and associated runtime:
* If the "final resting position" constantly makes it so that the splitting of the array is very one sided.
* Then it's almost no different than running through each element and running partition then.
* It'll end up O(n^2)
*
* 2b. Best pivot choice and associated runtime:
* If the "final resting position" somehow makes the array split perfectly in half, it'll resemble something
* like mergesort with the splitting in half. This with the linear run time of parition should end with
* O(nlogn) runtime. I think? Well I hope. What I don't get is why use this over mergesort then if mergesort is more consistent
*
* 3. Approach to handling duplicate values in array:
* I'm actually not sure. I just kind of transformed the given pseudocode into code and it worked out?
* But what seems to be the case is that the duplicate values just get clumped together and duplicate values
* in a row are sorted by default.
*****************************************************/

public class QuickSort
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
}    //end partition
     //--------------^  HELPER METHODS  ^--------------



/*****************************************************
* void qsort(int[])
* @param d -- array of ints to be sorted in place
*****************************************************/
public static void qsort( int[] d )
{

        qsort(d, 0, d.length - 1);

}


/**********************************************
* void qsort( int[] , int, int )
* @param d -- array of ints to be sorted in place
* @param left -- starting index of the array to be organized
* @param right - ending index of the array to be organized
**********************************************/
public static void qsort(int[] d, int left, int right) {
        //printArr(d);
        if (left < right) {
                int pivot = partition(d, left, right, right);
                qsort(d, left, pivot - 1);
                qsort(d, pivot + 1, right);

        }

}


//main method for testing
public static void main( String[] args )
{


        //get-it-up-and-running, static test case:
        int [] arr1 = {7,1,5,12,3};
        System.out.println("\narr1 init'd to: " );
        printArr(arr1);

        qsort( arr1 );
        System.out.println("arr1 after qsort: " );
        printArr(arr1);

        // randomly-generated arrays of n distinct vals
        int[] arrN = new int[10];
        for( int i = 0; i < arrN.length; i++ )
                arrN[i] = i;

        System.out.println("\narrN init'd to: " );
        printArr(arrN);

        shuffle(arrN);
        System.out.println("arrN post-shuffle: " );
        printArr(arrN);

        qsort( arrN );
        System.out.println("arrN after sort: " );
        printArr(arrN);

/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/




        //get-it-up-and-running, static test case w/ dupes:
        int [] arr2 = {2,1,1,1,1,11,1};
        System.out.println("\narr2 init'd to: " );
        printArr(arr2);

        qsort( arr2 );
        System.out.println("arr2 after qsort: " );
        printArr(arr2);


        // arrays of randomly generated ints
/*
        int[] arrMatey = new int[20];
        for( int i = 0; i < arrMatey.length; i++ )
                arrMatey[i] = (int)( 48 * Math.random() );

        System.out.println("\narrMatey init'd to: " );
        printArr(arrMatey);

        shuffle(arrMatey);
        System.out.println("arrMatey post-shuffle: " );
        printArr(arrMatey);

        qsort( arrMatey );
        System.out.println("arrMatey after sort: " );
        printArr(arrMatey);
 */     //Commented out for the sake of testing other things
        /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
                 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

}  //end main

}//end class QuickSort
