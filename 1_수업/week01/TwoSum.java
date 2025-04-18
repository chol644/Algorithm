package week01;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //정수 숫자 배열과 정수 목표가 주어졌을 때, 두 숫자의 인덱스를 반환하여 목표를 달성합니다.
        // 각 입력에 정확히 하나의 솔루션이 있다고 가정할 수 있으며, 동일한 요소를 두 번 사용할 수는 없습니다.
        // 답변은 어떤 순서로든 반환할 수 있습니다.
        int[] result = new int[2];

        for (int i=0; i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                int sum =0;
                sum =nums[i]+nums[j];
                if(i != j && sum==target){
                    result[0]=i;
                    result[1]=j;
                    System.out.println(result[0]+" "+result[1]);
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        System.out.println(ts.twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
