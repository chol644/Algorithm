import java.util.*;

public class DFSBFS {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 노드 개수
        int m = scan.nextInt(); // 에지 개수
        int start = scan.nextInt(); // 시작점
        A = new ArrayList[n+1];

        for (int i=1;i<=n;i++){
            A[i] = new ArrayList<Integer>();
        }
        for( int i=0;i<m;i++){
            int s = scan.nextInt();
            int e = scan.nextInt();
            A[s].add(e);
            A[e].add(s);
        }
        // 정렬
        for(int i=1;i<=n;i++){
            Collections.sort(A[i]);
        }
        visited = new boolean[n+1];
        DFS(start);
        System.out.println();

        visited = new boolean[n+1];
        BFS(start);
        System.out.println();

    }
    public static void DFS(int Node){
        System.out.print(Node + " ");
        visited[Node] = true;
        for (int i : A[Node]){
            if (!visited[i]){
                DFS(i);
            }
        }
    }
    private static void BFS(int Node){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(Node);
        visited[Node] = true;

        while (!q.isEmpty()){
            int now = q.poll();
            System.out.print(now + " ");
            for (int i : A[now]) {
                if (!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

    }
}
















