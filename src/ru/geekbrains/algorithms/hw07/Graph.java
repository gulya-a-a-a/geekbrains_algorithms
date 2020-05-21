package ru.geekbrains.algorithms.hw07;

import java.util.*;

public class Graph<E> {
    private final List<Vertex<E>> mVertexList;
    private final boolean[][] mConnections;
    private final int mMaxSize;

    Graph(int maxItems) {
        mVertexList = new ArrayList<>(maxItems);
        mConnections = new boolean[maxItems][maxItems];
        mMaxSize = maxItems;
    }

    void addMultiple(E... params) {
        for (E param : params) {
            add(param);
        }
    }

    void add(E value) {
        if (mVertexList.size() == mMaxSize) {
            return;
        }
        mVertexList.add(new Vertex<>(value));
    }

    void addEdge(E start, E finish) {
        int startIndex = indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex == -1 || finishIndex == -1) {
            throw new NoSuchElementException("There is no such vertex in the graph");
        }

        mConnections[startIndex][finishIndex] = true;
        mConnections[finishIndex][startIndex] = true;
    }

    @SafeVarargs
    final void addEdges(E start, E second, E... others) {
        addEdge(start, second);
        for (E another : others) {
            addEdge(start, another);
        }
    }

    int indexOf(E value) {
        for (int i = 0; i < mVertexList.size(); i++) {
            if (mVertexList.get(i).getData().equals(value)) {
                return i;
            }
        }
        return -1;
    }

    void dfs() {
        if (mVertexList.size() == 0) {
            return;
        }
        int vertexIndex, j;
        Stack<Vertex<E>> stack = new Stack<>();
        Vertex<E> current, next;
        visitVertexStack(mVertexList.get(0), stack);

        while (!stack.isEmpty()) {
            current = stack.peek();
            vertexIndex = indexOf(current.getData());

            next = getNextUnvisited(vertexIndex);

            if (next == null) {
                stack.pop();
            } else {
                visitVertexStack(next, stack);
                System.out.printf("%s -> ", next);
            }
        }
        resetVertexes();
    }

    void bfs() {
        if (mVertexList.size() == 0) {
            return;
        }
        int vertexIndex, j;
        Vertex<E> current, next;
        Queue<Vertex<E>> queue = new LinkedList<>();
        visitVertexQueue(mVertexList.get(0), queue, null);

        while (!queue.isEmpty()) {
            current = queue.peek();
            vertexIndex = indexOf(current.getData());
            next = getNextUnvisited(vertexIndex);

            if (next == null) {
                queue.remove();
            } else {
                visitVertexQueue(next, queue, current);
                System.out.printf("%s -> ", next);
            }
        }
        resetVertexes();
    }

    void visitVertexStack(Vertex<E> vertex, Stack<Vertex<E>> stack) {
        stack.push(vertex);
        vertex.setVisited(true);
    }

    void visitVertexQueue(Vertex<E> vertex, Queue<Vertex<E>> queue, Vertex<E> previousNode) {
        queue.add(vertex);
        vertex.setVisited(true, previousNode);
    }


    List<E> findShortestPath(E start, E finish) {
        List<E> list = null;
        Vertex<E> startNode = mVertexList.get(indexOf(start));
        Vertex<E> finishNode = mVertexList.get(indexOf(finish));
        if ((mVertexList.size() == 0) || (startNode == null) || (finishNode == null)) {
            return null;
        }

        int vertexIndex;
        Vertex<E> current, next;
        Queue<Vertex<E>> queue = new LinkedList<>();
        visitVertexQueue(startNode, queue, null);

        while (!queue.isEmpty()) {
            current = queue.peek();
            vertexIndex = indexOf(current.getData());
            next = getNextUnvisited(vertexIndex);

            if (next == null) {
                queue.remove();
                continue;
            } else {
                visitVertexQueue(next, queue, current);
            }

            if (next.equals(finishNode)) {
                list = restoreWayBack(next);
                break;
            }
        }
        resetVertexes();
        return list;
    }

    private Vertex<E> getNextUnvisited(int vertexIndex) {
        for (int j = 0; j < mVertexList.size(); j++) {
            if (mConnections[vertexIndex][j] && !mVertexList.get(j).isVisited()) {
                return mVertexList.get(j);
            }
        }
        return null;
    }

    private List<E> restoreWayBack(Vertex<E> finishNode) {
        Vertex<E> vert;
        Stack<E> stack = new Stack<>();
        List<E> list = new ArrayList<>();

        vert = finishNode;
        while (vert != null) {
            stack.push(vert.getData());
            vert = vert.getPrevious();
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public void resetVertexes(){
        for (Vertex<E> vertex : mVertexList) {
            vertex.setVisited(false);
        }
    }
}
