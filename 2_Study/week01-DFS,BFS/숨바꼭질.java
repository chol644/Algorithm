import java.util.*;

public class 숨바꼭질 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수빈 위치
        int K = sc.nextInt(); // 동생 위치
        System.out.println(bfs(N, K)); // BFS 실행
    }

    public static int bfs(int N, int K) {
        if (N == K) return 0; // 시작 위치와 목표 위치가 같으면 0초

        boolean[] visited = new boolean[100001]; // 방문 체크 배열(0~100000)
        Queue<int[]> queue = new LinkedList<>(); // BFS 큐 (위치, 시간)

        queue.add(new int[]{N, 0}); // 현재 수빈 위치, 현재시간 0
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0]; // 변경된 수빈 위치
            int time = current[1]; // 시간

            // 이동 가능한 3가지 경우(-1,+1,x2)
            int[] nextPositions = {position - 1, position + 1, position * 2};

            for (int next : nextPositions) {
                if (next == K) return time + 1; // 동생을 찾으면 즉시 반환
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, time + 1});
                }
            }
        }
        return -1; // 도달할 수 없는 경우 (이론적으로는 발생하지 않음)
    }
}
