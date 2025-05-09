package week03;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyCar {
    public int solution(int[][] city) {
        int m= city.length; // 행 길이
        int n= city[0].length; // 열 길이

        // 시작점이나 도착점이 막힌 경우
        if (city[0][0] == 1 || city[m - 1][n - 1] == 1) return -1;

        // 8방향 이동 (상하좌우 + 대각선)
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        // 시작점 넣기(0,0), 이동한거리 =1
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            // 도착 지점 도달
            if (x == m - 1 && y == n - 1) {
                return dist;
            }

            // 8방향 탐색
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (!visited[nx][ny] && city[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        // 도달 불가능
        return -1;
    }

}
