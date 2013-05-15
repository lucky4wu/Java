package cn.tv189.test;

import java.util.HashMap;
import java.util.Map;

public class TestSync3 {

	public static Map<Integer,String> tMap = new HashMap<Integer,String>();
	
	public static void load(){
		tMap = new HashMap<Integer,String>();
		tMap.put(1, "1");
	}
	
	public String getTMap(Integer key){
		if(!tMap.containsKey(key)){
			synchronized (TestSync3.class) {
				if(!tMap.containsKey(key)){
					System.out.println("����ͬ���鷽��");
					this.reloadMap();
				}
				System.out.println("����ͬ����");
			}
		}
		return tMap.get(key);
	}
	
	public void reloadMap(){
		Map<Integer,String> tmpMap = new HashMap<Integer,String>();
		tmpMap.put(1, "1");
		tmpMap.put(2, "2");
		tmpMap.put(3, "3");
		tmpMap.put(4, "4");
		tMap = tmpMap;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
