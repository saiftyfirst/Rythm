package com.saiftyfirst.models.graphs;

import lombok.Data;

@Data
public class UndirectedGraph extends AbstractGraph {

    int[][] edges;

    public UndirectedGraph(final int numberOfNodes) {
        super(numberOfNodes);
        this.edges = new int[numberOfNodes][numberOfNodes];
    }

    @Override
    public void addEdge(final int v, final int w) {
        this.edges[v][w] = 1;
        this.edges[w][v] = 1;
    }

}
