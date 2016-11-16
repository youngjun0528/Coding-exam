
public class KiwiJuiceEasy {

	public static void main(String[] args) {
		// ���� �뷮
		int[] capacities = {20, 20};
		
		// �ֽ��� �뷮
		int[] bottles = {5, 8};
		
		// ��� �����κ��� ��� ������ ���� ���ΰ�?
		int[] fromId = {0};
		int[] toId = {1};
		
		thePouring(capacities, bottles, fromId, toId);
	}
	
	// Level 1
	public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int toId[]){
		
		// ���ۺ��� indes�� ��ȸ�Ѵ�.
		for(int i = 0; i < fromId.length ; i++){
			// ���ۺ��� index ����
			int from = fromId[i];
			// �������� index ����
			int to = toId[i];
			
			// ������ �ִ� �뷮�� �������� ���� �ִ� �뷮
			int space = capacities[to] - bottles[to];
			
			if(space >= bottles[from]){
				// ���� ���ۺ��� �ֽ� �뷮�� �������� ���� �ִ� �������� �۴ٸ�
				// ��� �ֽ��� ������ �ȿ� �־� ������.
				int vol = bottles[from];
				bottles[to] = bottles[to] + vol;
				bottles[from] = 0;
			}else{
				// ���� ���ۺ��� �ֽ� �뷮�� �������� ���� �ִ� �������� ũ�ٸ�
				// �������� ���� �ִ� �뷮�� ��� ä���
				// ���ۺ��� ���� �ִ� �뷮�� ���� ��ŭ ���� �ִ�. 
				int vol = space;
				bottles[to] = bottles[to] + vol;
				bottles[from] = bottles[from] - vol;
			}
			
		}
		
		return bottles;
	}

}
