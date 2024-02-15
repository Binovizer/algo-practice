package algo.practice.v2.daily_coding_problem;

import java.util.*;

/**
 * The type P940
 *
 * @author nadeem Date : 15/02/24
 */
public class P940 {
    public int maxTime(int vertices, int[][] edges) {
        List<List<GraphNode<Integer, Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new GraphNode<>(edge[1], edge[2]));
            adjList.get(edge[1]).add(new GraphNode<>(edge[0], edge[2]));
        }

        Queue<GraphNode<Integer, Integer>> q = new LinkedList<>();
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;
        q.offer(new GraphNode<>(0, 0));

        while (!q.isEmpty()) {
            GraphNode<Integer, Integer> currentNode = q.remove();
            for (GraphNode<Integer, Integer> node : adjList.get(currentNode.vertex)) {
                int timeToReachNodeFromCurrentNode = currentNode.weight + node.weight;
                if (timeToReachNodeFromCurrentNode < distance[node.vertex]) {
                    distance[node.vertex] = timeToReachNodeFromCurrentNode;
                    q.offer(new GraphNode<>(node.vertex, timeToReachNodeFromCurrentNode));
                }
            }
        }

        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < vertices; i++) {
            maxTime = Math.max(maxTime, distance[i]);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        P940 p940 = new P940();
        int[][] edges =
                new int[][] {
                    {0, 1, 5}, {0, 2, 3}, {0, 5, 4}, {1, 3, 8}, {2, 3, 1}, {3, 5, 10}, {3, 4, 5}
                };
        int maxTime = p940.maxTime(6, edges);
        System.out.println("maxTime = " + maxTime);
    }
}
