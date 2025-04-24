package week01;

import java.util.Arrays;

public class sol_175535 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i=0;i<participant.length-1;i++){
            if(participant[i].equals(completion[i])){
                System.out.println(participant[i]);
                System.out.println(completion[i]);
            }else {
                return participant[i];
            }
        }
        return participant[participant.length-1];
    }
}