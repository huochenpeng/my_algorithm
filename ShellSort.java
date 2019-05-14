package Problem;

/**
 * 〈一句话功能简述〉<br>
 * 〈希尔排序〉
 *
 * @author Chenpeng
 * @create 2019/4/24
 * @since 1.0.0
 */
public class ShellSort {

    public static void sort(int[] a) {
        int inc=a.length;

        while(true) {
            inc = a.length / 2;
            for (int i = 0; i < inc; i++) {
                for (int j = i + inc; j < a.length; j = j + inc) {
                    int m = j;
                    int temp = a[j];
                    while (m > i && temp < a[m - inc]) {
                        a[m] = a[m - inc];
                        m-=inc;
                    }
                    a[m] = temp;
                }
            }
            if(inc==1)
                break;
        }
    }


}
