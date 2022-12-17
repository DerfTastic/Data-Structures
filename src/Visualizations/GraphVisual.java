package Visualizations;

/** Graph Visual
 *
 * This is a class to render a Graph data structure.
 *
 * @author Jacob "DerfTastic"
 * @since December 3rd, 2022
 */

import DS.Graph;

import java.awt.*;
import java.awt.event.MouseEvent;

public class GraphVisual {

    private Graph graph;
    private GNode[] nodes; // Vertex positions

    // VISUALIZATION CRAP
    public double spin = 0.0;
    private int hovNode = -1; // -1 = There is no node that is being hovered over at the moment

    public final static int CIRC_SIZE = 50;

    // CONSTANTS
    public final static int CIRCULAR_PLACE = 1;
    public final static int RANDOM_PLACE = 2;

    public GraphVisual(Graph G) {
        this.graph = G;
        this.nodes = new GNode[this.graph.length];
        for (int i = 0; i < this.nodes.length; i++) {
            this.nodes[i] = new GNode(0, 0);
        }
    }

    /**
     * Renders a visualization of the graph on the {@link Graphics} object.
     *
     * @param g The graphics visualization for the graph to be rendered on
     */
    public void drawGraph(Graphics g) {
        Point s, e;

        // Draw connections
        for (int j = 0; j < this.nodes.length; j++) {
            for (int i = 0; i < this.nodes.length; i++) {
                if (this.graph.A[j][i]) {
                    s = this.nodes[j];
                    e = this.nodes[i];
                    g.drawLine(s.x, s.y, e.x, e.y);
                }
            }
        }

        // Actually render the nodes
        renderNodes(g);
    }

    public void placeNodes(int width, int height, int method) {
        double xpos, ypos;

        switch (method) {
            case CIRCULAR_PLACE:

                Point org = new Point(width / 2, height / 2);
                Point circSize = new Point(width * 0.33, height * 0.33);
                double angSteps = 2 * Math.PI / this.nodes.length;
                for (int i = 0; i < this.nodes.length; i++) {
                    xpos = org.x + circSize.x * Math.cos(i * angSteps + spin);
                    ypos = org.y + circSize.y * Math.sin(i * angSteps + spin);
                    this.nodes[i].set(xpos, ypos);
                    //                System.out.println("Placed at: " + (int) xpos + ", " + (int) ypos);
                }
                break;

            case RANDOM_PLACE:

                Point screen = new Point(width, height);
                for (int i = 0; i < this.nodes.length; i++) {
                    xpos = Math.random() * screen.x;
                    ypos = Math.random() * screen.y;
                    this.nodes[i].set(xpos, ypos);
                }

                break;
        }
    }

    public void placeNodes(Graphics g, int method) {
        Rectangle bounds = g.getClipBounds();
        this.placeNodes(bounds.width, bounds.height, method);
    }

    public void renderNodes(Graphics g) {
        String s;
        for (int i = 0; i < this.nodes.length; i++) {
            g.setColor(this.nodes[i].color);
            fillOvalD(g, this.nodes[i].x - CIRC_SIZE / 2, this.nodes[i].y - CIRC_SIZE / 2);
            g.setColor(this.nodes[i].borderColor);
            drawOvalD(g, this.nodes[i].x - CIRC_SIZE / 2, this.nodes[i].y - CIRC_SIZE / 2);
            s = this.graph.V[i].label.toString();
            g.drawString(s, (int) (this.nodes[i].x - g.getFontMetrics().getStringBounds(s, g).getWidth() / 2), (int) this.nodes[i].y + g.getFont().getSize() / 2);
        }
    }

    public void drawOvalD(Graphics g, double x, double y) {
        g.drawOval((int) x, (int) y, CIRC_SIZE, CIRC_SIZE);
    }

    public void fillOvalD(Graphics g, double x, double y) {
        g.fillOval((int) x, (int) y, CIRC_SIZE, CIRC_SIZE);
    }

    public void setColor(int nodeIndex, Color color) {
        this.nodes[nodeIndex].color = color;
    }

    public void mouseMoved(MouseEvent e) {
        boolean onNothing = true;
        for (int i = 0; i < this.nodes.length; i++) {
            if (insideNode(i, e.getX(), e.getY())) {
                this.nodes[i].color = Color.gray;
                this.hovNode = i;
                onNothing = false;
            } else
                this.nodes[i].color = Color.white;
        }
        if (onNothing) this.hovNode = -1;
    }

    private boolean insideNode(int index, int x, int y) {
        double xdiff = this.nodes[index].x - x;
        double ydiff = this.nodes[index].y - y;
        double dist = Math.sqrt(xdiff * xdiff + ydiff * ydiff);
        return dist <= CIRC_SIZE;
    }

    public void mouseDragged(MouseEvent e) {
        if (hovNode != -1) {
            this.nodes[hovNode].x = e.getX();
            this.nodes[hovNode].y = e.getY();
        }
    }

    public void mousePressed(MouseEvent e) {
        if (hovNode != -1)
            this.nodes[hovNode].color = Color.red;
    }
}
