import java.util.HashMap;

public class InterestingParty {
	public static void main(String[] args) {
		// ��� �־� �ϴ� ����
		
		String[] first= {"fishing", "gardening", "swimming", "fishing"};
		
		String[] second= {"hunting", "fishing", "fishing", "biting"};
		
		int result = bestInvitationForEx(first, second);
		
		System.out.println("result : " + result);
		
		String[] first2= {"snakes", "programming", "cobra", "monty"};
		
		String[] second2= {"python", "python", "anaconda", "python"};
		
		int result2 = bestInvitationForEx(first2, second2);
		
		System.out.println("result2 : " + result2);
	}
	
	public static int bestInvitation(String[] first, String[] second){
		// ���� �м�
		// 1. ù��° ���� �׷� ������ ������ ������ ���� ��� Ž�� 
		// 2. �ι��� ���� �׷� ������ ������ ������ ���� ��� Ž��
		// 3. ù���� ���� �׷�� �ι��� �׷� ������ ������ ������ ���� ��� Ž��
		
		// ������ ù���� ���� �׷� ���� i��° ������ �ι�° ���� �׷� ���� i��° �����ʹ� �ٸ��ٶ�� ���
		// first[i] != second[i]
		// ��, �� ����� ������ ������ 2�� ������ ����.
		
		// �ش��� ���� ������ �ִ� ����� ���� ���ϴ� ������ �Ʒ� 2���� ��Ȳ �� ���� ���� ���� �����Ѵ�.
		// ù���� �׷쳻 ���� ���� �� + ù��° �׷�������� �ι�° �׷�� ������ ���� ��
		// �ι�° �׷쳻 ���� ���� �� + �ι�° �׷�������� ù��° �׷�� ������ ���� ��
		
		
		int max = 0;
		
		for(int i = 0; i < first.length ; i++){
			int result1 = 0;
			int result2 = 0;
			for(int j = 0 ; j< second.length ; j++){
				String subject1 = first[i];
				String subject2 = first[j];
				String subject3 = second[i];
				String subject4 = second[j];
				
				// ù���� �׷� ������ ��ġ�ϴ� ��� �� + 1
				if(subject2.equals(subject1)){
					result1++;
				}
				// �ι��� �׷� ������ ��ġ�ϴ� ��� �� + 1
				if(subject3.equals(subject4)){
					result2++;
				}
				// ù��° �׷� �������� �ι�° �׷� ������ ��ġ�ϴ� ��� �� + 1
				if(subject1.equals(subject4)){
					result1++;
				}
				// �ι�° �׷� �������� ù��° �׷� ������ ��ġ�ϴ� ��� �� + 1
				if(subject3.equals(subject2)){
					result2++;
				}
			}
			max = Math.max(result1, max);
			max = Math.max(result2, max);
		}
		return max;
	}
	
	public static int bestInvitationForEx(String[] first, String[] second){
		
		// ������ å�� �����ִ´�� ��� �������� Loop �¿��� ������ ����� �״��� ��õ���� �ʴ´�.
		// �����ϱ⵵ ��ư� �ݺ����� ���� ����� ��Ȯ�� ���ø��� �ʱ� �����̴�.
		
		// ó�� �����ߴ� ����� HashMap�� ����Ͽ� ��� ������ ���� �������� ã�� ���� �ξ� ��Ȯ�Ѵ�.
		// ��� �� ���ؿ�����...
		// �ᱹ �������� ���Դ�.
		
		int max = 0;
		
		HashMap<String, Integer> map = new HashMap<>();
		
		// 1. ù��° �׷� ������ ���� ���� HashMap�� ��´�.
		for(int i = 0 ; i < first.length ; i++){
			if(map.get(first[i]) != null){
				map.put(first[i], map.get(first[i])+1);
			}else{
				map.put(first[i], 1);
			}
		}
		
		// 1. �ι�° �׷� ������ ���� ���� HashMap�� ��´�.
		for(int i = 0 ; i < second.length ; i++){
			if(map.get(second[i]) != null){
				map.put(second[i], map.get(second[i])+1);
			}else{
				map.put(second[i], 1);
			}
		}
		
		for (String key : map.keySet()) {
			max = Math.max(map.get(key), max);
		}
		
		return max;
	}
	
}
