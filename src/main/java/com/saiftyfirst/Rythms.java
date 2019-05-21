package com.saiftyfirst;

public class Rythms {

    public static void towerOfHanoi(int numOfDiscs, char source, char inter, char to) {
        if (numOfDiscs == 1) {
            System.out.println("Move disc 1 from " + source + " to " + to);
            return;
        }
        towerOfHanoi(numOfDiscs - 1, source, to, inter);
        System.out.println("Move disc " + numOfDiscs + " from " + source + " to " + to);
        towerOfHanoi(numOfDiscs - 1, inter, source, to);
    }

}
