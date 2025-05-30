package week05;
import java.util.*;

class GameMap {
    public int solution(int[][] maps) {
        int n = maps.length;        // 행의 개수 (세로 크기)
        int m = maps[0].length;     // 열의 개수 (가로 크기)

        boolean[][] visited = new boolean[n][m];  // 방문 여부를 체크할 배열
        Queue<int[]> queue = new ArrayDeque<>();  // BFS 탐색을 위한 큐

        // 시작 지점 (0,0)부터 탐색 시작. 시작 위치까지의 거리 = 1
        queue.add(new int[]{ 0, 0, 1 });
        visited[0][0] = true;

        // 상하좌우 방향 벡터 정의 (← ↓ → ↑ 순서)
        int[] dr = { 0, 1, 0, -1 };  // 행 방향
        int[] dc = { -1, 0, 1, 0 };  // 열 방향

        // BFS 탐색 시작
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();     // 현재 위치와 거리 꺼내기
            int r = cur[0];  // 현재 행
            int c = cur[1];  // 현재 열
            int dist = cur[2];  // 현재까지 이동한 거리

            // 도착 지점에 도달한 경우, 거리 반환
            if (r == n - 1 && c == m - 1) {
                return dist;
            }

            // 4방향을 차례로 확인
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];  // 다음 행
                int nc = c + dc[d];  // 다음 열

                // 배열 범위를 벗어나지 않고, 이동할 수 있는 칸(1)이며, 아직 방문하지 않았다면
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;                 // 방문 표시
                        queue.add(new int[]{ nr, nc, dist + 1 });  // 큐에 다음 위치와 거리 추가
                    }
                }
            }
        }

        // 도착 지점에 도달하지 못한 경우 -1 반환
        return -1;
    }
}
