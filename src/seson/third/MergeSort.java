package seson.third;

public class MergeSort {


    public static void main(String[] args) {
        int[] x={1,2,7,10,8,2,4,5,9,3};

        mergeSort(x,0,x.length-1);

        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]+",");
        }
    }


    public static void mergeSort(int[] arr,int L,int R){
        if (L==R){
            return;
        }
        int mid=L+((R-L)>>1);
        mergeSort(arr,L,mid);
        mergeSort(arr,mid+1,R);
        merge(arr,L,R,mid);

    }

    private static void merge(int[] arr, int L, int R, int mid) {
        int[] help=new int[R-L+1];
        int i=0;
        int p1=L;
        int p2=mid+1;
        while (p1<=mid&&p2<=R){
            help[i++]=arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=R){
            help[i++]=arr[p2++];
        }
        for (i = 0;  i< help.length; i++) {
            arr[L+i]=help[i];
        }

    }
}
