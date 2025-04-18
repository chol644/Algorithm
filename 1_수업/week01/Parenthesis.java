package week01;

public class Parenthesis {
    boolean Parenthesis(String s) {
        boolean answer = true;
        int left =0;
        int right=0;

        if(s.charAt(0)!='('){
            return false;
        }else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') left++;
                else right++;
            }
            if (left == right)
                answer = true;
            else answer = false;
            return answer;
        }
    }
}
