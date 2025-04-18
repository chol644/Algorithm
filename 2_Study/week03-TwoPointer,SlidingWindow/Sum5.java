import java.util.Scanner;

public class Sum5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 1;
        int count = 1; // 자기 자신것

        int startNum =1;
        int endNum=1;

        while(startNum > n || endNum<n){
            if (sum>n){
                sum-=startNum;
                startNum++;
            } else if (sum < n) {
                endNum++;
                sum+=endNum;
            }else{
                endNum++;
                sum+=endNum;
                count++;
            }
        }
        System.out.println(count);
    }
}
