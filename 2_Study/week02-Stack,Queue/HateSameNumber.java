import java.util.*;
public class HateSameNumber {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0;i<arr.length;i++){
            if(i==0){
                queue.offer(arr[i]);
            }else{
                if(!(arr[i-1]==arr[i])){
                    queue.offer(arr[i]);
                }
            }

        }
        int[] answer = new int[queue.size()];
        for (int i=0; i<answer.length;i++){
            answer[i]=queue.poll();
        }

        return answer;
    }
}
