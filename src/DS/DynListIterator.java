package DS;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/** This class represents an iterator on a Collections.DynList as required by the interface
 * Iterable<E> of the List interface.
 *
 * @see  List
 * @see  DynList
 *
 * @author  Jacob Applebaum
 * @since   March 5th, 2022
 */

class DynListIterator< E extends Comparable<E> > implements Iterator<E> {


    private DynList<E>  list;    // the list being iterated over
    private DynListNode<E> cursor;


    /** This constructor constructs an iterator on the specified Collections.DynList.
     *
     * @param  l  the list to be iterated over.                                 */

    DynListIterator ( DynList<E> l ) {

        this.list = l;
        this.list.toFront();
        this.cursor = this.list.getHead();

    };  // constructor


    /** This method returns true if there are more items in the list.
     *
     * @return  boolean  more items on the list.                                */

    public boolean hasNext ( ) {  // from Iterator
        return this.cursor != null;
    };  // hasNext


    /** This method returns the next item in the list.
     *
     * @return  E  the next item on the list.                                   */

    public E next ( ) {  // from Iterator

        if (this.list.empty() || this.list.offEnd()) {
            throw new NoSuchElementException();
        }
        else {
            E i = this.cursor.item;
            this.cursor = this.cursor.next;
            return i;
        }

    };  // next


    /** Removal is not supported so this method throws an
     * UnsupportedOperationException.
     *
     * @exception  UnsupportedOperationException  remove is not supported.      */

    public void remove ( ) {  // from Iterator

        throw new UnsupportedOperationException();

    };  // remove


}  // Collections.DynListIterator