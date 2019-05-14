package Problem;

/**
 * 〈一句话功能简述〉<br>
 * 〈基数排序〉
 *
 * @author Chenpeng
 * @create 2019/4/24
 * @since 1.0.0
 */
public class RadixSort {

    int get_max(int a[], int n)
    {
        int i, max;

        max = a[0];
        for (i = 1; i < n; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    void count_sort(int a[], int n, int exp)
    {
        int[] output=new int[n];             // 存储"被排序数据"的临时数组
        int i;
        int[] buckets=new int[10];

        // 将数据出现的次数存储在buckets[]中
        for (i = 0; i < n; i++)
            buckets[ (a[i]/exp)%10 ]++;

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (i = 1; i < 10; i++)
            buckets[i] += buckets[i - 1];

        // 将数据存储到临时数组output[]中
        for (i = n - 1; i >= 0; i--)
        {
            output[buckets[ (a[i]/exp)%10 ] - 1] = a[i];
            buckets[ (a[i]/exp)%10 ]--;
        }

        // 将排序好的数据赋值给a[]
        for (i = 0; i < n; i++)
            a[i] = output[i];
    }


    void radix_sort(int a[], int n)
    {
        int exp;    // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
        int max = get_max(a, n);    // 数组a中的最大值

        // 从个位开始，对数组a按"指数"进行排序
        for (exp = 1; max/exp > 0; exp *= 10)
            count_sort(a, n, exp);
    }

}
