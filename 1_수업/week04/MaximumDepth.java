package week04;

// 이진 트리 노드 정의
class TreeNode {
    int val;              // 노드의 값
    TreeNode left;        // 왼쪽 자식 노드
    TreeNode right;       // 오른쪽 자식 노드

    // 생성자
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        // 노드가 null이면 0 (더 이상 내려갈 곳 없음)
        if (root == null) return 0;

        // 왼쪽 자식의 최대 깊이를 재귀적으로 계산
        int leftDepth = maxDepth(root.left);

        // 오른쪽 자식의 최대 깊이를 재귀적으로 계산
        int rightDepth = maxDepth(root.right);

        // 현재 노드의 깊이는 둘 중 더 깊은 쪽에 +1 한 값
        return 1 + Math.max(leftDepth, rightDepth);
    }
}

// 실행용 main 클래스
public class MaximumDepth {
    public static void main(String[] args) {

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node3 = new TreeNode(3, null, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        // Solution 클래스 사용
        Solution solution = new Solution();
        int depth = solution.maxDepth(root);

        // 결과 출력
        System.out.println("최대 깊이: " + depth);  // 출력: 최대 깊이: 3
    }
}
