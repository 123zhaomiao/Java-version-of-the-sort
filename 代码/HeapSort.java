package 排序.堆排序;


public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,7,1,5,8,6,9,0};
        solution(arr);
    }

    /**
     * @param arr
     */
    private static void solution(int[] arr) {
        //1.建堆
        createHeap(arr);
        //2.将堆顶元素与最后一个元素交换 调整堆
        int len = arr.length-1;
        while(len > 0){
            int temp = arr[0];
            arr[0] = arr[len];
            arr[len] = temp;
            adjustHeap(arr,0,--len);
        }
        for(int i: arr){
            System.out.print(i+" ");
        }
    }

    private static void createHeap(int[] arr) {
        //1.建堆从最后一个非叶子结点开始
        int begin = arr.length/2 -1;
        for(int i = begin;i >= 0; i--){
            //运用向下调整的方式建堆
            adjustHeap(arr,i,arr.length-1);
        }
    }

    private static void adjustHeap(int[] arr,int begin,int end) {
        int temp = 0;
        int child = 0;
        for(temp = arr[begin]; 2*begin+1 <= end; begin = child){
            child = 2*begin + 1;
            //找出左右孩子中较大的值
            if(child+1 <= end && arr[child+1] > arr[child]){
                child++;
            }
            //如果父节点 小于左右孩子中较大的那一个  则交换
            if(temp < arr[child]){
                arr[begin] = arr[child];
            }else{
                break;
            }
        }
        arr[begin] = temp;
    }

}
