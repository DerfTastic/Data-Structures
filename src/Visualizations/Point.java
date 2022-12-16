package Visualizations;

/** Point
 *
 * I just hated working with {@link java.awt.geom.Point2D}, too complex to work with.
 * so, I just made a simple class that does the trick
 *
 * @author Jacob "DerfTastic"
 * @since December 16th, 2022
 */

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.set(x, y);
    }

    public Point(double x, double y) {
        this.set(x, y);
    }

    public Point() {
        this(0, 0);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(double x, double y) {
        this.set((int) x, (int) y);
    }
}
