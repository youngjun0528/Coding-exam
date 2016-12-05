package Yoon.Ex02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
 
public class Example {
 
    public static void main(String[] args) {
        
        Example main = new Example();
        main.start();
    }
    
    private void start() {
        
        String names = "������,���翵,����ǥ,���翵,"
                + "�ڹ�ȣ,������,���翵,������,�ֽ���,�̼���,�ڿ���,"
                + "�ڹ�ȣ,������,����ȯ,���缺,������,������";
        
        String[] nameList = names.split(",");
        List<String> list = this.nameCount(nameList);
        List<String> uniqueNames = this.removeDupliacate(list);
        List<String> ascNames = this.removeASC(list);
        
    }
    
    public List<String> nameCount(String[] nameList){
    	 int count_kim = 0;
         int count_lee = 0;
         int count_ljy = 0;
         
         List<String> list = new ArrayList<String>();
         
         /**
          * To-Do
          */
         for(int i =0 ; i <= nameList.length-1 ; i++){
        	 if(nameList[i].substring(0, 1).equals("��")){
        		 count_kim++;
        	 }else if(nameList[i].substring(0, 1).equals("��")){
        		 count_lee++;
        	 }
        	 if(nameList[i].equals("���翵")){
        		 count_ljy++; 
        	 }
        	 list.add(i, nameList[i]);
         }
         
         System.out.println("�达:" + count_kim);
         System.out.println("�̾�:" + count_lee);
         System.out.println("���翵:" + count_ljy);
         
         return list;
    }
    
    public List<String> removeDupliacate(List<String> list){
    	//�ߺ�����
        List<String> uniqueNames = new ArrayList<String>();
        /**
         * To-Do
         */
        HashMap<String, String> nameMap = new HashMap<String, String>();
        
        for(int i  = 0; i < list.size() ; i++){
        	nameMap.put(list.get(i), list.get(i));
        }
        
        System.out.println("�ߺ�����:"+ nameMap);
        System.out.println("�ߺ�����:"+ nameMap.values());
        
        return uniqueNames;
    }
    
    public List<String> removeASC(List<String> uniqueNames){
    	//������������
        /**
         * To-Do
         */
    	Collections.sort(uniqueNames);
    	
    	System.out.println("��������:"+uniqueNames);
    	
    	Collections.reverse(uniqueNames);
    	
        System.out.println("��������:"+uniqueNames);
        
        return uniqueNames;
    }
}