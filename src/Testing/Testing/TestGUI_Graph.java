package Testing.Testing;

import DS.Graph;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class TestGUI_Graph extends JPanel implements MouseListener, MouseMotionListener {

    private Graph G;

    int n = 6;

    private static JFrame frame;

    final static int CIRC_SIZE = 25;
    int ORIG_X = 0;
    int ORIG_Y = 0;

    public TestGUI_Graph() {
        addMouseListener(this);
        addMouseMotionListener(this);

        Character labels[] = new Character[5];
        for (char c = 'a'; c <= 'e'; c++)
            labels[(int)(c-'a')] = c;

        G = new Graph<Character>(labels);

        for (int i = 0; i < 10; i++) {
            double a = G.length * Math.random();
            double b = G.length * Math.random();
//            System.out.printf("a:%f  b:%f", a, b);
            G.link((int) a, (int) b);
        }

        G.printAdjMat();

    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        drawGraph(g, G);
//        d+=0.001;

        // repaint();
    }

    public void drawGraph(Graphics g, Graph<Object> graph) {
        double xpos, ypos;

        // Draw connections
        for (int j = 0; j < graph.length; j++) {
            for (int i = 0; i < graph.length; i++) {
                if (graph.A[j][i]) {
                    g.drawLine(
                        (int) (g.getClipBounds().width  / 2 +  3*(g.getClipBounds().width /2)/4 * Math.cos(Math.PI/2 - j * ((2 * Math.PI) / graph.length))),
                        (int) (g.getClipBounds().height / 2 + -3*(g.getClipBounds().height/2)/4 * Math.sin(Math.PI/2 - j * ((2 * Math.PI) / graph.length))),
                        (int) (g.getClipBounds().width  / 2 +  3*(g.getClipBounds().width /2)/4 * Math.cos(Math.PI/2 - i * ((2 * Math.PI) / graph.length))),
                        (int) (g.getClipBounds().height / 2 + -3*(g.getClipBounds().height/2)/4 * Math.sin(Math.PI/2 - i * ((2 * Math.PI) / graph.length)))
                    );
                }
            }
        }

        // Draw nodes and labels
        String s;
        for (int i = 0; i < graph.length; i++) {
            xpos = g.getClipBounds().width / 2  +  3*(g.getClipBounds().width /2)/4 * Math.cos(Math.PI/2 - i * ((2 * Math.PI) / graph.length));
            ypos = g.getClipBounds().height / 2 + -3*(g.getClipBounds().height/2)/4 * Math.sin(Math.PI/2 - i * ((2 * Math.PI) / graph.length));
            g.setColor(Color.white);
            fillOvalD(g, xpos - CIRC_SIZE/2, ypos - CIRC_SIZE/2);
            g.setColor(Color.black);
            drawOvalD(g, xpos - CIRC_SIZE/2, ypos - CIRC_SIZE/2);
            s = graph.V[i].label.toString();
            g.drawString(s, (int) (xpos - g.getFontMetrics().getStringBounds(s,g).getWidth()/2), (int) ypos + g.getFont().getSize()/2);
        }
    }

    public void drawOvalD(Graphics g, double x, double y) {
        g.drawOval((int) x, (int) y, CIRC_SIZE, CIRC_SIZE);
    }

    public void fillOvalD(Graphics g, double x, double y) {
        g.fillOval((int) x, (int) y, CIRC_SIZE, CIRC_SIZE);
    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) { }

    public static void main(String[] args) {
        frame = new JFrame("Testing Graphs");
        frame.setContentPane(new TestGUI_Graph());
        frame.pack();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JButton button = new JButton("Submit");
//        button.setBounds(50, 150, 100, 30);
//        //add button to the frame
//        frame.add(button);
    }
}
