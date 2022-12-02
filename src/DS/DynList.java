package DS;

import java.util.Iterator;
import DS.List;

/**
 *
 * @author Jacob Applebaum
 * @since March 5, 2022
 */

public class DynList<E extends Comparable<E>> implements List<E> {

    private DynListNode<E> head;   // this is the header node
    private DynListNode<E> cursor;

    public DynList() {
        cursor = head;
    }

    public DynListNode<E> getHead() {
        return this.head;
    }

    public void add(E item) {

        if (empty()) {
            this.head = new DynListNode<E>(item, null);
            this.cursor = this.head;
        }
        else if (offEnd()) {
            DynListNode<E> p;
            p = this.head;

            while (p.next != null) {
                p = p.next;
            }

            p.next = new DynListNode<E>(item, null);
            this.cursor = p.next;
        }
        else if (this.cursor == this.head){
            this.head = new DynListNode<E>(item, this.cursor);
            this.cursor = head;
        }
        else  {
            DynListNode<E> p = this.head;

            while (p.next != this.cursor){
                p = p.next;
            }
            p.next = new DynListNode<E>(item, this.cursor);
            this.cursor = p;
        }
    }


    public E remove() {

        if (offEnd()){
            throw new NoItemException();
        }
        else if (this.cursor == this.head){
            DynListNode<E> p = this.head;
            this.head = this.cursor.next;
            this.cursor = this.head;
            return (E) p.item;
        }
        else {
            DynListNode<E> p = head;

            while (p.next != this.cursor) {
                p = p.next;
            }

            p.next = this.cursor.next;
            DynListNode<E> r = this.cursor;
            this.cursor = p.next;
            return (E) r.item;
        }
    }


    public E get() {
        if (this.cursor == null) { throw new NoItemException(); }
        else { return this.cursor.item; }
    }


    public boolean empty() {
        return this.head == null;
    }


    public int length() {
        if (this.empty()) {
            return 0;
        }
        else {
            DynListNode<E> p = this.head;
            int count = 1;

            while (p.next != null) {
                p = p.next;
                count++;
            }

            return count;
        }

    }


    public void toFront() {
        this.cursor = this.head;
    }

    public void advance() {
        if (this.cursor != null) {
            this.cursor = this.cursor.next;
        }
    }

    public void find(E element) {
        while ( this.cursor != null && this.cursor.item.compareTo(element) != 0 ) {
            this.cursor = this.cursor.next;
        }
    }

    public boolean offEnd() {
        return this.cursor == null;
    }

    public Iterator<E> iterator() {
        return new DynListIterator<E>(this);
    }

} // TurtleDisplayer
