import java.util.*;

public class RestaurantLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = 0; //가장 줄이 길 때
        int lastNum = 100; //제일 작은 마지막 번호
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            if (type == 1) { //1일때 학생num 받고, 큐에 추가
                int stuNum = sc.nextInt();
                q.offer(stuNum);
            } else if (q.size()>0 && type == 2) { //2일때 꺼내기
                q.poll();
            }

            if (q.size() > size) { //큐 크기가 더 크면 최대값 저장
                size = q.size();
                if (!q.isEmpty()) { //큐가 비어있지 않을 때 마지막 값 저장
                    lastNum = ((LinkedList<Integer>) q).peekLast();
                }
            } else if (q.size() == size && !q.isEmpty()) {
                int lastQ = ((LinkedList<Integer>) q).peekLast();
                if (lastNum > lastQ) {
                    lastNum = lastQ;
                }
            }

        }

        System.out.println(size+ " " + lastNum);
    }
}
