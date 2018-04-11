//Thet Htay Zaw
//APCS2 pd2
//HW07 -- A Man, A Plan, A Canal: Panama!
//2018-02-14

public class Resrever {

    public static String reverseLin(String example) {

	String retStr = "";

	for ( int i = example.length() - 1 ; i >= 0 ; i-- ) {
	    retStr = retStr + example.substring(i, i+1);
	}
	//Make a new String by reading the old String from right to left

	return retStr;

	/*
	if (example.length() == 1) {
	    return example;
	}

	return example.substring(example.length() - 1, example.length()) + reverseLog(example.substring(0, example.length() - 1));
	*/ //Originally thought this was log(n) time, but I believe this is actually linear but recursive

    }

    public static String reverseLog(String example) {

	int halfway = example.length() / 2; 

	if (example.length() == 1) {
	    return example;
	}
	//If the String has a length of 1 (i.e. is a single character long), return it

	return reverseLog(example.substring(halfway)) + reverseLog(example.substring(0,halfway));
	//Split it halfway and reverse the halves
	//Then combine the two halves such that the right half is now the left half and vice versa

    }

    /*Despite this, I don't believe this is actually a log2(n) runtime algorithm. As stated on the QAF, the runtime of the actual division
      may be log2(n), but the actual concatenation of the strings is going to be in linear time. You must always perform n concencatenations
      to rejoin the String together. This results in the algorithm having a linear time at best, and since log2(n) is faster than O(n), it is
      not possible to get a runtime of log2(n) for this algorithm.
    */ 


    public static void main(String[] args) {

	System.out.println("Testing out reverseLin===========================\n");

	System.out.println(reverseLin("stressed")); //Should return desserts 
	System.out.println(reverseLin("disney")); //Should return yensid
	System.out.println(reverseLin("evil")); //Should return live
	System.out.println(reverseLin("time")); //Should return emit

	System.out.println("\nTesting out reverseLog======================\n");

	System.out.println(reverseLog("desserts"));
	System.out.println(reverseLog("yensid"));
	System.out.println(reverseLog("live"));
	System.out.println(reverseLog("emit"));

    }




} 
