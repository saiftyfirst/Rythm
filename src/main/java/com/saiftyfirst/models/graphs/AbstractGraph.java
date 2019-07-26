package com.saiftyfirst.models.graphs;


public abstract class AbstractGraph implements Graph {

    final int numberOfNodes;

    public AbstractGraph(final int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
    }

    @Override
    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    abstract void addEdge(final int v, final int w);

}
