package algrithom;

import java.util.LinkedList;

public class SortTest {
	
	public void insertSort(int[] a){
		for (int i=0;i<a.length;i++){
			for(int j=i;j>0;j--){
				if(a[j]<a[j-1]){
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
			this.printlist(a);
		}
	}
	
    //冒泡排序，两两比较，再相互交换位置
    public void BubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i+1; j < a.length; j++) 
            {
                if (a[i] > a[j]) 
                {
                    // 交换位置
                    int cos = a[i];
                    a[i] = a[j];
                    a[j] = cos;
                }
            }
            this.printlist(a);
        }
    }
    
    public void QuickSort(int[] a, int i, int j){
    	int left = i;
    	int right = j;
    	int temp = 0;
    	if(left <= right){
    		temp = a[left];
    		while(left != right){
    			while(right > left && a[right] >= temp)
    				right--;
    			a[left] = a[right];
    			
    			while(left < right && a[left]<=temp)
    				left++;
    			a[right] = a[left];
    		}
    		a[right] = temp;
    		this.QuickSort(a, i, left-1);
    		this.QuickSort(a, right+1, j);
    	}
    }
    
    public void selectSort(int[] a){
    	for(int i=0;i<a.length;i++){
    		for(int j=i;j<a.length;j++){
    			if(a[j]<a[i]){
    				int temp = a[j];
    				a[j] = a[i];
    				a[i] = temp;
    			}
    		}
    		this.printlist(a);
    	}
    }
	
    
    public void heapSort(int[] a) {
        int i;
        for (i = a.length / 2 - 1; i >= 0; i--) {// 构建一个大顶堆
            this.adjustHeap(a, i, a.length);
            this.printlist(a);
        }
        System.out.println("finish build heap");
        for (i = a.length-1; i >= 0; i--) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            this.adjustHeap(a, 0, i);// 将a中前i-1个记录重新调整为大顶堆
            this.printlist(a);
        }
    }
    
    /**
     * 构建大顶堆
     */
    public void adjustHeap(int[] a, int i, int len) {
        int temp, j;
        temp = a[i];
        for (j = 2 * i+1; j < len; j *= 2) {// 沿关键字较大的孩子结点向下筛选
            if (j+1 < len && a[j] > a[j + 1])
                ++j; // j为关键字中较大记录的下标
            if (temp <= a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }
    
    public void topK(int[] a, int k){
    	int[] b = new int[k];
    	for (int i=0;i<k;i++){
    		b[i]=a[i];
    	}
    	this.heapSort(b);
    	System.out.println("build heap finish");
    	for(int i=k;i<a.length;i++){
    		if (a[k]>b[k-1]){
    			b[k-1] = a[k];
                this.adjustHeap(b, 0, k);
    		}
    		this.printlist(b, k);
    	}
    }
    
    public void mergeSort(int[] a){
    	sort(a, 0, a.length-1);
    }

	private void sort(int[] a, int start, int end) {
		if(start<end){
			int middle = (start+end)/2;
			sort(a, start, middle);
			sort(a, middle+1, end);
			merge(a, start, middle, end);
		}
	}

	private void merge(int[] a, int start, int middle, int end) {
		int[] temp = new int[a.length];
		int mid = middle+1;
		int i = start;
		int j = start;
		while(start<=middle&&mid<=end){
			if(a[start]<=a[mid]){
				temp[i] = a[start];
				i++;
				start++;
			}else{
				temp[i]=a[mid];
				i++;
				mid++;
			}
		}
		while(start<=middle){
			temp[i]=a[start];
			i++;
			start++;
		}
		while(mid<=end){
			temp[i]=a[mid];
			i++;
			mid++;
		}
		while(j<=end){
			a[j]=temp[j];
			j++;
		}
	}
	
	public void bucketSort(int[] a, int max){
		int[] sorted = new int[max+1];
		for(int i=0;i<a.length;i++){
			sorted[a[i]] += 1;
		}
		int k=0;
		for(int i=0;i<sorted.length;i++){
			for(int j=0;j<sorted[i];j++){
				if(sorted[i] >=0){
					a[k]=i;
					k++;
				}
			}
			
		}
	}
	
	public void radixSort(int[] a){
		LinkedList<Integer>[] gewei = new LinkedList[10];
		LinkedList<Integer>[] shiwei = new LinkedList[10];
		for(int i=0;i<10;i++){
			gewei[i] = new LinkedList();
			shiwei[i] = new LinkedList();
		}
		
		for(int i=0;i<a.length;i++){
			gewei[a[i]%10].add(a[i]);
		}
		int k=0;
		for(int i=0;i<10;i++){
			for(Integer data:gewei[i]){
				a[k]=data;
				k++;
			}
		}
		
		for(int i=0;i<a.length;i++){
			shiwei[a[i]/10].add(a[i]);
		}
		
		k=0;
		for(int i=0;i<10;i++){
			for(Integer data:gewei[i]){
				a[k]=data;
				k++;
			}
		}
	}

	public void printlist(int[] a){  
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public void printlist(int[] a, int length){
		for(int i=0;i<length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = {8,3,2,5,9,3,6};
		SortTest test = new SortTest();
		test.insertSort(a);
		
		System.out.println("##########################");
		int[] a2 = {8,3,2,5,9,3,6};
		test.BubbleSort(a2);
		
		System.out.println("##########################");
		int[] a3 = {8,3,2,5,9,3,6,28,23,22,25,19,33,16};
		test.QuickSort(a3, 0, a3.length-1);
		test.printlist(a3);
		System.out.println();
		
		System.out.println("##########################");
		int[] a4 = {8,3,2,5,9,3,6};
		test.selectSort(a4);
		test.printlist(a4);
		
		System.out.println("##########################");
		int[] a5 = {8,3,2,5,9,3,6,28,23,22,25,19,33,16};
		test.printlist(a5);
		test.heapSort(a5);
		test.printlist(a5);
		System.out.println("##########################");
		test.topK(a5, 7);
		test.printlist(a5, 7);
		
		System.out.println("##########################");
		int[] a6 = {8,3,2,5,9,3,6};
		test.mergeSort(a6);
		test.printlist(a6);
		
		System.out.println("##########################");
		int[] a7 = {8,3,2,5,9,3,6};
		test.bucketSort(a7, 9);
		test.printlist(a7);
		
		System.out.println("##########################");
		int[] a8 = {18,13,12,15,19,13,16};
		test.radixSort(a8);
		test.printlist(a8);
	}

}
