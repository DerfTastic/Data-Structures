package DS;

/**
 * Priority Queue
 *
 * A queue that is ordered by each node's priority
 *
 * Notes:
 * <ul>
 *     <li>Low <code>.priority</code> value (AKA key) = High Priority</li>
 * </ul>
 *
 *
 * @author Jacob Applebaum
 */
public class PQueue <E> {

    private PNode<E>  data;
    public int length;

    public PQueue() {
        length = 0;
    }

    /** Inserts an item into the queue according to its key.
     *
     * @param item The item to be inserted into the queue
     */
    public void insert(E item, int priority) {

        // If queue is empty
        if (this.length == 0) {
            // then make a new Node pointing to null in both directions
            this.data = new PNode<E>(item, priority, null, null);

        }
        // If the new node needs to be inserted at the front of the queue
        else if ( priority < this.data.priority ) {

            this.data.prev = new PNode<E>(item, priority, this.data.prev, this.data);
            this.data = this.data.prev; // update head

        }
        // If the queue already has nodes in it
        else {

            PNode<E> q = this.data; // Put q at front

            // Traverse queue until q is at the last node with a matching priority
            while ( (q.next != null && q.next.priority <= priority) ) {
                q = q.next;
            }

            // Insert node after q
            q.next = new PNode<E>(item, priority, q, q.next);
            if (q.next.next != null) // If it's not the last node
                q.next.next.prev = q.next; // Update node after
        }

        length++; // Update length
    }

    /** Removes the front-most item in the queue
     * (the earliest inserted item that also has the smallest key i.e. highest priority)
     *
     * @return first item in the queue */
    public E deleteMin() {
        if (this.length == 0) return null; // Obviously, you can't remove anything if there are no nodes.

        E p = this.data.item; // Get Patient of head node, so the whole thing doesn't get GC'd when we detach it

        if (this.length == 1) // If there is 1 node
            this.data = null; // Just detach everything
        else {                // If there is >1 node
            this.data = this.data.next; // Assign new head of priority queue
            this.data.prev = null;      // Detach max node from queue
        }

        this.length--;

        return p;
    }

    /** Prints the data in the priority queue. Used for debugging.
     *
     * @param indent Whether or not to indent the contents of the WaitQueue*/
    public void printContents(boolean indent) {
        System.out.println("\tWaitQueue contents:");
        if (length == 0) {
            System.out.println("\t\tThe queue is empty");
        } else {
            PNode p = data;
            int count = 1;
            do {
                System.out.println( (indent ? "\t\t" : "") + count + ": " + p.item + " ; " + p.priority);
                p = p.next;
                count++;
            }
            while (p != null);

        }
    }
}
