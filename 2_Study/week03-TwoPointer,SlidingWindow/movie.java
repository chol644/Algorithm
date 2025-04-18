import java.util.Scanner;

public class movie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // N = 세로 줄 수
        int M = sc.nextInt(); // M = 가로 줄 수
        int K = sc.nextInt(); // K = 동아리원 수
        sc.nextLine(); // 개행 문자 제거

        int total = 0; // 가능한 경우의 수 합계

        // N개의 줄(세로 방향) 만큼 반복
        for (int i = 0; i < N; i++) {
            String row = sc.nextLine(); // 각 줄의 좌석 상태
            int j = 0;

            // 가로 줄을 탐색하면서 연속된 '0' 찾기
            while (j < M) {
                if (row.charAt(j) == '0') {
                    int len = 0;

                    // 연속된 '0'의 개수를 세기
                    while (j < M && row.charAt(j) == '0') {
                        len++;
                        j++;
                    }

                    // 만약 연속된 '0'이 K 이상이면 앉을 수 있는 경우 계산
                    // 앉을 수 있는 경우의 수 = 연속된 0개수 - K + 1
                    if (len >= K) {
                        total += (len - K + 1);
                    }
                } else {
                    // '1'이면 그냥 다음 칸으로
                    j++;
                }
            }
        }

        // 결과 출력
        System.out.println(total);
    }
}
