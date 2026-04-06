class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        // : 기준으로 분리
        // 0 ≤ mm ≤ 59
        // 0 ≤ ss ≤ 59
        
        int videoSeconds = toSec(video_len);
        int posSeconds = toSec(pos);
        int opStartSeconds = toSec(op_start);
        int opEndSeconds = toSec(op_end);
        
        // 오프닝 범위 체크
        if(posSeconds >= opStartSeconds && posSeconds <= opEndSeconds){
            posSeconds = opEndSeconds;
        }
        
        for(String command: commands){

            if (command.equals("next")){
                if(posSeconds + 10 > videoSeconds){
                    // 10초 더한게 영상보다 길 경우
                    posSeconds = videoSeconds;
                } else {
                    posSeconds += 10;
                }
            } else if (command.equals("prev")){
                if(posSeconds - 10 < 0){
                    posSeconds = 0;
                } else{
                    posSeconds -=10;
                }
            }
            
            // 오프닝 범위 체크
            if(posSeconds >= opStartSeconds && posSeconds <= opEndSeconds){
                posSeconds = opEndSeconds;
            }
        }
        
        return String.format("%02d:%02d", posSeconds / 60, posSeconds % 60);
    }
    
    private int toSec(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }

}