import java.util.*;

class sol_49189 {
    public int solution(int n, int[][] graph) {
        // 그래프를 표현하는 인접 리스트
        List<List<Integer>> adjList = new ArrayList<>();

        // 인접 리스트 초기화
        // 노드가 n개 있으므로 n개의 빈 리스트 만들기
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // graph 배열 읽으면서 양방향 간선 추가
        // edge[0]이 edge[1]에 연결되고, edge[1]에도 edge[0] 연결
        for (int[] edge : graph) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // 방문 여부와 거리 배열 초기화
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);  // 거리 초기화 (-1로 설정)

        // BFS를 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        // 0번 노드 시작 세팅
        queue.offer(1); // 0번 노드 큐에 넣기
        visited[1] = true; // 0번 노드 방문 체크
        distance[1] = 0;  // 0번 노드는 자기 자신이니까 거리 0

        // BFS 탐색
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 노드에서 연결된 모든 노드 탐색
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        // 가장 멀리 떨어진 노드의 거리 찾기
        int maxDistance = 0;
        for (int dist : distance) {
            if (dist > maxDistance) {
                maxDistance = dist;
            }
        }

        // 가장 멀리 떨어진 노드 개수 세기
        int count = 0;
        for (int dist : distance) {
            if (dist == maxDistance) {
                count++;
            }
        }

        return count;
    }
}
