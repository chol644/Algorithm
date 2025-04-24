package week01;

public class sol_42584 {
    //- prices 길이만큼 반복하며 다음 아이템이 현재 아이템 수보다 작을 때까지 반복(2중 for)
//- 배열 순회하면서 현재보다 값이 같거나 크면 카운트+1, 아이템보다 작은 값이 있으면 break
//            - 한 아이템이 순회가 끝나면 result 배열에 카운트 값 입력

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int count =0;
        for (int i=0;i< prices.length-1;i++) {
            count =1;
            for(int j=i+1;j< prices.length-1;j++){
                if(prices[j]>=prices[i]){
                    count++;
                }else break;
            }
            answer[i]=count;
        }answer[answer.length-1]=0;
        return answer;
    }
}
