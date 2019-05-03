[C语言版本的插入排序详解](https://blog.csdn.net/zhao_miao/article/details/82729993)
```java
public class InsertSort {
    public static void main(String[] args) {
        int [] arr = new int[]{3,8,5,7,6,9,4,2,1};
        System.out.print("排序前:");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        insertSort(arr);
        System.out.print("排序后:");
        for(int i :arr){
            System.out.print(i+" ");
        }
    }

    /**
     * 插入排序原理：
     *  将一组数据分成两组，分别将其称为有序组与待插入组
     *  每次从待插入组中取出一个元素，与有序组的元素进行比较，
     *  并找到合适的位置，将该元素插到有序组当中。
     *  就这样，每次插入一个元素，有序组增加，待插入组减少。直到待插入组元素个数为0。
     *
     *  初始状态arr[0]为有序组，所以要元素全部有序需要循环size-1次
     * @param arr 待排序数组
     */
    private static void insertSort(int []arr){
        for(int i = 1 ; i < arr.length ; i++){
            int key = arr[i];
            int k = i-1;
            while(k >= 0 && arr[k] > key) {
                arr[k+1] = arr[k];
                k--;
            }
            arr[k+1] = key;
        }
    }
}
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019041119092990.png)
