package Testing;

import DS.*;

public class Test_PQueue {

    private PQueue<Integer> pq;

    public Test_PQueue() {
        int[] test = {1, 2, 3, 4, 5, 6, 7};
        int[] pris = {2, 1, 0, 2, 1, 0, 2};

        pq = new PQueue<Integer>();

        int j = 0;
        for (int i = 0; i < test.length; i++) {
            pq.insert(test[i], pris[i]);
        }

        pq.printContents(false);

    }

    public static void main(String[] args) {
        new Test_PQueue();
    }

}