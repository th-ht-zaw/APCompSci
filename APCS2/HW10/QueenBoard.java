//Thet Htay Zaw
//APCS2 pd2
//HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2018-2-27

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

/*
Problem: It only seems to work for nxn arrays where n = 4/5/7. 
I think I know where the error is, check comments, below, but
I don't know how to fix it. I also don't understand how to
do this problem recursively
*/ 

public class QueenBoard
{
    private int[][] _board;
    
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }

  
    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     */
    public boolean solve()
    {
	//I am completely unsure on how to tackle this recursively
	boolean retBool = true; 
	int counter = 0;
	while (counter < _board.length) {
	    if (solveH(counter)) {//If you can place a queen in the column, place it and proceed
		counter++;
	    }
	    else {
		counter--; //Else backtrack. I think there's an error here. I want it to continue regardless but backtrack
		           //If it doesn't work. But that changes the rest of the code
		           //The error is likely here
		if (counter < 0) { //To prevent index out of bounds error 
		    retBool = false;
		    break;
		} 
		for (int i = 0; i < _board.length ; i++) { //Just to find the Queen, remove it, and make the spot null 
		    if (_board[i][counter] == 1) {
			removeQueen(i,counter);
			_board[i][counter] = -1;
		    }
		}
	    }
	}
	if (retBool) {
	    printSolution();
	    return retBool;
	}
	else {
	    
	    for (int r = 0; r < _board.length ; r++) {
		for (int c = 0 ; c < _board[0].length ; c++ ) {
		    _board[r][c] = 0;
		}
	    }
	    
	    printSolution();
	    return retBool;
	} 
    }
	    

  
    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	//If you can place a Queen in the row, place it
	for (int i = 0; i < _board.length ; i++ ) {
	    if (_board[i][col] == 0 ) {
		return addQueen(i,col);
	    }
	}
	return false; 
	
    }


    public void printSolution()
    {
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/
	String ans = "";
	for (int r = 0 ; r < _board.length; r++) {
	    for (int c = 0; c < _board[0].length; c++) {
		if (_board[r][c] > 0 ) {
		    ans += "Q" + "\t";
		}
		else {
		    ans += "_" + "\t";
		}
	    }
	    ans += "\n";
	}
	System.out.println(ans); 
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * Adds a Queen if possible
     * precondition: The space must be a 0. Meaning no other Queen is present or no other queen invalidates the spot 
     * postcondition: The Queen is placed
     */
    private boolean addQueen(int row, int col){
	if(_board[row][col] != 0){
	    return false;
	}
	_board[row][col] = 1;
	int offset = 1;
	while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
		_board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
		_board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Removes a Queen if possible
     * precondition: There must be a Queen present in the spot (The spot has a value of 1)
     * postcondition: The Queen is removed 
     */
    private boolean removeQueen(int row, int col){
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;
	int offset = 1;

	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Allows the 2D array to be printed with ease
     * precondition: 
     * postcondition: 
     */
    public String toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard b = new QueenBoard(7);
	b.solve(); //works

	QueenBoard c = new QueenBoard(10);
	c.solve(); //doesnt work

	QueenBoard e = new QueenBoard(3);
	e.solve(); //doesnt work

	QueenBoard g = new QueenBoard(4);
	g.solve(); //works

    }
    
}//end class
