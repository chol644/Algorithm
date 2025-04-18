import java.util.*;

class Sequence {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> sumSet = new HashSet<>();

        // 부분 수열의 길이: 1부터 n까지
        for (int len = 1; len <= n; len++) {
            // 시작 인덱스: 0부터 n-1까지
            for (int start = 0; start < n; start++) {
                int sum = 0;

                // 원형 수열 인덱싱
                for (int i = 0; i < len; i++) {
                    sum += elements[(start + i) % n];
                    System.out.println("len:"+len+","+start+","+i+","+n + "=>"+((start + i) % n));
                }
                sumSet.add(sum); // 중복 없이 저장
            }
            System.out.println("--------------------------------");
        }

        return sumSet.size(); // 가능한 합의 개수 반환
    }
    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        int[] array = {7,9,1,1,4};
        sequence.solution(array);
    }
}
