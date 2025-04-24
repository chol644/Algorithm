package week01;

import java.util.Arrays;

class sol_175533 {
    public int solution(int[] d, int budget) {
        int sum = 0;
        int answer = 0;
        Arrays.sort(d);


        for(int i=0; i<d.length;i++){
            sum += d[i];
            if(sum<=budget){
                answer++;
            }
        }
            return answer;
    }
}