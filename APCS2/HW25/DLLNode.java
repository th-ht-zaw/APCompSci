/*
//TrackoJackos
//Brian Lin, Thet Htay Zaw
//APCS2 pd2
//HW24 -- On the DLL
//2018-03-24
 */

/*****************************************************
 * class DLLNode<T>
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode<T> 
{
    private T _cargo;    //cargo may only be of type String
    private DLLNode<T> _nextNode, _prevNode; //pointers to next, prev DLLNodes

    // constructor -- initializes instance vars
    public DLLNode( T value, DLLNode<T> next, DLLNode<T> prev) {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }
    
    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return _cargo; }

    public DLLNode<T> getNext() { return _nextNode; }

    public DLLNode<T> getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------

    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) {
	T cray = getCargo();
	_cargo = newCargo;
	return cray;
    }

    public DLLNode<T> setNext( DLLNode<T> newNext ) {
	DLLNode<T> moop = getNext();
	_nextNode = newNext;
	return moop;
    }

    public DLLNode<T> setPrev( DLLNode<T> newPrev ) {
	DLLNode<T> hume = getPrev();
	_prevNode = newPrev;
	return hume;
    }
    //--------------^  MUTATORS  ^--------------

    // override inherited toString
    public String toString() { return _cargo.toString(); }

    //main method for testing
    public static void main( String[] args ) {

    }
    
}//end class DLLNode
