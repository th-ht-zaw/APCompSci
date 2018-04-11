/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    private String _cargo;
    private LLNode _next;

    // constructor

    public LLNode()
    {
      _cargo = "";
      _next = null;
    }

    public LLNode(String cargo)
    {
      _cargo = cargo;
      _next = null;
    }

    public LLNode(String cargo, LLNode next)
    {
      _cargo = cargo;
      _next = next;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
      return _cargo;
    }

    public LLNode getNext()
    {
      return _next;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo(String cargo)
    {
      String temp = _cargo;
      _cargo = cargo;
      return temp;
    }

    public LLNode setNext(LLNode next)
    {
      LLNode temp = _next;
      _next = next;
      return temp;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
      String current = "| " + _cargo + " || --|--->| ";
      String after = "";
      if (_next != null) {
        after = getNext().getCargo();
      }
      else {
        after = "null";
      }
      after = after + " |";
      return current + after;
    }



    //main method for testing
    public static void main( String[] args )
    {
	//PROTIP: try creating a few nodes: traversible, connected...
	//note anything notable as you develop and test...
      LLNode example = new LLNode("cow");
      LLNode test = new LLNode("cat", example);
      LLNode var = new LLNode("cactus", test);

      System.out.println(example.getCargo()); //cow
      System.out.println(example.getNext()); //null

      System.out.println(test.getCargo()); //cat
      System.out.println(test.getNext()); //| cow |--->| null |

      System.out.println(var.getCargo()); //cactus
      System.out.println(var.getNext()); //| cat |--->| cow |

      example.setNext(var);
      test.setNext(var);
      var.setCargo("pine tree");
      example.setCargo("lion");

      System.out.println("\nFinal Results:==========================");
      System.out.println(example); //| lion |--->| pine tree |
      System.out.println(test); //| cat |--->| pine tree |
      System.out.println(var); //| pine tree |--->| cat |

    }//end main

}//end class LLNode
