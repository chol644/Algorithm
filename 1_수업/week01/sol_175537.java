package week01;

import java.util.Arrays;

public class sol_175537 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        sol_175537 sol = new sol_175537();
        String[] arr = {"119", "97674223", "1195524421"};
        sol.solution(arr);
    }
}
