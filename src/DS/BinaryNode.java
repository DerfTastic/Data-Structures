package DS;

/**  BinaryNode
 *
 * This class represents a node in a binary search tree of Drug objects.
 *
 * @since October 16, 2022
 * @author Jacob Applebaum
 * @assignment 2
 * @course COSC 2P03
 * @teacher Yifeng Li
 */
public class BinaryNode {

    public BinaryNode  left;
    public BinaryNode  right;
    public Drug        item;   // The actual item of this node

    /** This constructor just instantiates a new BinaryNode */
    public BinaryNode(Drug item, BinaryNode left, BinaryNode right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }

    /** Print the attributes of this node type to the console. */
    public void displayNode() {
        System.out.println( // Insert a tab in between each attribute so its aligned
                this.item.displayDrug() + " ||| \tItem: " +
                        this.item.getId()       + ";\tLeft: " +
                        this.left               + ";\tRight: " +
                        this.right              + ";\t"
        );
    }
}
