package ibase.test.algorithm.sorts;

/**
 * 快速排序
 */
public class SortQuick {
    /**
     * 第一次划分大小
     * @param array 需要排序的数组
     * @param start 数组的第一个元素索引
     * @param end 数组的最后一个元素索引
     * @return 扫描完毕指针的位置
     */
    public int once(int[] array,int start,int end){
        int i=start,j=end,temp=0;
        while(i<j){
            //右侧扫描
            while(i<j && array[i]<=array[j])
                j--;
            //较小的数置于前面
            if(i<j){
                temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                i++;
            }
            //左侧扫描
            while(i<j && array[i]<=array[j])
                i++;
            //较大的数置于后面
            if(i<j){
                temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                j--;
            }
        }
        return i;//返回记录的位置
    }

    /**
     *
     * @param array 待排序数组
     * @param start 数组第一个元素索引
     * @param end 数组最后一个元素索引
     */
    public void quickSort(int[] array,int start,int end){
        //int location;
        if(start<end){
            int location = once(array,start,end);
            quickSort(array,start,location-1);
            quickSort(array,location+1,end);
        }
    }
}

