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
import java.awt.geom.Point2D;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

public class GraphVisual {

    private Graph graph;
    private Point2D[] vPos; // Vertex positions

    public final static int CIRC_SIZE = 50;

    public GraphVisual (Graph G) {
        this.graph = G;
    }
    public void drawGraph(Graphics g) {
        double xpos, ypos;

        // Draw connections
        for (int j = 0; j < this.graph.length; j++) {
            for (int i = 0; i < this.graph.length; i++) {
                if (this.graph.A[j][i]) {
                    g.drawLine(
                            (int) (g.getClipBounds().width  / 2 +  3*(g.getClipBounds().width /2)/4 * Math.cos(Math.PI/2 - j * ((2 * Math.PI) / this.graph.length))),
                            (int) (g.getClipBounds().height / 2 + -3*(g.getClipBounds().height/2)/4 * Math.sin(Math.PI/2 - j * ((2 * Math.PI) / this.graph.length))),
                            (int) (g.getClipBounds().width  / 2 +  3*(g.getClipBounds().width /2)/4 * Math.cos(Math.PI/2 - i * ((2 * Math.PI) / this.graph.length))),
                            (int) (g.getClipBounds().height / 2 + -3*(g.getClipBounds().height/2)/4 * Math.sin(Math.PI/2 - i * ((2 * Math.PI) / this.graph.length)))
                    );
                }
            }
        }

        // Draw nodes and labels
        String s;
        for (int i = 0; i < this.graph.length; i++) {
            xpos = g.getClipBounds().width / 2  +  3*(g.getClipBounds().width /2)/4 * Math.cos(Math.PI/2 - i * ((2 * Math.PI) / this.graph.length));
            ypos = g.getClipBounds().height / 2 + -3*(g.getClipBounds().height/2)/4 * Math.sin(Math.PI/2 - i * ((2 * Math.PI) / this.graph.length));
            g.setColor(Color.white);
            fillOvalD(g, xpos - CIRC_SIZE/2, ypos - CIRC_SIZE/2);
            g.setColor(Color.black);
            drawOvalD(g, xpos - CIRC_SIZE/2, ypos - CIRC_SIZE/2);
            s = this.graph.V[i].label.toString();
            g.drawString(s, (int) (xpos - g.getFontMetrics().getStringBounds(s,g).getWidth()/2), (int) ypos + g.getFont().getSize()/2);
        }
    }

    public void drawOvalD(Graphics g, double x, double y) {
        g.drawOval((int) x, (int) y, CIRC_SIZE, CIRC_SIZE);
    }

    public void fillOvalD(Graphics g, double x, double y) {
        g.fillOval((int) x, (int) y, CIRC_SIZE, CIRC_SIZE);
    }
}
