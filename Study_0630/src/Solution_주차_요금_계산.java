import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_주차_요금_계산 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Record implements Comparable<Record> {
        int car, inMinute, total; // 차량번호, 입차 시각(분), 총 시간
        
        public Record(int car){
            this.car = car;
        }
        
        public int compareTo(Record o){
            return this.car - o.car;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> idx = new HashMap<>();
        
        StringTokenizer st;
        int index = 0;
        
        Record[] rcd = new Record[1001];
        
        for(int i = 0; i < records.length; i++){
            st = new StringTokenizer(records[i]);
            int minute = getMinute(st.nextToken());
            String car = st.nextToken();
            if(!idx.containsKey(car)){
                idx.put(car, index++);
            }
            int carIdx = idx.get(car);
            String inOut = st.nextToken();
            
            if(inOut.equals("IN")){
                if(rcd[carIdx] == null)
                    rcd[carIdx] = new Record(Integer.parseInt(car));
                
                rcd[carIdx].inMinute = minute;
                               
                
            } else {
                int in = rcd[carIdx].inMinute;
                rcd[carIdx].inMinute = -1;        // 00:00에 들어온 경우도 있으므로 0으로 초기화하면 안된다...
                rcd[carIdx].total += (minute - in);
            }
        }
        
        // 출차 내역 없는 경우 23:59 출차로 간주
        for(int i = 0; i < index; i++){
            if(rcd[i].inMinute != -1){
                rcd[i].total += (getMinute("23:59") - rcd[i].inMinute);
            }
        }
        
        // 차량 수 만큼 배열 복사 & 차량 번호 정렬
        Record[] result = Arrays.copyOf(rcd, index);
        Arrays.sort(result);
        int[] answer = new int[index];
        
        for(int i = 0; i < index; i++){
            answer[i] = fees[1];    // 기본 요금
            int total = result[i].total;
            if(total < fees[0]){
                continue;
            } else {    // 단위 요금 계산
                answer[i] += Math.ceil((float)(total - fees[0]) / fees[2]) * fees[3];
            }
        }
        
        return answer;
    }
    
    static int getMinute(String time){ 
        // 시각을 분으로 계산 후 반환
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]), minute = Integer.parseInt(t[1]);
        return hour * 60 + minute;
    }
}
