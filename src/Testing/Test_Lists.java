package Testing;

import DS.*;


/** This class is a test class for testing the List implementations: ConList and
  * LnkList. It performs a number of tests including add, remove, traversing,
  * iteratating, searching and tests of the exceptions.
  *
  * @author  D. Hughes
  *
  * @version  1.0 (Mar. 2008)                                                    */

public class Test_Lists {

    /** The constructor uses the method testList to test the list implementations*/

    public Test_Lists( ) {
        
        DynList<Integer> l;   // a list

        /*
        l = new ConList<Integer>(100);
        System.out.println("Testing Contiguous List");
        System.out.println();
        System.out.println();
        testList(l);
        System.out.println();
        System.out.println();
        */
        
        l = new DynList<Integer>();
        System.out.println("Testing Linked List");
        System.out.println();
        System.out.println();
        testList(l);

    }; // constructor
    
    
    /** This method does the actual test of a list.
      *
      * @param  l  a list to test                                                */
    
    private void testList ( DynList<Integer> l ) {
        
        int   c;
        
        System.out.println("Initial list length: ");
        System.out.print(l.length());


        System.out.println();
        System.out.println();


        System.out.println("Loading list, sequential order...");
        System.out.println();
        for ( c=1 ; c<=8 ; c++ ) {
            l.add(c);
            l.advance();
        };
        System.out.println("List loaded.");
        System.out.println();
        System.out.println("List length: ");
        System.out.print(l.length());
        System.out.println();
        System.out.println("Dumping list (sequential order)..");
        l.toFront();
        while ( ! l.offEnd() ) {
            System.out.print(l.remove() + " ");
        };
        System.out.println();
        System.out.println("List length: ");
        System.out.print(l.length());


        System.out.println();
        System.out.println();


        System.out.println("Loading list, reverse order...");
        System.out.println();
        for ( c=1 ; c<=8 ; c++ ) {
            l.add(c);
        };
        System.out.println("List loaded.");
        System.out.println();
        System.out.println("List length: ");
        System.out.print(l.length());
        System.out.println();
        System.out.println("Dumping list (reverse order) using iterator..");
        for ( Integer d : l ) {
            System.out.print(d + " ");
        };
        System.out.println();
        System.out.println("List length: ");
        System.out.print(l.length());


        System.out.println();
        System.out.println();


        System.out.println("Searching List");
        System.out.println();
        for ( c=2 ; c<=8 ; c++ ) {
            l.add(1);
            l.advance();
            l.add(c);
            l.advance();
        };
        l.add(1);
        System.out.println("List: ");
        int i = 0;
        for ( Integer d : l ) {
            i++;
            System.out.print(d + " ");
        };
        System.out.println();
        System.out.println("Search for B from front:");
        l.toFront();
        l.find(2);
        if ( ! l.offEnd() ) {
            System.out.println(" found");
        }
        else {
            System.out.println(" not found");
        };
        System.out.println();
        System.out.println("Search for B without advance:");
        l.find(2);
        if ( ! l.offEnd() ) {
            System.out.println(" found");
        }
        else {
            System.out.println(" not found");
        };
        System.out.println();
        System.out.println("Search for B with advance:");
        String s = debugLL(l);
        String t = debugCur(l);
        l.advance();
        l.find(2);
        if ( ! l.offEnd() ) {
            System.out.println(" found");
        }
        else {
            System.out.println(" not found");
        };
        System.out.println();
        System.out.println("Exhaustive search for A: ");
        l.toFront();
        while ( true ) {
            l.find(1);
            if ( l.offEnd() ) break;
            System.out.print(l.get() + " ");
            l.advance();
        };
        System.out.println();
        System.out.println();
        System.out.println("Add X in front of D: ");
        l.toFront();
        l.find(4);
        l.add(24);
        for ( Integer d : l ) {
            System.out.print(d + " ");
        };
        System.out.println();
        
        
        System.out.println("Output with iterator:");
        java.util.Iterator<Integer> j  = l.iterator();  //implement as explicit iterator
        while(j.hasNext()){
        	System.out.print(j.next() + " ");
        } 
        System.out.println();
        
        System.out.println("Remove X:            ");
        l.toFront();
        l.find(24);
        c = l.remove();
        l.toFront();
        while ( ! l.offEnd() ) {
            System.out.print(l.get() + " ");
            l.advance();
        };
        System.out.println();
        System.out.println();
        l.find(26);
        System.out.println("Get at off end: ");
        try {
            System.out.print(l.get() + " ");
        }
        catch ( NoItemException e ) {
            System.out.println("off list");
        };
        System.out.println();
        System.out.println("Remove at off end: ");
        try {
            System.out.print(l.remove() + " ");
        }
        catch ( NoItemException e ) {
            System.out.println("off list");
        };
        System.out.println();
        System.out.println("Advance at off end: ");
        l.advance();
        System.out.println("OK");
        System.out.println();
        
    }; // testList

    // debug
    public String debugLL(DynList<Integer> l) {
        String out = "";
        for ( Integer d : l ) {
            out = out + d + ", ";
        };
        return out;
    }

    // debug
    public String debugCur(DynList<Integer> l) {
        String out = "Cursor -> ";
        out = out + l.get() + ", ";
        l.advance();
        out = out + l.get() + ", ";
        l.advance();
        out = out + l.get() + ", ";
        return out;
    }

    public static void main ( String[] args ) { new Test_Lists(); };
    
    
} // TestLists