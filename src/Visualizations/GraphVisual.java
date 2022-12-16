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
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GraphVisual {

    private Graph graph;
    private Point[] vPos; // Vertex positions

    public final static int CIRC_SIZE = 50;

    // CONSTANTS
    public final static int CIRCULAR_PLACE = 1;

    public GraphVisual (Graph G) {
        this.graph = G;
        this.vPos = new Point[this.graph.length];
        for (int i = 0; i < this.vPos.length; i++ ) { this.vPos[i] = new Point(0, 0); }
    }

    /** Renders a visualization of the graph on the {@link Graphics} object.
     * @param g The graphics visualization for the graph to be rendered on
     */
    public void drawGraph(Graphics g) {
        Point s, e;

        // Place the nodes
        placeNodes(g, CIRCULAR_PLACE);

        // Draw connections
        for (int j = 0; j < this.vPos.length; j++) {
            for (int i = 0; i < this.vPos.length; i++) {
                if (this.graph.A[j][i]) {
                    s = this.vPos[j];
                    e = this.vPos[i];
                    g.drawLine(s.x, s.y, e.x, e.y);
                }
            }
        }

        // Actually render the nodes
        renderNodes(g);
    }

    public void placeNodes(Graphics g, int method) {
        switch (method) {
        case CIRCULAR_PLACE:

            double xpos, ypos;
            Point org = new Point(g.getClipBounds().width / 2, g.getClipBounds().height / 2);
            Point circSize = new Point( g.getClipBounds().width * 0.33, g.getClipBounds().height * 0.33 );
            double angSteps = 2 * Math.PI / this.vPos.length;
            for (int i = 0; i < this.vPos.length; i++) {
                xpos = org.x + circSize.x * Math.cos( i * angSteps );
                ypos = org.y + circSize.y * Math.sin( i * angSteps );
                this.vPos[i].set(xpos, ypos);
                System.out.println("Placed at: " + (int) xpos + ", " + (int) ypos);
            }
            break;
        }
    }

    public void renderNodes(Graphics g) {
        String s;
        for (int i = 0; i < this.vPos.length; i++) {
            g.setColor(Color.white);
            fillOvalD(g, this.vPos[i].x - CIRC_SIZE/2, this.vPos[i].y - CIRC_SIZE/2);
            g.setColor(Color.black);
            drawOvalD(g, this.vPos[i].x - CIRC_SIZE/2, this.vPos[i].y - CIRC_SIZE/2);
            s = this.graph.V[i].label.toString();
            g.drawString(s, (int) (this.vPos[i].x - g.getFontMetrics().getStringBounds(s,g).getWidth()/2), (int) this.vPos[i].y + g.getFont().getSize()/2);
        }
    }

    public void drawOvalD(Graphics g, double x, double y) {
        g.drawOval((int) x, (int) y, CIRC_SIZE, CIRC_SIZE);
    }

    public void fillOvalD(Graphics g, double x, double y) {
        g.fillOval((int) x, (int) y, CIRC_SIZE, CIRC_SIZE);
    }
}
