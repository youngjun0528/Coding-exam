
public class Cryptography {

	public static void main(String[] args) {
		
		int[] numbers1 = {1,2,3};
		
		long result1 = encrypt(numbers1);
		
		System.out.println("result1 : " + result1);
		
		int[] numbers2 = {1,3,2,1,1,3};
		
		long result2 = encrypt(numbers2);
		
		System.out.println("result2 : " + result2);
		
	}
	
	public static long encrypt(int[] numbers){
		long tas = 0;
		
		long temp1 = 1;
		// ���� �� �迭 ����� ���� ���Ѵ�.
		for(int i = 0; i < numbers.length ; i++){
			temp1 = temp1 * numbers[i]; 
		}
		//System.out.println("temp1 " + temp1);
		
		long temp2 = 1;
		// �� �迭 ��Ҹ� +1 �� �ϵ��� �Ѵ�.
		for(int i = 0; i < numbers.length ; i++){
			 temp2 = numbers[i] + 1;
			 //System.out.println("temp2 " + temp2);
		}
		
		// ���� �ʱ�ȭ
		temp1 = 1;
		
		// �� �迭 ��Ҹ� +1�� �ϸ鼭 ���� ���Ѵ�.
		// �� 2���� for���� ��ģ��.
		for(int i = 0; i < numbers.length ; i++){
			temp1 = numbers[i] + 1;
			for(int j = 0; j < numbers.length ; j++){
				if(i != j){
					temp1 = temp1 * numbers[j];
				}
			}
			//System.out.println("max : " + temp1);
			tas = Math.max(tas, temp1);
		}
		
		return tas;
	}
	
}
