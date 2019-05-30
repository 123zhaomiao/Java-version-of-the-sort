<font color =red>堆排序原理：</font>
 堆排序指的是将大堆（小堆）堆顶（即下标为0）元素与堆的最后一个元素（下标为size）交换，将其余的元素再次调整成大堆（小堆），再次将堆顶（即下标为0）元素与堆的最后一个（下标为size-1）元素交换,将其余的元素再次调整成大堆（小堆）…………重复上述步骤，直至size = 0
<font color =red>关于升序或者降序应该建立什么堆？？？</font>
若想排升序即最大值应该在最后面，根据堆排序原理，应该建大堆，这样将堆顶元素与最后一个元素交换之后，最大值换到了最后面。
若想排降序即最小值应该在最后面，根据堆排序原理，应该建小堆，这样将堆顶元素与最后一个元素交换之后，最小值换到了最后面。
<font color = red>即升序建大堆、降序建小堆</font>
[C语言版本的堆排代码](https://blog.csdn.net/zhao_miao/article/details/82806853)
代码：
```java
public class Test {
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
```
运行结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190508164128408.png)
