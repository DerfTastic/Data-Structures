package Testing.Testing;

/** Test GUI Graph
 *
 * A runnable class to run a visualization of a graph using the {@link Visualizations.GraphVisual} class.
 *
 * @author Jacob "DerfTastic"
 * @since November 28, 2022
 */

import DS.Graph;
import Visualizations.GraphVisual;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class TestGUI_Graph extends JPanel implements MouseListener, MouseMotionListener {

    private Graph G;
    private GraphVisual Gv;

    int n = 6;

    private static JFrame frame;


    public TestGUI_Graph() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

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

        Gv = new GraphVisual(G);
        Gv.placeNodes(800, 800, GraphVisual.RANDOM_PLACE);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

//        long start = System.nanoTime();
        Gv.drawGraph(g);
//        long stop = System.nanoTime();

//        Gv.spin += 15.0 / (stop - start);
//        Gv.placeNodes(g, GraphVisual.CIRCULAR_PLACE);

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        Gv.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseDragged(MouseEvent e) {
        Gv.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Gv.mouseMoved(e);
    }

    public static void main(String[] args) {
        frame = new JFrame("Testing Graphs");
        frame.setContentPane(new TestGUI_Graph());
        frame.pack();
        frame.setSize(800, 800);
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
