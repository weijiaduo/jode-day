# jode-day

一日复一日，明日何其多。

> https://weijiaduo.github.io/

# 一、数据结构与算法

## 1.1 数据结构

## 链表

- [单向链表](./algorithm/src/main/java/com/wjd/structure/list/SingleList.java)
- [双向链表](./algorithm/src/main/java/com/wjd/structure/list/DoubleList.java)
- [LRU 缓存](./algorithm/src/main/java/com/wjd/structure/list/LRUCache.java)

## 队列

- 队列
  - [顺序队列](./algorithm/src/main/java/com/wjd/structure/queue/ArrayQueue.java)
  - [链式队列](./algorithm/src/main/java/com/wjd/structure/queue/ListQueue.java)
- 循环队列
  - [循环单向队列](./algorithm/src/main/java/com/wjd/structure/queue/CircularQueue.java)
  - [循环双向队列](./algorithm/src/main/java/com/wjd/structure/queue/CircularDeque.java)

## 栈

- [顺序栈](./algorithm/src/main/java/com/wjd/structure/stack/ArrayStack.java)
- [链式栈](./algorithm/src/main/java/com/wjd/structure/stack/ListStack.java)

## 堆

- [堆](./algorithm/src/main/java/com/wjd/structure/tree/heap/HeapImpl.java)
- [索引堆](./algorithm/src/main/java/com/wjd/structure/tree/heap/IndexHeapImpl.java)
- [左倾堆]
- [斜堆]
- [二项堆]
- [斐波那契堆]

## 树

- 二叉搜索树
  - [BST 二叉搜索树](./algorithm/src/main/java/com/wjd/structure/tree/bst/BSTreeImpl.java)
- 平衡二叉搜索树
  - [AVL 平衡二叉树](./algorithm/src/main/java/com/wjd/structure/tree/avl/AVLTreeImpl.java)
  - [双偏向红黑树](./algorithm/src/main/java/com/wjd/structure/tree/redblack/BLRBTree.java)
  - [左偏向红黑树](./algorithm/src/main/java/com/wjd/structure/tree/redblack/LLRBTree.java)
- 多叉树
  - [B-树](./algorithm/src/main/java/com/wjd/structure/tree/btree/BTreeImpl.java)
  - [B+树](./algorithm/src/main/java/com/wjd/structure/tree/bplus/BPTreeImpl.java)
- 高级树
  - [哈夫曼树](./algorithm/src/main/java/com/wjd/structure/tree/huffman/HuffmanTreeImpl.java)
  - 并查集
    - [并查集-数组](./algorithm/src/main/java/com/wjd/structure/tree/ufs/ArrayUnionFind.java)
    - [并查集-映射](./algorithm/src/main/java/com/wjd/structure/tree/ufs/MapUnionFind.java)
  - 线段树
    - [线段树-数组](./algorithm/src/main/java/com/wjd/structure/tree/segment/ArraySegmentTree.java)
    - [线段树-链表](./algorithm/src/main/java/com/wjd/structure/tree/segment/LinkSegmentTree.java)
  - 字典树
    - [字典树-字母](./algorithm/src/main/java/com/wjd/structure/tree/trie/LetterTrie.java)
    - [字典树-字符](./algorithm/src/main/java/com/wjd/structure/tree/trie/CharacterTrie.java)
  - [树状数组（二叉索引树）](./algorithm/src/main/java/com/wjd/structure/tree/binaryindex/BinaryIndexTree.java)

## 散列表

- [散列表-开放寻址法](./algorithm/src/main/java/com/wjd/structure/hashtable/LinkedHashTable.java)
- [散列表-拉链法](./algorithm/src/main/java/com/wjd/structure/hashtable/LinkedHashTable.java)

## 跳表

- [整数跳表-数组](./algorithm/src/main/java/com/wjd/structure/skiplist/SimpleSkipList.java)
- [跳表-数组](./algorithm/src/main/java/com/wjd/structure/skiplist/ArraySkipList.java)
- [跳表-链表](./algorithm/src/main/java/com/wjd/structure/skiplist/LinkedSkipList.java)

## 图

- 无向图
  - [邻接矩阵](./algorithm/src/main/java/com/wjd/structure/graph/undirected/impl/MatrixGraph.java)
  - [邻接表](./algorithm/src/main/java/com/wjd/structure/graph/undirected/impl/ListGraph.java)
  - [邻接多重表]
  - [无向符号图](./algorithm/src/main/java/com/wjd/structure/graph/undirected/impl/SymbolGraphImpl.java)
- 加权无向图
  - [邻接矩阵](./algorithm/src/main/java/com/wjd/structure/graph/undirected/impl/MatrixWeightedGraph.java)
  - [邻接表](./algorithm/src/main/java/com/wjd/structure/graph/undirected/impl/ListWeightedGraph.java)
- 有向图
  - [邻接矩阵](./algorithm/src/main/java/com/wjd/structure/graph/directed/impl/MatrixDigraph.java)
  - [邻接表](./algorithm/src/main/java/com/wjd/structure/graph/directed/impl/ListDigraph.java)
  - [十字链表]
  - [有向符号图]

## 1.2 算法

## 数组

### 排序

- 插入排序
  - [插入排序](./algorithm/src/main/java/com/wjd/algorithm/sort/InsertSort.java)
  - [希尔排序](./algorithm/src/main/java/com/wjd/algorithm/sort/ShellSort.java)
- 选择排序
  - [选择排序](./algorithm/src/main/java/com/wjd/algorithm/sort/SelectSort.java)
  - [堆排序](./algorithm/src/main/java/com/wjd/algorithm/sort/HeapSort.java)
- 交换排序
  - [冒泡排序](./algorithm/src/main/java/com/wjd/algorithm/sort/BubbleSort.java)
  - [快速排序](./algorithm/src/main/java/com/wjd/algorithm/sort/QuickSort.java)
- 归并排序
  - [归并排序](./algorithm/src/main/java/com/wjd/algorithm/sort/MergeSort.java)
- 桶排序
  - [桶排序](./algorithm/src/main/java/com/wjd/algorithm/sort/BucketSort.java)
  - [计数排序](./algorithm/src/main/java/com/wjd/algorithm/sort/CountSort.java)
- 基数排序
  - [基数排序](./algorithm/src/main/java/com/wjd/algorithm/sort/RadixSort.java)

### 二分查找

- [第一个等于](./algorithm/src/main/java/com/wjd/algorithm/binary/FirstEqualSearch.java)
- [第一个大于等于](./algorithm/src/main/java/com/wjd/algorithm/binary/FirstNotLessThanSearch.java)
- [最后一个等于](./algorithm/src/main/java/com/wjd/algorithm/binary/LastEqualSearch.java)
- [最后一个小于等于](./algorithm/src/main/java/com/wjd/algorithm/binary/LastNotGreatThanSearch.java)

## 树

### 二叉树构建

- 二叉树
  - [层序构建](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/build/LevelTreeBuilder.java)
  - [中序+后序构建](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/build/InAndPostTreeBuilder.java)
  - [中序+前序构建](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/build/PreAndInTreeBuilder.java)
- 线索二叉树
  - [前序构建](./algorithm/src/main/java/com/wjd/algorithm/tree/thread/build/PreorderThreadBuilder.java)
  - [中序构建](./algorithm/src/main/java/com/wjd/algorithm/tree/thread/build/InorderThreadBuilder.java)
  - [后序构建](./algorithm/src/main/java/com/wjd/algorithm/tree/thread/build/PostorderThreadBuilder.java)

### 二叉树遍历

- 二叉树
  - [构建层序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/traverse/BuildLevelTraverse.java)
  - [简单层序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/traverse/SimpleLevelTraverse.java)
  - [前序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/traverse/PreorderTraverse.java)
  - [中序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/traverse/InorderTraverse.java)
  - [后序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/traverse/PostorderTraverse.java)
  - [Z 形遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/binary/traverse/PostorderTraverse.java)
  - [Morris-前序遍历]
  - [Morris-中序遍历]
  - [Morris-后序遍历]
- 线索二叉树
  - [前序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/thread/traverse/PreorderThreadTraverse.java)
  - [中序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/thread/traverse/InorderThreadTraverse.java)
  - [后序遍历](./algorithm/src/main/java/com/wjd/algorithm/tree/thread/traverse/PostorderThreadTraverse.java)

## 图

### 图的遍历

- 无向图
  - [广度优先搜索（BFS）](./algorithm/src/main/java/com/wjd/algorithm/graph/undirected/search/BreadthFirstSearch.java)
  - [深度优先搜索（DFS）](./algorithm/src/main/java/com/wjd/algorithm/graph/undirected/search/DepthFirstSearch.java)
- 有向图
  - [广度优先搜索（BFS）](./algorithm/src/main/java/com/wjd/algorithm/graph/directed/search/DirectedBFS.java)
  - [深度优先搜索（DFS）](./algorithm/src/main/java/com/wjd/algorithm/graph/directed/search/DirectedDFS.java)
  - [前序遍历](./algorithm/src/main/java/com/wjd/algorithm/graph/directed/order/PreDFO.java)
  - [后序遍历](./algorithm/src/main/java/com/wjd/algorithm/graph/directed/order/PostDFO.java)
  - [逆后序遍历](./algorithm/src/main/java/com/wjd/algorithm/graph/directed/order/ReversePostDFO.java)
  - [拓扑排序](./algorithm/src/main/java/com/wjd/algorithm/graph/directed/order/Topological.java)

### 可达性和连通性

- 无向图
  - 可达性（路径）
    - [基于 DFS 的路径](./algorithm/src/main/java/com/wjd/algorithm/graph/undirected/path/DepthFirstPaths.java)
    - [基于 BFS 的路径](./algorithm/src/main/java/com/wjd/algorithm/graph/undirected/path/BreadthFirstPaths.java)
  - [连通分量](./algorithm/src/main/java/com/wjd/algorithm/graph/undirected/connected/impl/DepthFirstConnected.java)
  - [环检测](./algorithm/src/main/java/com/wjd/algorithm/graph/undirected/cycle/UndirectedCycle.java)
  - [二分图](./algorithm/src/main/java/com/wjd/algorithm/graph/undirected/bipartite/impl/BipartiteImpl.java)
- 有向图
  - 可达性（路径）
    - [基于 DFS 的路径](./algorithm/src/main/java/com/wjd/algorithm/graph/directed/path/DirectedDFP.java)
    - [基于 BFS 的路径](./algorithm/src/main/java/com/wjd/algorithm/graph/directed/path/DirectedBFP.java)
  - [强连通分量（Kosaraju）](./algorithm/src/main/java/com/wjd/algorithm/graph/directed/connected/impl/KosarajuStrongConnected.java)
  - [环检测](./algorithm/src/main/java/com/wjd/algorithm/graph/directed/cycle/DirectedCycle.java)
  - [出入度]

### 最小生成树（MST）

- 加权无向图
  - [Prim 算法](./algorithm/src/main/java/com/wjd/algorithm/graph/undirected/mst/impl/PrimMST.java)
  - [Kruskal 算法](./algorithm/src/main/java/com/wjd/algorithm/graph/undirected/mst/impl/KruskalMST.java)

### 最短路径

- 无向图
  - [BFS 算法]
- 加权无向图
  - [Dijkstra 算法]
- 有向图
  - [BFS 算法]
- 加权有向图
  - [Dijkstra 算法]
  - [Floyd 算法]
  - [关键路径]

## 字符串

### 字符串排序

### 单词查找树

### 字符串匹配

- [BF 算法]
- [RK 算法]
- [BM 算法]
- [KMP 算法]
- [AC 自动机]

### 正则表达式
