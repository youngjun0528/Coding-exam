package Yoon.Ex04;

import java.util.ArrayList;


public class VersionCompare {

	/**
	 * A���� �� ���� ������ ���ϴ� ���α׷��� �ۼ��ؾ� �Ѵ�.

		������ ����ó�� "." ���� ���е� ���ڿ��̴�.
		
		���� ��) 1.0.0, 1.0.23, 1.1
		
		�� ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		
		������ ���� ���� ���̴�.
		
		0.0.2 > 0.0.1
		1.0.10 > 1.0.3
		1.2.0 > 1.1.99
		1.1 > 1.0.1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Version> arr = new ArrayList<Version>();
		Version ver1 = new Version();
		ver1.setCheckVersion("0.0.1");
		ver1.setDefineVersion("0.0.2");
		arr.add(ver1);
		
		Version ver2 = new Version();
		ver2.setCheckVersion("1.0.10");
		ver2.setDefineVersion("1.0.3");
		arr.add(ver2);
		
		Version ver3 = new Version();
		ver3.setCheckVersion("1.2.0");
		ver3.setDefineVersion("1.1.99");
		arr.add(ver3);
		
		Version ver4 = new Version();
		ver4.setCheckVersion("1.0.1");
		ver4.setDefineVersion("1.1");
		arr.add(ver4);
		
		for(int i = 0; i < arr.size() ; i++){
			System.out.println(arr.get(i));
		}
		
		VersionCompare.compareVerisonBiz(arr);
	}
	
	public static  void compareVerisonBiz(ArrayList<Version> arr){
		for(int i = 0; i < arr.size() ; i++){
			Version check = arr.get(i);
			
			//String checkVer = new String(check.getCheckVersion());
			String checkVer = "";
			checkVer = check.getCheckVersion() + "";
			String[] checkVerSP = checkVer.split(".");
			//String defineVer = new String(check.getDefineVersion());
			String defineVer = check.getDefineVersion()  + "";
			String[] defineVerSP = defineVer.split(".");
			int size = 0;
			if(checkVerSP.length > defineVerSP.length){
				size = checkVerSP.length;
			}else{
				size = defineVerSP.length;
			}
			
			boolean ch = false;
			for(int j = 0 ; j< size ; j++){
				System.out.println(Integer.parseInt(checkVerSP[j]));
				System.out.println(Integer.parseInt(defineVerSP[j]));
				if(Integer.parseInt(checkVerSP[j]) > Integer.parseInt(defineVerSP[j])){
					ch = true;
					break;
				}
			}
			
			if(ch){
				System.out.println(check.getCheckVersion() + "�� �� ���� �����Դϴ�.");
			}else{
				System.out.println(check.getDefineVersion() + "�� �� ���� �����Դϴ�.");
			}
		}
	}

}
