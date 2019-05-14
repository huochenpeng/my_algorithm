package Problem;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br>
 * 〈旋转数组的二分查找〉
 *
 * @author Chenpeng
 * @create 2019/4/21
 * @since 1.0.0
 */
public class BinarySearch {


    public static ArrayList<Integer> list=new ArrayList<>();

    public static int isExist(int[] A,int key,int start,int end){

        if(start<0||end>A.length-1||start>end)
            return -1;
        int flag=-1;
        int mid=(start+end)/2;
        if(key==A[mid]){
            flag=mid;
        }else if(key<A[mid]){
            if(A[start]==A[mid]){
                flag=isExist(A,key,mid+1,end);
                list.add(mid+1);
                list.add(end);
            }else if(A[mid]>A[start]){
                if(key==A[start]) {
                    flag=start;
                }else if(key>A[start]){
                    flag=isExist(A,key,start,mid-1);
                    list.add(start);
                    list.add(mid-1);
                }else{
                    flag=isExist(A,key,mid+1,end);
                    list.add(mid+1);
                    list.add(end);
                }

            }else{
                flag=isExist(A,key,start,mid-1);
                list.add(start);
                list.add(mid-1);
            }
        }else{
            if(A[end]==A[mid]){
                flag=isExist(A,key,start,end-1);
                list.add(start);
                list.add(end-1);
            }else if(A[mid]<A[end]){
                if(key==A[end]){
                    flag=end;
                }else if(key>A[end]){
                    flag=isExist(A,key,start,mid-1);
                    list.add(start);
                    list.add(mid-1);
                }else{
                    flag=isExist(A,key,mid+1,end);
                    list.add(mid+1);
                    list.add(end);
                }
            }else{
                flag=isExist(A,key,mid+1,end);
                list.add(mid+1);
                list.add(end);
            }
        }

        return flag;
    }


    public static void main(String[] args) {
        int[] a=new int[]{7,8,9,10,1,2,3};
        System.out.println(isExist(a,10,0,a.length-1));
        for(Integer i:list){
            System.out.println(i);
        }
    }


}
