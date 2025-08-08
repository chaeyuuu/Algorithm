package DP;
import java.io.*;
import java.util.*;

public class boj11053 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];
        int result = 0;
       
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];

        for(int i=0; i<N;i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if (inputs[j] < inputs[i]) {
                       dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}