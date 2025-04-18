import java.io.*;
import java.util.*;

public class TwoSolutions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());; //용액 개수
        //-2 -4 -99 -1 98
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0; //좌측 포인터
        int right = num - 1; //우측 포인터
        int a = 0, b = 0;

        int[] solutions = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(solutions); // 오름차순 정렬

        while (left < right) {
            sum = solutions[left] + solutions[right]; //절댓값으로 저장
            if (Math.abs(sum) < result) { //합계가 현재 최소값보다 작으면 result에 저장
                result = Math.abs(sum);
                a = solutions[left];
                b = solutions[right];
            }
            if (sum < 0) { //합이 음수라면 큰수 더해야하므로 b를 오른쪽으로 이동
                left++;
            } else { //합이 양수라면 작은수 더해야하므로 a를 왼쪽으로 이동
                right--;
            }
        }
        if (a < b) {
            System.out.println(a + " " + b);
        } else {
            System.out.println(b + " " + a);
        }
    }
}
