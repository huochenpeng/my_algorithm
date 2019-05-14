package Problem;

/**
 * 〈一句话功能简述〉<br>
 * 〈01背包问题〉
 *
 * @author Chenpeng
 * @create 2019/4/21
 * @since 1.0.0
 */
public class ZeroOnePack {


    /**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param p 表示商品价值数组
     * @return
     */
    public static int[][] back_Solution(int m,int n,int[] w,int p){
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(w[i-1]<=j){
                    dp[i][j]=Math.min(dp[i-1][j-w[i-1]]+w[i-1],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp;
    }



}
