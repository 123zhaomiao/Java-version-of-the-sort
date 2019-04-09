[选择排序及选择排序的优化C语言版](https://blog.csdn.net/zhao_miao/article/details/82791520)

```java
public class SelectSort{
    public static void main(String[] args) {
        int[] arr = new int[]{10,2,5,4,6,9,3,1,0};
        System.out.print("排序前:");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        selectSort(arr);
        System.out.print("排序后:");
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

//    /**
//     * 选择排序的思想(此处为升序)：
//     * 每一次从待排序元素的数组中找出最大值,放在待排序数组的末尾位置
//     * 直到全部待排序的数据元素排完。
//     * @param arr 待排序数组
//     */
//    private static void selectSort(int[]arr){
//        //arr.length个元素，需要排序arr.length-1次
//        for(int i = 0; i < arr.length -1; i++){
//            //最大值下标
//            int max = 0;
//            //待排序数组长度为arr.length减去已排序数组
//            for(int j = 1; j < arr.length - i;j++){
//                if(arr[j] > arr[max]){
//                    max = j;
//                }
//            }
//            //将最大值放在待排序序列的最后一个位置上
//            if(max != arr.length-i-1){
//                swap(arr,max,arr.length-i-1);
//            }
//        }
//    }
    /**
     * 选择排序的优化(此处为升序)：
     * 选择排序是一次找出一个值放在最终的位置上
     * 选择排序的优化是一次性的将最大值和最小值都放在最终的位置上
     * @param arr 待排序数组
     */
    private static void selectSort(int[]arr){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int max = left;
            int min = left;
            //取得待排序数列中的最大值和最小值
            for(int i = left+1; i < arr.length-left;i++){
                if(arr[i] > arr[max]){
                    max = i;
                }
                if(arr[i] < arr[min]){
                    min = i;
                }
            }
            if(max != right){
                swap(arr,max,right);
            }
            if(min == right){
                min = max;
            }
            if(min != left){
                swap(arr,min,left);
            }
            left++;
            right--;
        }
    }
    //交换值
    private static void swap(int[] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190409164227708.png)
