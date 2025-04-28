import java.util.LinkedList;
import java.util.Queue;

public class sol_43163 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(begin);

        for (String word : words) {
            canChange(begin, word);
        }

        return answer;
    }

    // 두 단어가 한 글자만 다른지 체크하는 함수 생성
    // 다른 글자가 딱 하나인 경우 true 반환
    boolean canChange(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
