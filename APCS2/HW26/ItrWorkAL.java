//TrackoJackos
//Brian Lin, Thet Htay Zaw
//APCS2 pd2
//HW26 -- Delteratour
//2018-03-26

/*****************************************************
 * class ItrWork -- skeleton
 * Allows for familiarization with iterators
 *****************************************************/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWorkAL 
{
    //using FOREACH loop
    //returns a boolean to indicate whether key is present in L
    public static boolean foundA( Integer key, List<Integer> L ) 
    { 
        for ( Integer i : L ) {
	    if ( i == key ) {
		return true;
	    }
	}
	return false;
    }

    //explicitly using an iterator
    //returns a boolean to indicate whether key is present in L
    public static boolean foundB( Integer key, List<Integer> L ) 
    {
	
	Iterator moo = L.iterator();
	while ( moo.hasNext() ) {
	    if (moo.next() == key) {
		return true;
	    }
	}
	return false;
    }

    //using FOREACH loop
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsA( List<Integer> L ) 
    {
	List<Integer> foo = new ArrayList<Integer>();
	for ( Integer i : L ) {
	    if (i % 2 == 1) {
		foo.add(i);
	    }
	}
	return foo;	
    }

    //explicitly using an iterator
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsB( List<Integer> L ) 
    { 
        Iterator boo = L.iterator();
	List<Integer> koo = new ArrayList<Integer>();
	Integer holder = 0; 
	while ( boo.hasNext() ) {
	    holder = (Integer) boo.next();
	    if ( holder % 2 == 1) {
		koo.add( holder );
	    }
	}
	return koo;
    }


    //explicitly using an iterator
    //modifies L s.t. it contains no evens
    public static void removeEvens( List<Integer> L ) 
    { 
        Iterator woo = L.iterator();
	Integer holder = 0;
	while ( woo.hasNext() ) {
	    holder = (Integer) woo.next();
	    if ( holder % 2 == 0 ) {
		woo.remove();
	    }
	}
    }


    public static void main( String [] args ) 
    {
	//var type: List   obj type: ArrayList	
	List<Integer> L = new ArrayList<Integer>();

	for( int i = 0; i < 10; i++ )
	    L.add(i);


	// TASK: write code to print the contents of ArrayList L...

	
	// a) using a FOREACH loop
	System.out.println("\nTesting foundA...");
	System.out.println("9 in L? -> " + foundA(9,L) );
	System.out.println("13 in L? -> " + foundA(13,L) );

		
	System.out.println("\nTesting oddsA...");
	List<Integer> A = oddsA(L);
	for( int n : A ) System.out.println(n);

	// b) explicitly using an iterator

	System.out.println("\nTesting foundB...");
	System.out.println("9 in L? -> " + foundB(9,L) );
	System.out.println("13 in L? -> " + foundB(13,L) );

	System.out.println("\nTesting oddsB...");
	List<Integer> B = oddsB(L);
	for( int n : B ) System.out.println(n);

	System.out.println("\nTesting removeEvens...");
	removeEvens(L);
	for( int n : L ) System.out.println(n);
	/*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
	
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class ItrWork

