package week05;
import java.util.*;

class ChangeWord {
    // 단어 상태와 변환 횟수를 담는 클래스
    class Word {
        String word; // 현재 단어
        int count;   // 지금까지 변환 횟수

        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    // 두 단어 간 글자 차이가 몇 개인지 계산하는 함수
    int getDiffCount(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        return count; // 한 글자만 다르면 1 반환
    }

    public int solution(String begin, String target, String[] words) {
        // BFS를 위한 방문 체크와 큐 초기화
        Set<String> visited = new HashSet<>();
        Queue<Word> queue = new ArrayDeque<>();

        // 시작 단어 큐에 추가 (변환 횟수 0부터 시작)
        queue.offer(new Word(begin, 0));
        visited.add(begin);

        // BFS 수행
        while (!queue.isEmpty()) {
            Word cur = queue.poll(); // 현재 상태 꺼냄

            // target에 도달하면 현재까지의 변환 횟수 반환
            if (cur.word.equals(target)) {
                return cur.count;
            }

            // 다음 단어 탐색 (한 글자만 다른 단어만 연결)
            for (String next : words) {
                // 현재 단어와 한 글자만 다른 경우만 다음 후보
                if (getDiffCount(cur.word, next) == 1) {
                    // 방문하지 않은 단어만 큐에 추가
                    if (!visited.contains(next)) {
                        queue.offer(new Word(next, cur.count + 1));
                        visited.add(next);
                    }
                }
            }
        }

        // target 단어에 도달하지 못하면 0 반환
        return 0;
    }
}
