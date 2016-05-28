package ibase.test.algorithm.sorts;

/**
 * 堆排序
 * 最小的数跑到最后面了，待排查
 */
public class SortHeap {

    //筛选法调整堆
    public void Sift(int r[], int k, int m){
        int i,j,temp;
        i=k;
        j=2*i+1;                  //置i为要筛的结点，j为i的左孩子
        while (j<=m){
            if (j<m && r[j]<r[j+1])
                j++;                //比较i的左右孩子，j为较大者
            if (r[i]>r[j]) break;   //根结点已经大于左右孩子中的较大者
            else{
                temp=r[i];
                r[i]=r[j];
                r[j]=temp;         //将根结点与结点j交换
                i=j;
                j=2*i+1;           //被筛结点位于原来结点j的位置
            }
        }
    }
    //堆排序
    public void heapSort(int r[ ], int n){
        int i;
        int temp;
        for (i=n/2; i>=0; i--)      //初始建堆，从最后一个非终端结点至根结点
            Sift(r, i, n) ;
        for (i=n-1; i>0; i--){     //重复执行移走堆顶及重建堆的操作
            temp=r[i];
            r[i]=r[0];
            r[0]=temp;
            Sift(r, 0, i-1);
        }
    }
}

