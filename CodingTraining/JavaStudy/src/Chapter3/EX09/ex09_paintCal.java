package Chapter3.EX09;

import java.util.Scanner;

public class ex09_paintCal {

	public static void main(String[] args) {
		// ���̿� ���� �Է�
		System.out.println("How about the room height ? ");
		int height = inputScannerInteger();
		
		System.out.println("How about the room weight ? ");
		int weight = inputScannerInteger();
		
		// 1���Ϳ� 9�������� ���� �ִ� ����Ʈ�� �����̳� �ʿ��Ѱ�?
		
		int roomArea = height * weight;
		
		int paintRemain = roomArea % 9;
		int paintCount = roomArea / 9;
		if (paintRemain > 0){
			paintCount++;
		}
		
		System.out.println("You will need to purchase "+ paintCount + " liters of paint to cover " + roomArea + " square meters.");
		

	}
	
	public static String  inputScannerString(){
		String input = null;
		
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();
		
		return input;
	}
	
	public static int  inputScannerInteger(){
		String input = null;
		
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();
		
		return Integer.parseInt(input);
	}
}
