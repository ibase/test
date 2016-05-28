package ibase.test.algorithm.sorts;

/**
 * 归并排序
 */
public class SortMerge {

    //一次相邻数组排序
    public void MergeFirst(int[] r,int[] r1, int s,int m,int t){
        //相邻有序序列r[s]~r[m]和r[m+1]~r[t],合成有序序列r1[s]~r1[t]
        //i,j分别指向相邻有序序列的当前元素，k指向合成有序序列的当前元素
        int i=s,j=m,k=s;
        while(i<m && j<t){
            if(r[i]<=r[j])
                r1[k++] = r[i++];
            else
                r1[k++] = r[j++];
        }
        //处理未排序的序列,前半部分和后半部分
        if(i<m) {
            while (i < m)
                r1[k++] = r[i++];
        }
        else {
            while (j < t)
                r1[k++] = r[j++];
        }
    }

    //一层相邻数组排序,从下标为0开始存放待排序列
    public void MergeSecond(int[] r,int[] r1,int n,int h){
        int i=0;
        while(i<=n-2*h){
            MergeFirst(r, r1, i,i+h,i+2*h);
            i+=2*h;
        }
        //最后一个序列长度小于h（子序列的数组长度）
        if(i<n-h)
            MergeFirst(r, r1, i,i+h,n);
            //排至剩下最后一个子序列
        else
            for(int k=i;k<n;k++)
                r1[k]=r[k];
    }

    //全体二路归并排序非递归实现
    public void MergeAll(int[] r,int[] r1,int n){
        int h=1;//h为初始子序列(h)长度
        while(h<n){
            MergeSecond(r, r1, n, h);//待排序列r传至r1
            h=2*h;
            MergeSecond(r1, r, n, h);//待排序列r1传回r
            h=2*h;
        }
    }
}
