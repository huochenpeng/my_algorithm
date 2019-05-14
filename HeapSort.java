package Problem;

/**
 * 〈一句话功能简述〉<br>
 * 〈堆排序〉
 *
 * @author Chenpeng
 * @create 2019/4/17
 * @since 1.0.0
 */
public class HeapSort {

    private static void heapAdjust(int[] list, int len, int i) {
        int k = i, temp = list[i], index = 2 * k + 1;
        while (index < len) {
            if (index + 1 < len) {
                if (list[index] < list[index + 1]) {
                    index = index + 1;
                }
            }
            if (list[index] > temp) {
                list[k] = list[index];
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }
        list[k] = temp;
    }


    public static void heapSort(int[] list) {
        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (list.length) / 2 - 1; i >= 0; i--) {
            heapAdjust(list, list.length, i);
        }
        //排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            heapAdjust(list, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] a={323,121,454534,321321,5465654,4};

        heapSort(a);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

}
