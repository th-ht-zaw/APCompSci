//TrackoJackos
//Brian Lin, Thet Htay Zaw
//APCS2 pd2
//HW24 -- On the DLL
//2018-03-23

/*****************************************************
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 * new in v2: add-at-index, remove
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{ 

    //instance vars
    private DLLNode _head;
    private DLLNode _tail;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null; //at birth, a list has no elements
	_tail = null;
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( String newVal )
    {
	DLLNode tmp = new DLLNode( newVal, null , _tail );
	if (_head == null ) { 
	    _head = tmp;
	    _tail = tmp;
	    _size++;
	    return true;
	}
	else { 
	    _tail = tmp;
	    _tail.getPrev().setNext( _tail );
	    _size++;
	    return true;
	}
    }

    
    public String get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	DLLNode tmp = _head; //create alias to head

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

	DLLNode tmp = _head; //create alias to head

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
    

    //insert a node containing newVal at position index
    public void add( int index, String newVal ) {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode newNode = new DLLNode( newVal, _head,  null );

	//if index==0, insert node before head node
	if ( index == 0 ) {
	    DLLNode temp = _head;
	    _head = newNode;
	    _size++;
	}
	else if ( index == size() - 1 ) {
	    add( newVal );
	} 
	else {
	    DLLNode tmp = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();

	    //insert new node
	    newNode.setNext( tmp.getNext() );
	    tmp.getNext().setPrev( newNode );
	    newNode.setPrev( tmp ); 
	    tmp.setNext( newNode );

	    //increment size attribute
	    _size++;
	}
    }


    //remove node at pos index, return its cargo
    public String remove( int index ) {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	DLLNode tmp = _head; //create alias to head

	//if index==0, remove head node
	if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = _head.getCargo();

	    //remove target node
	    if ( size() != 1 ) { 
		_head = _head.getNext();
		_head.setPrev( null );
	    }
	    else {
		_head = null;
		_tail = null;
	    } 
	}
	else if (index == size() - 1 ) {
	    retVal = _tail.getCargo();
	    _tail = _tail.getPrev();
	    _tail.setNext( null ); 
	} 
	else {
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();

	    //check target node's cargo hold
	    retVal = tmp.getNext().getCargo();

	    //remove target node
	    tmp.setNext( tmp.getNext().getNext() );
	    tmp.getNext().setPrev( tmp ); 
	}

	//decrement size attribute
	_size--;

	return retVal;
    }

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD-> NULL<-";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL <-TAIL";
	return retStr;
    }

}//end class LList


