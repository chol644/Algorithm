import java.util.*;

public class Coin_Change {
    public int coinChange(int[] coins, int amount) {
        // 큐 생성 (현재 금액, 동전 개수)
        Queue<Integer> queue = new LinkedList<>();
        // 방문 여부 배열
        boolean[] visited = new boolean[amount+1];
        // 큐에 0을 넣고, 0원을 만들기 위해서는 동전 0개 필요
        queue.offer(0);
        visited[0] = true;

        int coinCount = 0; // 동전 개수

        // BFS 탐색
        while (!queue.isEmpty()) {
            int size = queue.size();

            // 현재 레벨에서 모든 노드를 탐색
            for (int i = 0; i < size; i++) {
                int currentAmount = queue.poll();

                // 만약 현재 금액이 목표 금액이라면 반환
                if (currentAmount == amount) {
                    return coinCount;
                }

                // 현재 금액에서 모든 동전을 더해가며 탐색
                for (int coin : coins) {
                    int nextAmount = currentAmount + coin;

                    // 만약 nextAmount가 amount를 넘지 않고 방문하지 않았다면
                    if (nextAmount >= 0 && nextAmount <= amount && !visited[nextAmount]) {
                        visited[nextAmount] = true;
                        queue.offer(nextAmount);
                    }
                }
            }

            coinCount++; // 한 단계 끝났으므로 동전 개수 증가
        }

        // amount를 만들 수 없으면 -1 반환
        return -1;
    }
}