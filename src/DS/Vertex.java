package DS;

public class Vertex <E> {

    public E label;
    public boolean wasVisited;

    public Vertex(E item) {
        this.label = item;
    }
}
