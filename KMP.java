package Problem;

/**
 * 〈一句话功能简述〉<br>
 * 〈字符串匹配的KMP算法〉
 *
 * @author Chenpeng
 * @create 2019/4/21
 * @since 1.0.0
 */
public class KMP {

    /**
     * @param ps 模式串
     * @return
     */
    public static int[] getNext(String ps){
        char[] p=ps.toCharArray();
        int[] next=new int[p.length];
        next[0]=-1;
        int j=0;
        int k=-1;
        while(j<p.length-1){
            if(k==-1||p[j]==p[k]){
                next[++j]=++k;
            }else{
                k=next[k];
            }
        }
        return next;
    }


    /*
     * @param ts 主串
     * @param ps  模式串
     * @return
     */
    public static int KMP(String ts,String ps){
        char[] t=ts.toCharArray();
        char[] p=ps.toCharArray();
        int i=0;
        int j=0;
        int[] next=getNext(ps);
        while(i<t.length&&j<p.length){
            if(j==-1||t[i]==p[j]){
                i++;
                j++;
            }else{
                j=next[j];
            }
        }

        if(j==p.length){
            return i-j;
        }else{
            return -1;
        }
    }

}
