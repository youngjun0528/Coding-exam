package Yoon.Ex05;

import java.util.ArrayList;
import java.util.Scanner;


public class ExamCheckMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("1. ��ü �л��� �̸��� ���� ��� �ϼ���. >>>>>");
		System.out.println("2. ��ü �л� �� ���� ������ ����� ���ϼ���. >>>>>");
		System.out.println("3. ��ü �л� �� ���� ������ ��տ� ���� ����� ����� ���ϼ���. >>>>>");
		System.out.println("4. ���� ���� ���� ����� ���� ������ ����� ���ϼ���. >>>>>");
		System.out.println("5. ��� �л� �߿��� ���� ������  �ִ밪�� �ּҰ��� ���ϼ���. >>>>>");
		System.out.println("6. ���� ������ �������� �������� �����ϼ���. >>>>>");
		System.out.println("7. ���� ������ �������� �������� �����ϼ���. >>>>>");
		System.out.println("8. �л� �߿��� ���� ���� ������ ���� ���� ���ϼ���. >>>>>");
		
		ExamFileReader file= new ExamFileReader();
		ArrayList<ExamDao> daoList = new ArrayList<ExamDao>();
		daoList = file.reader();
		Scanner sc = new Scanner(System.in);
		System.out.print("�޴��� �Է��ϼ���. >>>>>");
		ExamBiz biz = new ExamBiz();
		while(true){
			int input = sc.nextInt();
			if(input == 1){
				 //��� �л��� ������ ���
				biz.print(daoList);
				System.out.print("�޴��� �Է��ϼ���. >>>>>");
			}else if(input == 2){
				//���� ���� ����� ���
				int sum = biz.fnSummury(daoList, "korean");
				System.out.println("���� ������ ������ : " + sum );
				System.out.println("���� ������ ����� : " + sum / daoList.size());
				System.out.print("�޴��� �Է��ϼ���. >>>>>");
			}else if(input == 3){
				String name = null;
				name = biz.fnNear(daoList, "korean");
				System.out.println("��տ� ���� ������ ����� " + name);
				System.out.print("�޴��� �Է��ϼ���. >>>>>");
			}else if(input == 4){
				int avg = 0;
				avg = biz.fnAverage(daoList, "english", "��");
				System.out.println("���� ���� ���� ����� ���� ��� " + avg);
				System.out.print("�޴��� �Է��ϼ���. >>>>>");
			}else if(input == 5){
				int[] minMax = null;
				minMax = biz.fnMinMax(daoList, "math");
				System.out.println("���� ������ �ִ밪 :  " + minMax[0] +  " �ּҰ�  : " +minMax[1]);
				System.out.print("�޴��� �Է��ϼ���. >>>>>");
			}else if(input == 6){
				System.out.println("���� ���� ���� �������� ���� ");
				biz.fnASC(daoList, "math");
				System.out.print("�޴��� �Է��ϼ���. >>>>>");
			}else if(input == 7){
				System.out.println("���� ���� ���� �������� ����" );
				biz.fnDESC(daoList, "english");
				System.out.print("�޴��� �Է��ϼ���. >>>>>");
			}else if(input == 8){
				String nameSub = null;
				nameSub = biz.fnMode(daoList);
				System.out.println("�л� �߿� ���� ���� ������ " + nameSub);
				System.out.print("�޴��� �Է��ϼ���. >>>>>");
			}
		}
	}
}
