package DS;

/**  BST
 *
 * This is a class to represent a Binary Search Tree
 * with Binary Nodes. There are also methods implemented
 * to read and manipulate the tree, like search, insert,
 * and delete.
 *
 * @since October 19, 2022
 * @author Jacob Applebaum
 * @assignment 2
 * @course COSC 2P03
 * @teacher Yifeng Li
 */
public class BST {

    public BinaryNode root; // Root node
    private int count = 0; // Debug

    /** This constructor instantiates a new Binary Search Tree */
    public BST() {
        // Dummy Node just to start things off
        this.root = new BinaryNode(
                new Drug(Integer.MAX_VALUE, null, null, null, null, 1f),
                null, null
        );
    }

    /** Inserts newNode into tree
     *
     * @param T The root node
     * @param newNode The new node to be inserted
     * */
    public void insert(BinaryNode T, BinaryNode newNode) {
        // insert newNode into tree with root T
        // try recursive version yourself, then compare to textbook, p. 118
        if (T == null)
            T = newNode;
        else {
            BinaryNode curr = T;
            BinaryNode parent;
            while (true) {
                parent = curr;
                if (newNode.item.getId() < curr.item.getId()) { // insert in left subtree
                    curr = curr.left;
                    if (curr == null) // insert here
                    {
                        parent.left = newNode;
                        return;
                    }
                } else { // insert in right subtree
                    curr = curr.right;
                    if (curr == null) { // insert here
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    /** Traverses this BST in a "inOrder" fashion
     *
     * @param T The root of this tree
     */
    public void inOrderTraverse(BinaryNode T) {
        if (T == null)
            return;
        else {
            inOrderTraverse(T.left);
            T.displayNode();
            inOrderTraverse(T.right);
        }
    }

    /** Deletes a given node in this BST
     *
     * @param T the root node
     * @param key The key of the node to delete
     * @return The BinaryNode that was deleted
     */
    public BinaryNode delete(BinaryNode T, int key) {
        // delete and return the root of the new tree
        if (T == null) // null tree, or not found
            return T;
        if (key < T.item.getId())
            T.left = delete( T.left, key ); //del from left, update
        else if (key > T.item.getId())
            T.right = delete(T.right, key); //del from right,update
        else { // T.item == key
            if (T.left !=null && T.right != null ) {
                T.item = findMin(T.right).item;
                T.right = delete(T.right, T.item.getId());
            }
            else { // T only has left or right subtree, or T is a leaf, update T
                if (T == root) { // If T is the root of the entire tree
                    root = (T.left != null) ? T.left : T.right;
                }
                T = (T.left != null) ? T.left : T.right;
            }
        }
        return T;
    }

    public BinaryNode findMin(BinaryNode T) {
        // find smallest element – this must be the leftmost node in the entire tree
        if (T != null) {
            while(T.left != null)
                T = T.left;
        }
        return T;
    }

    /** Search for a specific node in this BST
     *
     * @param T The root of the tree
     * @param id The id of the Drug you are searching for in the tree
     * @return
     */
    public BinaryNode search(BinaryNode T, int id) {
        BinaryNode curr = T;
        while (curr.item.getId() != id) {
            if (id < curr.item.getId())
                curr = curr.left;
            else
                curr = curr.right;
            if (curr == null)
                return null;
        }
        return curr;
    }

    /** Gets the depth of a certain node in a Tree
     *
     */
    public int depth1(int id) {
        BinaryNode curr = this.root;
        int count = 0;
        while (curr.item.getId() != id) {
            if (id < curr.item.getId())
                curr = curr.left;
            else
                curr = curr.right;
            if (curr == null)
                return count;
            count++;
        }
        return count;
    }

    /** Gets the depth of the entire tree (depth of deepest node)
     *
     * @return The depth of the entire tree (depth of deepest node)
     */
    public int depth2(BinaryNode T, int index) {
        if (T == null) {
            return index-1;
        }
        if (T.left == null && T.right == null) {
            return index;
        }
        int a = depth2(T.left, index+1);
        int b = depth2(T.right, index+1);
        return (a >= b) ? a : b;
    }
}
