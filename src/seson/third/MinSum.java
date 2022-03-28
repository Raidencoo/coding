package seson.third;

/**
 * 求最小和
 */
public class MinSum {

    public static void main(String[] args) {
        int[] x={1,2,3,5};

        System.out.println(sum(x,0,x.length-1));

    }

    public static int sum(int[] arr,int L,int R){
        if (L==R){
            return 0;
        }
        int M=L+((R-L)>>1);

        return  sum(arr,L,M)+sum(arr,M+1,R)+merge(arr,L,R,M);
    }



    public static int merge(int[] arr,int L,int R,int M){
        int[] help=new int[R-L+1];
        int i=0;
        int p1=L;
        int p2=M+1;
        int sum=0;
        while (p1<=M &&p2<=R ){
            sum+=arr[p1]< arr[p2]?(R-p2+1)*arr[p1]:0;
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=M){
            help[i++]=arr[p1++];
        }
        while (p2<=R){
            help[i++]=arr[p2++];
        }
        for (i = 0;  i< help.length; i++) {
            arr[L+i]=help[i];
        }
        return sum;

    }
}
