package seson.third;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] arr={3,2,4,5,8,9,48,12,30,53,23,48,9,10,20,39,20,48};
        //sort.netherLandsFlag(arr,0,arr.length-1);
        sort.quickSort3(arr,0,arr.length-1);
        System.out.println(arr);
    }


    public void quickSort1(int[] arr,int L,int R){
        if (L>=R){
            return;
        }
        int M = partition(arr, L, R);
        quickSort1(arr,L,M-1);
        quickSort1(arr,M+1,R);
    }

    public void quickSort2(int[] arr,int L,int R){
        if (L>=R){
            return;
        }
        int[] landsFlag = netherLandsFlag(arr, L, R);
        quickSort2(arr,L,landsFlag[0]-1);
        quickSort2(arr,landsFlag[1]+1,R);
    }

    public void quickSort3(int[] arr,int L,int R){
        if (L>=R){
            return;
        }
        swap(arr,L+(int)(Math.random()*(R-L+1)),R);
        int[] landsFlag = netherLandsFlag(arr, L, R);
        quickSort3(arr,L,landsFlag[0]-1);
        quickSort3(arr,landsFlag[1]+1,R);
    }

    /**
     * 数据分区，将小于等于该数放在左边，大于放在该数右边
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public int partition(int[] arr,int L,int R){
        if (L>R){
            return -1;
        }
        if (L==R){
            return L;
        }
        int min=L-1;
        int index=L;
        while (index<=R){
            if (arr[index]>arr[R]){
                index++;
            }else {
                swap(arr,++min,index++);
            }
        }

        return min;
    }

    /**
     * 荷兰国旗问题 给定指定数字与数组，将大于该数的数放到该数的右边，小于放在左边
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public int[] netherLandsFlag(int[] arr,int L,int R){
        if (L>R){
            return new int[]{-1,-1};
        }
        if (L==R){
            return new int[]{L,R};
        }
        int less=L-1;
        int more=R;
        int index=L;
        while (index<more){
            if (arr[index]==arr[R]){
                index++;
            }else if(arr[index]<arr[R]){
                swap(arr,index++,++less);
            }else {
                swap(arr,index,--more);
            }
        }
        swap(arr,more,R);

        return new int[]{less+1,more};

    }


    public void swap(int[] arr,int L,int R){
        int x=arr[L];
        arr[L]=arr[R];
        arr[R]=x;
    }

}
