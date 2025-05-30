package week05;
import java.util.*;

class ToRotateParentheses {
    // 올바른 괄호 문자열인지 판별하는 함수
    boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();

        for (char current : s.toCharArray()) {
            // 여는 괄호는 스택에 push
            if (current == '(' ||  current == '{' ||  current == '[') {
                stack.push(current);
            } else {
                // 닫는 괄호인데 스택이 비어있으면 잘못된 괄호
                if (stack.isEmpty()) return false;

                // 가장 최근 여는 괄호 꺼냄
                char target = stack.pop();

                // 짝이 맞지 않으면 false
                if ((target == '(' && current != ')') ||
                        (target == '{' && current != '}') ||
                        (target == '[' && current != ']')) {
                    return false;
                }
            }
        }

        // 모두 처리한 뒤에 스택이 비어 있어야 올바른 괄호
        return stack.isEmpty();
    }

    public int solution(String s) {
        // 회전을 쉽게 하기 위해 문자열을 2번 이어붙임
        String doubleS = s + s;
        int answer = 0;

        // s의 길이만큼 회전하며 체크
        for(int i = 0; i < s.length(); i++){
            // i번째 회전된 문자열 추출
            String rotated = doubleS.substring(i, i + s.length());

            // 해당 문자열이 올바른 괄호이면 카운트 증가
            if (isValid(rotated)) answer++;
        }

        return answer;
    }
}
