package DS;

import java.io.Serializable;


/** This class represents a node in a sequentially-linked structure representing a
  * collection.
  *
  * @author  D. Hughes
  *
  * @version  1.0 (Mar. 2008)
  */

public class DynListNode< E > implements Serializable {
    
    
    E        item;  // the item in the stack
    DynListNode<E> next;  // the next node in the list
    
    
    /** This constructor creates a new node for the sequentially-linked structure
      * representing a collection.
      *
      * @param  i  the item in the node.
      * @param  n  the next node in the list.                                    */
    
    public DynListNode(E i, DynListNode<E> n ) {
        
        item = i;
        next = n;
        
    }; // constructor
    
    
} // Node