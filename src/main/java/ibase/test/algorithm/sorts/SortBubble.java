package ibase.test.algorithm.sorts;

/**
 * 冒泡排序
 */
public class SortBubble {
    /**
     * 冒泡排序算法
     * @param array 待排序数组
     */
	public void bubble(int[] array){
		for(int i=1,len=array.length; i<len; i++)
			for(int j=0; j<array.length-i; j++){
				if(array[j]>array[j+1]){
					int t = array[j];
					array[j] = array[j+1];
					array[j+1] = t;
			}
		}
	}

    /**
     * 冒泡排序算法
     * @param objArray 待排序数组
     */
    public void bubble(double[] objArray){
        for(int i=1,len=objArray.length; i<len; i++)
            for(int j=0; j<objArray.length-i; j++){
                if(objArray[j]>objArray[j+1]){
                    double t = objArray[j];
                    objArray[j] = objArray[j+1];
                    objArray[j+1] = t;
                }
            }
    }
}
