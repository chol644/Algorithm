import java.util.*;

public class Zero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int k = sc.nextInt();
        int sum = 0;

        for (int i = 0; i < k; i++) {
            int num = sc.nextInt();
            if (num != 0) { // 0이 아닌경우 push
                stack.push(num);
            } else stack.pop(); // 0인경우 pop
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);

 }
}
