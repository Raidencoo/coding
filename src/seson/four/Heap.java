package seson.four;

public class Heap {

    private int[] heap;

    private int heapSize;

    private int limit;


    public Heap(int size){
        this.limit=size;
        heap=new int[size];
        heapSize=0;
    }

    public boolean isEmpty(){
        return heapSize==0;
    }
    public boolean isFull(){
        return heapSize==limit;
    }
    public void push(int value){
        if (heapSize==limit){
            throw  new RuntimeException("堆已满！");
        }
        heap[heapSize]=value;
        heapInsert(heap,heapSize++);
    }

    public int pop(){
        if (isEmpty()){
            throw  new RuntimeException("堆为空！");
        }
        int ans=heap[0];
        swap(heap,0,--heapSize);
        heapify(heap,0,heapSize);
        return ans;
        
    }

    public void heapify(int[] arr, int parent, int heapSize) {
        int son=parent*2+1;
        while (son<heapSize){
            int largest=son+1<heapSize&&arr[son+1]>arr[son]?son+1:son;
            if (arr[parent]<arr[largest]){
                swap(arr,parent,largest);
                parent=largest;
                son=parent*2+1;
            }else {
                break;
            }
        }



    }

    public void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public void heapInsert(int[] arr,int index) {
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2 );
            index=(index-1)/2;
        }

    }


    public static void main(String[] args) {
        Heap heap = new Heap(7);
        heap.push(4);
        heap.push(5);
        heap.push(3);
        heap.push(7);
        heap.push(9);
        heap.push(2);
        heap.push(1);
        heap.pop();
        heap.pop();

        System.out.println(heap);
    }

}
