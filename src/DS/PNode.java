package DS;

/**
 * Node
 *
 * A class to represent nodes of a Symmetrically-Linked List
 *
 * @since September 14, 2022
 * @author Jacob Applebaum
 * @assignment 1
 * @course COSC 2P03
 * @teacher Yifeng Li
 */
public class PNode <E> {

    public E        item;
    public int      priority;
    public PNode<E> prev;
    public PNode<E> next;

    public PNode(E i, int priority, PNode p, PNode n){
        this.item = i;
        this.priority = priority;
        this.prev = p;
        this.next = n;
    }
}
