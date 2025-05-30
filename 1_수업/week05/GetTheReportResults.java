package week05;
import java.util.*;

class GetTheReportResults {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 최종 결과 배열: 각 유저가 받은 "정지 알림 메일" 수를 담음
        int[] answer = new int[id_list.length];

        // 중복 신고 제거 (ex. "muzi frodo"가 여러 번 있어도 1번만 반영됨)
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));

        // 각 유저가 신고당한 횟수 저장 (신고받은 사람 기준)
        Map<String, Integer> reportCount = new HashMap<>();

        // 각 유저가 신고한 사람 리스트 저장 (신고한 사람 기준)
        Map<String, List<String>> iReportWho = new HashMap<>();

        // 신고 내역을 처리
        for (String s : reportSet) {
            String[] part = s.split(" "); // [신고자, 피신고자]
            String from = part[0]; // 신고한 사람
            String to = part[1];   // 신고당한 사람

            // 피신고자의 신고당한 횟수 증가
            reportCount.put(to, reportCount.getOrDefault(to, 0) + 1);

            // 신고한 사람이 누구를 신고했는지 기록
            iReportWho.putIfAbsent(from, new ArrayList<>());
            iReportWho.get(from).add(to);
        }

        // 각 유저가 신고한 사람들 중에서 "정지된 유저" 수를 세어서 메일 발송 수 기록
        for (int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i]; // 현재 유저

            // reporter라는 key가
            // 존재하면 → 그에 해당하는 List<String> (신고 대상 목록) 을 반환
            // 없으면 → 빈 리스트 new ArrayList<>()를 반환
            // reporter가 신고한 사람 목록 중
            for (String reportee : iReportWho.getOrDefault(reporter, new ArrayList<>())) {
                // 그 사람이 k번 이상 신고당해 정지되었다면
                if (reportCount.get(reportee) >= k) {
                    answer[i] += 1; // 알림 메일 1건 추가
                }
            }
        }

        return answer;
    }
}
