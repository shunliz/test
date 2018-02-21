package algrithom;

import java.util.HashMap;

public class DPAlgTest {

	public static void main(String[] args) {
		DPAlgTest test = new DPAlgTest();
		long start, end;
		int ways;
		
		/**
		 * ��һ���߶���10��̨�׵�¥�ݣ����������ߣ�ÿ��һ��ֻ������1������2��̨�ס�
		 * Ҫ���ó��������һ���ж������߷���
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
		 * ��һ�����ҷ�����5�����ÿ�����Ļƽ�����ͬ����Ҫ�����ھ�Ĺ�����Ҳ��ͬ��
		 * �����ڿ��˵�������10�ˡ�ÿ�����Ҫôȫ�ڣ�Ҫô���ڣ������ɳ�һ������ȡһ����
		 * Ҫ���ó���������Ҫ��õ������ܶ�Ļƽ�Ӧ��ѡ����ȡ�ļ������
		 */
		
		
	}

	/**
	 * �򵥵ݹ鷽��
	 * ʱ�临�Ӷ�O(2^n)
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
	 * ����¼����
	 * ʱ�临�Ӷ�O(N)
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
	 * ��̬�滮����
	 * ʱ�临�Ӷ� O(N)
	 * �ռ临�Ӷ�O(1)
	 * 
	 * ��N�ر��ʱ�� �������ά��ʱ�� ��Ҫ���ٿռ��ݴ��м�����ʱ�ո��Ӷȷ�������򵥵ݹ顣
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
		
		//���߽���ӵ�ֵ
		for(int i=0; i<=n; i++){
			if(i < p[0]){
				preResults[i] = 0;
			}else{
				preResults[i] = g[0];
			}
		}
		
		//����������
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
