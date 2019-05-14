package Problem;

/**
 * 〈一句话功能简述〉<br>
 * 〈选出数组中第k大的数〉
 *
 * @author Chenpeng
 * @create 2019/4/27
 * @since 1.0.0
 */
public class TopK {

    public static int partation(int[] arr,int low,int high){

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
        return i;

    }


    public static int topK(int[] a,int k){
        if(k<1||k>a.length){
            return -1;
        }
        int start=0;
        int end=a.length-1;
        int i=partation(a,start,end);

        while (i!=k-1){

            if(i<k-1){
                start=i+1;
                i=partation(a,i+1,end);

            }else{
                end=i-1;
                i=partation(a,start,i-1);

            }
        }

        return a[i];
    }


    public static void main(String[] args) {
        int[] a=new int[]{3,6,8,9,4,1,7};
        System.out.println(topK(a,2));
    }




}
