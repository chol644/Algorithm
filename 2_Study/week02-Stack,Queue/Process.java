import java.util.*;

public class Process {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<int[]>();

        // 큐에 (index, priority) 형태로 저장
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            boolean higherNum = false;

            // 현재 큐에 더 높은 우선순위가 있는지 확인
            for (int[] item : q) {
                if (item[1] > current[1]) {
                    higherNum = true;
                    break;
                }
            }

            // 더 높은 우선순위 있는 경우 다시 뒤로 보냄
            if (higherNum) {
                q.add(current);
            } else { // 현재 current가 우선순위 가장 높을 경우 return
                answer++;
                if (current[0] == location) { //입력받은 location과 index 값 비교
                    System.out.println(answer);
                    return answer;
                }
            }
        }
        return answer;
    }
}
