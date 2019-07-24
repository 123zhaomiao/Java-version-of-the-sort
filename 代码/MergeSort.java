package 排序.归并排序;
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new  int[]{3,8,5,7,6,9,4,2,1};
        System.out.print("排序前:");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        mergeSort(arr,0,arr.length-1);
        System.out.print("排序后:");
        for(int i :arr){
            System.out.print(i+" ");
        }
    }
   
    /**
     * 归并排序的思想和快速排序的思想差不多
     * 只是归并排序的基准值选择的是待排序数组的中间位置
     * @param arr 待排序的数组
     */
    private static void mergeSort(int []arr,int left,int right){
        if(left < right){
            int position = (left+right)/2;
            mergeSort(arr,left,position);
            mergeSort(arr,position+1,right);
            //该方法时进行两个有序数组的合并
            merge(arr,left,position,right);
        }
    }
    
    //合并 与两个链表的合并类似
    private static void merge(int [] arr,int left,int position,int right){
        int[] temp = new int[right - left + 1];
        int begin = position+1;
        int oldleft = left;
        int k = 0;
        //判断合法性
        while(left <= position && begin <= right){
            if(arr[left] < arr[begin]){
                temp[k++] = arr[left++];
            }else{
                temp[k++] = arr[begin++];
            }
        }
        while(left <= position){
            temp[k++] = arr[left++];
        }
        while(begin <= right){
            temp[k++] = arr[begin++];
        }
        //将排序好的数组赋值到原来的数组
        for(int i = 0;i< temp.length;i++){
            arr[oldleft+i] = temp[i];
        }
    }
}
