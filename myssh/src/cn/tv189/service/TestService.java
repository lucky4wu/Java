package cn.tv189.service;

public class TestService {
	
	private int j = 0;
	private TestService(){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public String doService(){
		System.out.println("j="+ ++j);
		return "got u";
	}
}
