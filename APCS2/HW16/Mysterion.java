//Thet Htay Zaw
//APCS2 pd2
//HW16 -- About Face
//2018-03-07

public class Mysterion {

  public static int swap(int[] arr, int indA, int indB) {
  int holder = arr[indA];
  arr[indA] = arr[indB];
  arr[indB] = holder;
  return holder;
}

  public static String printArr(int[] arr){
    String retStr = "[";
    for (int s : arr) {
      retStr += s + ",";
    }
    retStr += "]";
    System.out.println(retStr);
    return retStr;
  }

/*
It looks like this method takes an array with the bounds [a, b-1] with the center value
being "c" and "sorts" to the right and left of it. "c" acts as some sort of pivot point
and the values to the left or right of c are sorted in ascending order from the "c" value
to the corners or in descending value.

a = starting index
b = ending index + 1
c = central value/pivot point

*/
/*
Answers:
Partition()
'a' and 'b' are the range
*/
  public static int centralizer(int[] arr, int a, int b, int c) {
    int v = arr[c];
    swap( arr, c, b );
    printArr(arr);
    int s = a;
    for ( int i = 0; i < b - 1; i++ ) {
      if (arr[i] < v) {
        swap(arr, s , i );
        printArr(arr);
        s += 1;
      }
    }
    swap(arr, b, s);
    printArr(arr);
    return s;
  }

  public static void main(String[] args) {
  int[] array = { 3, 7, 12, 5, 1};
  int[] array1 = { 12, 5, 7, 3, 1};
  printArr(array);
  System.out.println(centralizer(array, 0, 4, 2));
  printArr(array1);
  System.out.println(centralizer(array1, 0, 4, 2));

}

}
