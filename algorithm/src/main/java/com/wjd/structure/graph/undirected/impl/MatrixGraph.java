package com.wjd.structure.graph.undirected.impl;

import com.wjd.structure.graph.undirected.Graph;
import com.wjd.structure.graph.util.Bag;

/**
 * 基于邻接矩阵实现的无向图
 *
 * @author weijiaduo
 * @since 2023/3/5
 */
public class MatrixGraph implements Graph {

    /**
     * 顶点数量
     */
    private final int vs;
    /**
     * 边数量
     */
    private int es;

    /**
     * 邻接矩阵
     */
    private final boolean[][] adj;

    public MatrixGraph(int vs) {
        this.vs = vs;
        adj = new boolean[vs][vs];
    }

    @Override
    public int vs() {
        return vs;
    }

    @Override
    public int es() {
        return es;
    }

    @Override
    public void addEdge(int v, int w) {
        if (adj[v][w]) {
            return;
        }
        adj[v][w] = true;
        adj[w][v] = true;
        es++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        Bag bag = new Bag();
        for (int i = 0; i < vs; i++) {
            if (adj[v][i]) {
                bag.add(i);
            }
        }
        return bag;
    }

}
