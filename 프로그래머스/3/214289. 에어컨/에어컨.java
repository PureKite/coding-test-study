import java.util.Arrays;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        final int offset = 10;
        final int temp_size = 51;
        final int INF = Integer.MAX_VALUE / 2;
        
        int T = onboard.length;
        
        int[][] dp = new int[T][temp_size];
        for(int[] row : dp){
            Arrays.fill(row, INF);
        }
        
        dp[0][temperature + offset] = 0;
        
        for(int t = 0; t < T - 1; t++){
            for(int temp = 0; temp < temp_size; temp++){
                if(dp[t][temp] == INF) continue;
                
                int currTemp = temp - offset;
                
                int cost = dp[t][temp];
                
                int nextTempOff;
                if(currTemp < temperature) nextTempOff = currTemp + 1;
                else if(currTemp == temperature) nextTempOff = currTemp;
                else nextTempOff = currTemp - 1;
                
                if(onboard[t + 1] == 0 || (t1 <= nextTempOff && nextTempOff <= t2)) {
                    dp[t + 1][nextTempOff + offset] = Math.min(dp[t + 1][nextTempOff + offset], cost);
                }
                
                for(int w = t1; w <= t2; w++) {
                    int power = (currTemp != w) ? a : b;
                    
                    int nextTempOn;
                    if(currTemp < w) nextTempOn = currTemp + 1;
                    else if(currTemp > w) nextTempOn = currTemp - 1;
                    else nextTempOn = currTemp;
                    
                    if(onboard[t+1] == 0 || (t1 <= nextTempOn && nextTempOn <= t2)){
                        dp[t+1][nextTempOn + offset] = Math.min(dp[t+1][nextTempOn + offset], cost+power);
                    }
                }
            }
        }
        
        int answer = INF;
        for(int temp = 0; temp<temp_size; temp++){
            answer = Math.min(answer, dp[T-1][temp]);
        }
        return answer;
    }
}