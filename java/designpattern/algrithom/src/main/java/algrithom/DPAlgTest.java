package algrithom;

import java.util.HashMap;

public class DPAlgTest {

	public static void main(String[] args) {
		DPAlgTest test = new DPAlgTest();
		long start, end;
		int ways;
		
		/**
		 * 有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。
		 * 要求用程序来求出一共有多少种走法。
		 **/
		start = System.currentTimeMillis();
		ways = test.getClimbingWays1(10);
		end = System.currentTimeMillis();
		System.out.println("way1:"+ways+" using time:"+(end-start));
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		start = System.currentTimeMillis();
		ways = test.getClimbingWays2(10, map);
		end = System.currentTimeMillis();
		System.out.println("way1:"+ways+" using time:"+(end-start));
		

		/**
		 * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
		 * 参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
		 * 要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
		 */
		
		
	}

	/**
	 * 简单递归方法
	 * 时间复杂度O(2^n)
	 * **/
	public int getClimbingWays1(int n){
		if(n <1){
			return 0;
		}
		
		if(n == 1){
			return 1;
		}
		
		if(n==2){
			return 2;
		}
		
		return getClimbingWays1(n-1) + getClimbingWays1(n-2);
	}
	
	/**
	 * 备忘录方法
	 * 时间复杂度O(N)
	 * **/
	public int getClimbingWays2(int n, HashMap<Integer, Integer> map){
		if(n <1){
			return 0;
		}
		
		if(n == 1){
			return 1;
		}
		
		if(n==2){
			return 2;
		}
		
		if(map.containsKey(n)){
			return map.get(n);
		}else{
			int value = getClimbingWays2(n-1, map) + getClimbingWays2(n-2, map);
			map.put(n, value);
			return value;
		}
	}
	
	/**
	 * 动态规划方法
	 * 时间复杂度 O(N)
	 * 空间复杂度O(1)
	 * 
	 * 当N特别大时候， 多个输入维度时候， 需要开辟空间暂存中间结果。时空复杂度反而不如简单递归。
	 */
	public int getClimbingWays3(int n){
		if(n <1){
			return 0;
		}
		
		if(n == 1){
			return 1;
		}
		
		if(n==2){
			return 2;
		}
		
		int a = 1;
		int b = 2;
		int temp = 0;
		for(int i=3;i<n;i++){
			temp = a + b;
			a = b;
			b = temp;
		}
		return temp;
	}
	
	public int getMostGold(int n, int w, int[] g, int[] p){
		int[] preResults = new int[p.length];
		int[] results = new int[p.length];
		
		//填充边界格子的值
		for(int i=0; i<=n; i++){
			if(i < p[0]){
				preResults[i] = 0;
			}else{
				preResults[i] = g[0];
			}
		}
		
		//填充其余格子
		for(int i=0;i<n;i++){
			for(int j=0;j<w;j++){
				if(j<p[i]){
					results[j] = preResults[j];
				}else{
					results[j] = Math.max(preResults[j], preResults[j]+g[i]);
				}
			}
			preResults = results;
		}
		
		return results[n];
	}

}
