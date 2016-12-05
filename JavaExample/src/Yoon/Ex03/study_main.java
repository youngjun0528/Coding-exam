package Yoon.Ex03;

import java.util.Scanner;

public class study_main {

	/**
	 * @param ���� ������ ���� ������  �Է� �޾Ƽ� �� ������ ������ �󸶳� ���ԵǾ� �ִ��� Ȯ���ϴ� ���α׷�
	 *  �������� Ȯ���ϴ� ���
	 *  1. �ش� ������ 4�� ������ �������鼭 100����  ������ �������� �ʴ� ���
	 *  2. �ش� ������ 400���� ������ �������� ���
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);      // ���� �Է��� ���ڷ� Scanner ����
        
        System.out.println("���� �⵵�� �Է��ϼ���.");
        String startYearToString = null;
        startYearToString = scan.nextLine();            // Ű���� ���� �Է�
        
        String endYearToString = null;
        System.out.println("���� �⵵�� �Է��ϼ���.");
        endYearToString = scan.nextLine();
        
        System.out.println("�Է��Ͻ� ���۳⵵�� " + startYearToString + " ����⵵�� " + endYearToString);
        
        int count = checkYear(startYearToString, endYearToString );
        
        System.out.println(count);
	}
	
	public static int checkYear(String startYearToString, String endYearToString ){
		int countYear = 0;
		int startYear = 0;
		int endYear = 0;
		
		try {
			startYear = Integer.parseInt(startYearToString);
			endYear = Integer.parseInt(endYearToString);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("������ �Է����� �ʾҽ��ϴ�. ���α׷��� �����մϴ�.");
		}
		
		int count = endYear - startYear;
		
		for( int i = 0; i <  count; i++){
			if(startYear % 4 == 0 && startYear % 100 > 0){
				countYear++;
			}else if(startYear % 400 ==0 ){
				countYear++;
			}
			startYear++;
		}
		return countYear;
	}

}
