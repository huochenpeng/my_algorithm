package Problem;

/**
 * 〈一句话功能简述〉<br>
 * 〈快速排序的递归实现〉
 *
 * @author Chenpeng
 * @create 2019/4/17
 * @since 1.0.0
 */
public class QuickSort01 {



    public static void quickSort(int[] arr,int low,int high){

        int i=low;
        int j=high;
        int temp=arr[low];
        int t;

        while(i<j){
            while(temp<=arr[j]&&i<j){
                j--;
            }
            while(temp>=arr[i]&&i<j){
                i++;
            }

            if(i<j){
                t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }

        arr[low]=arr[i];
        arr[i]=temp;
        if(low<j-1)
            quickSort(arr, low, j - 1);
        if(j+1<high)
            quickSort(arr,j+1,high);

    }


    public static void main(String[] args) {

        int[] a={323,121,454534,321321,5465654,4};

        quickSort(a,0,a.length-1);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }


}
