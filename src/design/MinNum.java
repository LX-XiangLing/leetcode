package design;

/**
 * @Author lixiang
 * @Date 2021/3/18
 *
 */
public class MinNum {
    public static int numSquares(int n) {
        int k=(int)Math.sqrt(n);
        int []dp=new int[n+1];
        int []pingfang=new int[k+1];
        for(int i=1;i<k+1;i++){
            pingfang[i]=i*i;
        }
        for(int i=1;i<n+1;i++){
            dp[i]=i;
        }
        for(int i=2;i<n+1;i++){
            for(int j=2;j<k+1;j++){
                if(pingfang[j]>i)continue;
                if(pingfang[j]<=i) {
                    int index=i/pingfang[j];
                    dp[i]=Math.min(dp[i], dp[i-index*pingfang[j]]+index);
                }
            }
        }
        return dp[n];
    }

}
