import java.util.*;

class Solution {

    public int toMin(String timeStr) {
        String[] t = timeStr.split(":");
        int hour = Integer.parseInt(t[0]);
        int min = Integer.parseInt(t[1]);
        return (hour * 60 + min);
    }

    public int[] solution(int[] fees, String[] records) {
        // records는 시각을 기준으로 오름차순 정렬

        // 차량 번호 별로 배열 s생성
        // 어차피 입차 후에 출차니까 차량별로 순서대로 배열에 추가
        // 하나의 쌍임
        // 만약에 배열에 하나가 남아있으면 출차 안 한것 -> 23:59

        // 따옴표는 제거하고
        // 차량 기준으로 번호들 저장.
        // ex) 0000 : 06:00, 06:34, 18:59

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for (String record : records) {
            String[] info = record.split(" "); // 공백으로 자름
            String timeStr = info[0];
            String carNum = info[1];

            int time = toMin(timeStr);

            if (!map.containsKey(carNum)) {
                map.put(carNum, new ArrayList<>());
            }
            map.get(carNum).add(time);
        }

        // ex) 0000 : 06:00, 06:34, 18:59
        // 위에처럼 되어있으면
        // 반복문 돌면서
        // 시간을 분으로 치환 + 분은 거기에 더해주기
        // 빼기
        // 하나 남으면 그건 23:59랑 계산
        int[] results = new int[map.size()];

        // System.out.println(map.size());

        // 작은 차 번호부터 해야하니까 List에 담아서 정렬
        List<String> carNumbers = new ArrayList<>(map.keySet());
        Collections.sort(carNumbers); // 오름차순으로 정렬

        int defaultTime = fees[0];
        int defaultPrice = fees[1];
        int partTime = fees[2];
        int partPrice = fees[3];

        // 차량의 개수만큼 돌면서 누적 시간 계산
        for (int i = 0; i < map.size(); i++) {
            // 자동차 번호 하나마다 누적시간 갱신
            ArrayList<Integer> times = map.get(carNumbers.get(i)); // 차별로 시간들 담아놓을 배열
            int countTime = 0; // 누적시간

            // 누적시간 구하는 공식
            // map(i)의 arraylist에 저장되어있는거 계산
            for (int j = 0; j < times.size() - 1; j += 2) {
                countTime += (times.get(j + 1) - times.get(j));
            }

            if (times.size() % 2 == 1) {
                int max = toMin("23:59");
                countTime += max - times.get(times.size() - 1);
            }

            if (countTime <= defaultTime) {
                // 기본 시간보다 적게 주차했으면
                results[i] = (defaultPrice);
            } else if (countTime > defaultTime) {
                // 기본시간보다 적게 안했으면
                int extraFee = (int) Math.ceil((double) (countTime - defaultTime) / partTime) * partPrice;
                results[i] = extraFee + defaultPrice;
            }

        }

        // 차량번호가 작은 수부터 return
        return results;
    }
}