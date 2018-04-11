//Thet Htay Zaw
//APCS2 pd2
//HW31 -- Stack: What Is It Good For? 
//2018-04-10

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s )
    {
	Latkes pancake = new Latkes( s.length() );
	for ( int i = 0; i < s.length(); i++ ) {
	    pancake.push(s.substring(i, i+1));
	}
	String reversed = "";
	while ( !pancake.isEmpty() ) {
	    reversed += pancake.pop();
	}
	return reversed;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s )
    {
	String leftFace = " "; //Has a space so that if we end with a right facing bracket, it won't crash
	Latkes dishes = new Latkes( s.length() );
	for (int i = 0; i < s.length(); i++ ) {
	    dishes.push(s.substring(i, i+1));
	}
	while ( !dishes.isEmpty() ) {
	    if ( dishes.peek().equals("}") || dishes.peek().equals(")") || dishes.peek().equals("]") ) {
		leftFace = dishes.pop() + leftFace;
	    }

	    else { 

		if ( dishes.peek().equals("{")) {
		    if ( !leftFace.substring(0,1).equals("}") ) {
			return false;
		    }
		}
	    
		if ( dishes.peek().equals("(")) {
		    if ( !leftFace.substring(0,1).equals(")") ) {
			return false;
		    }
		}
	    
		if ( dishes.peek().equals("[")) {
		    if ( !leftFace.substring(0,1).equals("]") ) {
			return false;
		    }
		}

		leftFace = leftFace.substring(1,leftFace.length() );
		dishes.pop(); 

	    }
	}
	
	if (!leftFace.equals(" ")) {
	    return false;
	}
	return true;
	    
    }//end allMatched()
     
    //Helper method for allMatched()

    
    //main method to test
    public static void main( String[] args )
    {
  
	System.out.println(flip("stressed")); //desserts
	System.out.println(flip("eevee")); //eevee
	System.out.println(flip("knits")); //stink
	System.out.println(flip("time")); //emit
	System.out.println(flip("")); //
	
	System.out.println("\n");
	
	System.out.println(allMatched( "({}[()])" )); //true
	System.out.println(allMatched( "([)]" ) ); //false
	System.out.println(allMatched( "(){([])}" ) ); //true
	System.out.println(allMatched( "](){([])}" ) ); //false
	System.out.println(allMatched( "(){([])}(" ) ); //false
	System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	System.out.println(allMatched( "()()()()()()[[[[[[[[[[]]]]]]]]]]{{}}{{{((()))}}}") ); //true
	System.out.println(allMatched( "" )); //true
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS
