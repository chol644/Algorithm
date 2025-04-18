import java.util.*;

public class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // {sum, index}

        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int sum = current[0]; // sum
            int index = current[1]; // index

            if (index == numbers.length) {
                if (sum == target) count++;
            } else {
                queue.add(new int[]{sum + numbers[index], index + 1});
                queue.add(new int[]{sum - numbers[index], index + 1});
            }
        }
        return count;
    }
}