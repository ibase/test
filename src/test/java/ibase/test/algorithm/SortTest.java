package ibase.test.algorithm;

import ibase.test.algorithm.sorts.SortBubble;
import ibase.test.algorithm.sorts.SortHeap;
import ibase.test.algorithm.sorts.SortQuick;
import ibase.test.algorithm.sorts.SortSelect;
import org.junit.Test;

public class SortTest {

    @Test
    public void testSortBubble() {
        //BubbleSort
        int[] array = new int[]{5, 2, 8, 3, 1, 7, 9, 16, 56, 32};
        SortBubble is = new SortBubble();
        is.bubble(array);
        System.out.print("冒泡排序：");
        for(int n:array)
            System.out.print(n+",");
    }

    @Test
    public void testSortQuick() {
        //QuickSort
        SortQuick sq = new SortQuick();
        int[] array = new int[]{5, 2, 8, 3, 1, 7, 9, 16, 56, 32};
        sq.quickSort(array, 0, array.length - 1);
        System.out.print("快速排序：");
        for (int n : array)
            System.out.print(n + ",");
        System.out.println();
    }

    @Test
    public void testSortHeap() {
        //QuickSort
        SortHeap sh = new SortHeap();
        int[] array = new int[]{5, 2, 8, 3, 1, 7, 9, 16, 56, 32};
        sh.heapSort(array, array.length-1);
        System.out.print("堆排序：");
        for (int n : array)
            System.out.print(n + ",");
        System.out.println();
    }

    @Test
    public void testSortSelect() {
        //QuickSort
        SortSelect ss = new SortSelect();
        int[] array = new int[]{5, 2, 8, 3, 1, 7, 9, 16, 56, 32};
        ss.selectSort(array, array.length - 1);
        System.out.print("选择排序：");
        for (int n : array)
            System.out.print(n + ",");
        System.out.println();
    }

}
