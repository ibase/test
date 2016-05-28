package ibase.test.algorithm.sorts;

/**
 * 选择排序
 */
public class SortSelect {
    /**
     *
     * @param array 待排序数组
     * @param n 数组长度
     */
    public void selectSort(int[] array, int n){
        /**
         * i 无序区中第一个位置
         * j 中间变量
         * index 无序区中第一个位置，用于与无序区的其他r[j]进行比较
         * temp 用于交换变量
         */
        int i,j,index,temp;
        //对n个记录进行n-1趟简单选择排序
        for (i=0; i<n-1; i++){
            index=i;
            //在无序区中选取最小记录
            for (j=i+1; j<n; j++)
                if (array[j]<array[index])
                    index=j;
            if (index!=i){
                temp=array[i];
                array[i]=array[index];
                array[index]=temp;
            }
        }
    }
}