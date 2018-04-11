//TrackoJackos
//Brian Lin, Thet Htay Zaw
//APCS2 pd2
//HW23 -- Give or Take
//2018-03-22

/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{ 

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( String newVal )
    {
	LLNode tmp = new LLNode( newVal, _head );
	_head = tmp;
	_size++;
	return true;
    }

    public void add(int i, String s)
    {
	//Everything is under the assumption that the first node is index 0.
	
	if (i < 0 || i >= size() )
	    throw new IndexOutOfBoundsException();

	if (i == 0) {
	    LLNode temp = _head;
	    LLNode insert = new LLNode (s , _head);
	    _head = insert;
	    _size++;
	    return;
	} //Special case for zero. Can possibly be robustified such that we don't need this
	
	LLNode tmp = _head; //Start at the head / create alias to head
	for (int j = 0; j < i - 1; j++) {
	    tmp = tmp.getNext();
	} //Walk down all the way to the node before the desired index of insertion

	LLNode insert = new LLNode( s , tmp.getNext() );//Make the new node's next be the current node's next
	tmp.setNext(insert); //Turn current node's next to the new node
	_size++; //increase size

    }

    public String remove( int i )
    {
	if (i < 0 || i >= size() )
	    throw new IndexOutOfBoundsException();

	if (i == 0) {
	    LLNode temp = _head;
	    String output = _head.getCargo();
	    LLNode insert = new LLNode( temp.getNext().getCargo() , temp.getNext().getNext() );
	    temp = insert;
	    _head = temp;
	    _size--;
	    return output;
	}

	    LLNode temp = _head;
	    String output = _head.getNext().getCargo();	
	    for (int x = 0; x < i - 1; x++) {
	        temp = temp.getNext();
	    }
	    output = temp.getNext().getCargo(); 
	    LLNode skipNode = new LLNode(temp.getNext().getNext().getCargo() , temp.getNext().getNext().getNext() ); 
	    temp.setNext(skipNode);
	    _size--;
	    return output;
    } 

    
    public String get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public String set( int index, String newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() { return _size; }
    
    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
	LList james = new LList();
	
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );
	
	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );

	System.out.println("\n====================Adding at Index=======================");
	james.add(3,"moo");
	System.out.println("\n");
	System.out.println(james);
	System.out.println("size: " + james.size() );

	james.add(0, "baa");
	System.out.println(james);
	System.out.println("size: " + james.size() );

	james.add(1, "meow");
	System.out.println(james);
	System.out.println("size: " + james.size() );

	james.add(5, "bark");
	System.out.println(james);
	System.out.println("size: " + james.size() );

	System.out.println("===========================================\n");
	System.out.println("\n====================Removing=======================");

	System.out.println("Item Removed: " + james.remove(0));
	System.out.println(james);
	System.out.println("size: " + james.size() );
	
	System.out.println("Item Removed: " + james.remove(1));
	System.out.println(james);
	System.out.println("size: " + james.size() );

	System.out.println("Item Removed: " + james.remove(4));
	System.out.println(james);
	System.out.println("size: " + james.size() );

	System.out.println("Item Removed: " + james.remove(2));
	System.out.println(james);
	System.out.println("size: " + james.size() );
	System.out.println("===========================================\n");
    }

}//end class LList
