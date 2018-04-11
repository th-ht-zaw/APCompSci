//Thet Htay Zaw
//APCS2 pd2
//HW21c -- Rockin' Through the Night
//2018-03-19

public class LList implements List
{

  /*
  So I reached a point where I have no idea how to approach this assignment. I don't know
  where to start and where to end, and without even that foundation, I can't make code over it.
  I've been trying for several hours now and I'm just about ready to give up. So I might as well
  record my thoughts on this so I have something to talk to my neighbors about:

  1) add() should work in the sense that a new node is made, and the parameter input becomes the cargo.
  Then I think you could take one of two paths. You could either make the new node the "next" of the previous
  node or you could make the previous node the "next" of the new node. But whatever method you choose likely
  alters how the linked list is structured.

  2) get() is weird because I don't think we necessarily have a index to work off of. But I think you're
  going to have to somehow recursively work through the lengthed list until the parameter input for get()
  counts down to 0, and then you return the cargo of the node you are currently at. Without an understanding,
  of how add works, I cannot make a linked list and try to implement get().

  3) set() might work similar to get(), at least in locating the node. Once the node is located, it's only a matter of
  using the mutator so that the cargo of the node is changed.

  4) size(). Either we have an instance variable and this acts as an accessor, or we count through each node and keep
  track of the size and return it with size().
  */


//instance variables
/*
    public LLNode startingNode = new LLNode();
    public LLNode previousNode = new LLNode();
    public int size = 0;
*/
/*
    public boolean add(String x)
    {
      if (size == 0)
      {
        startingNode = new LLNode(x);
        size += 1;
        previousNode = startingNode;
        return true;
      }
      else
      {
        LLNode newNode = new LLNode(x , previousNode);
        size += 1;
        previousNode = newNodel
        return true;
      }
    }
*/

}
