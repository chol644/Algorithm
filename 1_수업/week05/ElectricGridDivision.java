package week05;
import java.util.*;

class ElectricGridDivision {
    public int solution(int n, int[][] wires) {
        // 1. 인접 리스트로 그래프 초기화 (0번은 사용 안 하므로 n+1 크기)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); // 각 노드의 연결 노드 저장용 빈 리스트 추가
        }

        // 2. wires 배열을 바탕으로 양방향 간선 연결
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b); // a번 노드에 b 연결
            graph.get(b).add(a); // b번 노드에 a 연결
        }

        // 3. 최소 차이를 저장할 변수 (가장 큰 값으로 초기화)
        int minDiff = Integer.MAX_VALUE;

        // 4. 모든 간선을 하나씩 끊어보면서 두 네트워크로 나눠보기
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            // 간선 끊기 (양방향이므로 둘 다 제거)
            graph.get(a).remove((Integer) b);
            graph.get(b).remove((Integer) a);

            // 한쪽 네트워크 크기 구하기 (a 기준으로 DFS 탐색)
            boolean[] visited = new boolean[n + 1]; // 방문 여부 체크용
            int count = dfs(a, graph, visited);     // 끊은 상태에서 연결된 노드 수 세기

            // 두 네트워크 크기의 차이 = 전체 노드 - count - count
            // 예: 전체 9개, 한쪽이 4개면 → 다른 쪽은 5개 → 차이 = 1
            int diff = Math.abs(n - count - count);

            // 최소 차이로 갱신
            minDiff = Math.min(minDiff, diff);

            // 간선 원상복구 (그래프 되돌리기)
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 최솟값 반환
        return minDiff;
    }

    // DFS로 연결된 노드 수 세기
    private int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true; // 현재 노드 방문 표시
        int count = 1;        // 자기 자신도 세니까 1부터 시작

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                count += dfs(next, graph, visited); // 방문하지 않은 이웃 노드 재귀 탐색
            }
        }

        return count; // 현재 노드를 기준으로 연결된 노드 수 반환
    }
}