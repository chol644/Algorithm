import java.util.*;

class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        // 처음에는 모든 노드를 '미정' 상태 (-1)로 설정
        Arrays.fill(color, -1);

        // 그래프가 끊겨있는 경우가 있기 때문에 모든 노드 체크 필요
        for (int i = 0; i < n; i++) {
            // 아직 색칠이 되어있지 않으면 BFS 실행
            if (color[i] == -1) {
                // BFS를 위한 큐 생성
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i); // 시작 노드 i 큐에 넣기
                color[i] = 0; // 색 0으로 시작

                while (!queue.isEmpty()) {
                    // 큐에서 노드 하나 꺼내서 u에 저장.
                    // 이 노드를 기준으로 이웃 확인
                    int u = queue.poll();
                    // u의 모든 이웃노드 v에 대해서 반복
                    for (int v : graph[u]) {
                        // 이웃노드 v가 아직 방문 안한 상태라면
                        if (color[v] == -1) {
                            // 현재 색과 반대인 색으로 칠하기
                            color[v] = 1 - color[u];
                            // v를 큐에 넣어서 v도 나중에 이웃 탐색
                            queue.offer(v);
                        } else if (color[v] == color[u]) {
                            // 이웃 노드가 같은 색이면 이분 그래프 아님
                            return false;
                        }
                    }
                }
            }
        }
        // 모든 노드가 문제 없이 색칠되었으면 이분 그래프
        return true;
    }
}
