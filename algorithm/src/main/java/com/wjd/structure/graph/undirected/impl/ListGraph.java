package com.wjd.structure.graph.undirected.impl;

import com.wjd.structure.graph.undirected.Graph;
import com.wjd.structure.graph.util.IntBag;

/**
 * 基于邻接表实现的无向图
 *
 * @author weijiaduo
 * @since 2023/3/5
 */
public class ListGraph implements Graph {

    /**
     * 顶点数量
     */
    private final int vs;
    /**
     * 边数量
     */
    private int es;

    /**
     * 邻接表
     */
    private final IntBag[] adj;

    public ListGraph(int vs) {
        this.vs = vs;
        adj = new IntBag[vs];
        for (int i = 0; i < vs; i++) {
            adj[i] = new IntBag();
        }
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
        if (hasEdge(v, w)) {
            return;
        }
        adj[v].add(w);
        adj[w].add(v);
        es++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        for (int x : adj[v]) {
            if (x == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

}
