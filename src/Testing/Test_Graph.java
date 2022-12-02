package Testing;

import DS.*;

public class Test_Graph {

    private Graph<Character> G;

    public Test_Graph() {

        Character[] Vlabels = {'A', 'B', 'C', 'D', 'E'};

        G = new Graph<Character>(Vlabels);

//        for (int vi : Vlabels) {
//            G.addV(vi);
//        }
        G.link(2, 3);

        G.printAdjMat();

    }

    public static void main(String[] args) {
        new Test_Graph();
    }

}