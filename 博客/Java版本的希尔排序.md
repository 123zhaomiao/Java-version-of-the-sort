[C语言版本的希尔排序](https://blog.csdn.net/zhao_miao/article/details/82788162)

```java
public class ShellSort {
    public static void main(String[] args) {
        int [] arr = new int[]{3,8,5,7,6,9,4,2,1};
        System.out.print("排序前:");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        shellSort(arr);
        System.out.print("排序后:");
        for(int i :arr){
            System.out.print(i+" ");
        }
    }
    /**
     * 希尔排序
     * 希尔排序也是利用插入排序的思想来排序。
     * 希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。
     * 这样可以让一个元素可以一次性地朝最终位置前进一大步。
     * 然后算法再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，
     * 但是到了这步，需排序的数据几乎是已排好的了，插入效率比较高。
     * @param arr 待排序数组
     */
    private static void shellSort(int[]arr){
        int gap =3;
        while(gap != 0){
            for(int i = 0 ;i < arr.length-gap;i++){
                //1.待插入元素
                int key = arr[i+gap];
                //插入排序
                int k = i;
                while(k >= 0 && arr[k] > key){
                    arr[k+gap] = arr[k];
                    k = k-gap;
                }
                arr[k+gap] = key;
            }
            gap--;
        }
    }
}
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413200703592.png)
