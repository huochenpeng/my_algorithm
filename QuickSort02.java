package Problem;

import java.util.Stack;

/**
 * 〈一句话功能简述〉<br>
 * 〈快速排序的非递归实现〉
 *
 * @author Chenpeng
 * @create 2019/4/17
 * @since 1.0.0
 */
public class QuickSort02 {

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

    public static void quickSort(int[] arr){

        if(arr.length==1)
            return;
        Stack<Integer> stack=new Stack<>();
        int i,j;
        stack.push(arr.length-1);
        stack.push(0);

        while(!stack.empty()){
            i=stack.pop();
            j=stack.pop();
            if(i<j){
                int k=partation(arr,i,j);
                if(k>i){
                    stack.push(k-1);
                    stack.push(i);
                }

                if(j>k){
                    stack.push(j);
                    stack.push(k+1);
                }
            }
        }


    }

    public static void main(String[] args) {

        int[] a={323,121,454534,321321,5465654,4};

        quickSort(a);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }


}
