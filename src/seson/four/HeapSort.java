package seson.four;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr={1,2,7,10,8,2,4,5,9,3};
        heapSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }


    public static void heapSort(int[] arr){

        Heap heap = new Heap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            heap.push(arr[i]);
        }

        for (int i = arr.length-1; i>=0; i--) {
            arr[i]= heap.pop();
        }




    }

    public static void heapSort2(int[] arr){
        Heap heap = new Heap(arr.length);
        //将数组变成堆
        for (int i = (arr.length-1)/2; i >=0 ; i--) {
            heap.heapify(arr,i,arr.length);
        }
        for (int i = arr.length-1; i >  0; i--) {
            heap.swap(arr,0,i);
            heap.heapify(arr,0,i);
        }

    }
}
