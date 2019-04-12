package 排序.冒泡排序;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new  int[]{3,8,5,7,6,9,4,2,1};
        System.out.print("排序前:");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        bubbleSort(arr);
        System.out.print("排序后:");
        for(int i :arr){
            System.out.print(i+" ");
        }
    }

    /**
     * 1.数据两两比较，将较大的数据挪到后面，这样一次循环后就可以确定一个元素的最终位置。
     * 2. 接着从头开始两两比较，将次大的数据挪到上次已经排序好的数据的前一个位置。
     * 3. 重复size-1次即可将size-1个元素放到它的最终位置上，这样剩下的那个元素肯定在自己的最终位置上，冒泡排序结束。
     * @param arr 待排序数组
     */
    private static void bubbleSort(int[]arr){
        boolean flag = false;
        for(int i = 0; i < arr.length -1 ;i++){
            flag = false;
            for(int j = 0 ; j < arr.length - i -1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    //flag==true代表此地循环有元素的交换
                    flag = true;
                }
            }
            //如果flag = false代表内循环是没有用的  序列已经有序 不用比较了
            if(!flag){
                break;
            }
        }
    }
    private static void swap(int[]arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
