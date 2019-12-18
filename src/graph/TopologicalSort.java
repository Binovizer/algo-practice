package graph;

import java.util.ArrayList;
import java.util.Stack;

class TopologicalSort {

    public int[] topologicalSort(ArrayList<ArrayList<Integer>> list, int N) {
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topologicalSortUtil(list, i, visited, stack);
            }
        }
        int i = 0;
        int[] ans = new int[N];
        while (!stack.empty()) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    private void topologicalSortUtil(ArrayList<ArrayList<Integer>> list, int v, boolean[] visited,
                                     Stack<Integer> stack) {
        visited[v] = true;
        ArrayList<Integer> edges = list.get(v);
        for (Integer edge : edges) {
            if (!visited[edge]) {
                topologicalSortUtil(list, edge, visited, stack);
            }
        }
        stack.push(v);
    }
}
