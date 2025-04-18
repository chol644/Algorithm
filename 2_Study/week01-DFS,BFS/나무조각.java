import java.util.*;

public class 나무조각 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5]; // 배열 생성
        boolean sort = false;
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }

        int temp = 0; // 임시 저장할 변수
        while (!sort) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) { // 위치 변경
                    temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;

                    for (int num : nums) {
                        System.out.print(num + " ");
                    }
                    System.out.println();;
                }
            }
            sort = true;
            for (int i = 0; i < 5; i++) {
                if (!(nums[i] == (i + 1))) {
                    sort = false;
                    break;
                }
            }
        }
    }
}
