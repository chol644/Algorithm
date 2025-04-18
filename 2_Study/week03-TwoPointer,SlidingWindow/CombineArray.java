import java.util.*;
import java.io.*;


public class CombineArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int[] inputA = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] inputB = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt) //문자열을 int로 변경
                .toArray();

        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;
        //두 포인터가 배열 끝에 도달하지 않았을 때 계속 반복
        //inputA[i]와 inputB[j] 값을 비교해서 더 작은 값을 출력 배열에 넣는다.
        //append()를 하면서 동시에 i++ 또는 j++로 포인터도 한 칸 이동.
        while (i < n && j < m) {
            if (inputA[i] <= inputB[j]) {
                sb.append(inputA[i++]).append(" ");
            } else {
                sb.append(inputB[j++]).append(" ");
            }
        }
        // 남은 요소 처리
        while (i < n) sb.append(inputA[i++]).append(" ");
        while (j < m) sb.append(inputB[j++]).append(" ");

        System.out.println(sb);
    }
}
