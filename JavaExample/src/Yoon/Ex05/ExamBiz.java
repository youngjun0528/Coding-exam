package Yoon.Ex05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class ExamBiz {
	public int fnSummury(ArrayList<ExamDao> arrayList, String type) {
		int sumScore = 0;
		for (ExamDao dao : arrayList) {
			if (type.equals("korean")) {
				sumScore = sumScore + dao.getKorean_Score();
			} else if (type.equals("english")) {
				sumScore = sumScore + dao.getEnglish_Score();
			} else if (type.equals("math")) {
				sumScore = sumScore + dao.getMath_Score();
			}
		}
		return sumScore;
	}

	public String fnNear(ArrayList<ExamDao> arrayList, String type) {
		String name = null;
		String minName = null;
		int nearScore = 0;
		int near = fnSummury(arrayList, type) / arrayList.size();
		int min = Integer.MAX_VALUE; // ���ص����� �ּҰ� - Interger���� �ִ밪���� ���� �ִ´�.
		// 2. process
		for (int i = 0; i < arrayList.size(); i++) {
			int korean = arrayList.get(i).getKorean_Score();
			int check = Math.abs(korean - near); // ���밪�� ���Ѵ�.
			if (min > check) {
				min = check;
				nearScore = korean;
				name = arrayList.get(i).getName();
			}
		}
		ArrayList<ExamDao> checkArr = new ArrayList<ExamDao>();

		for (int i = 0; i < arrayList.size(); i++) {
			if (nearScore == arrayList.get(i).getKorean_Score()) {
				if (arrayList.get(i).getName().compareTo(name) > 0) {
					minName = name;
					// System.out.println(minName);
				}
				checkArr.add(arrayList.get(i));
			}
		}
		Collections.sort(checkArr, new NameAscCompare());
		// return checkArr.get(0).getName();
		return minName;
	}

	public int fnAverage(ArrayList<ExamDao> arr, String type, String nameSub) {
		int avg = 0;
		int sum = 0;
		int count = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getName().substring(0, 1).equals("��")) {
				sum += arr.get(i).getEnglish_Score();
				count++;
			}
		}
		avg = sum / count;
		return avg;
	}

	public int[] fnMinMax(ArrayList<ExamDao> arr, String type) {
		int[] minMax = new int[2];
		int max = Integer.MIN_VALUE; // �������� ���� ���� �����ͷ� �ʱ�ȭ
		int min = Integer.MAX_VALUE; // �������� ���� ū �����ͷ� �ʱ�ȭ

		for (int i = 0; i < arr.size(); i++) {
			// �ִ밪 Max
			if (arr.get(i).getMath_Score() > max) {
				max = arr.get(i).getMath_Score();
			}
			// �ּҰ� Min
			if (arr.get(i).getMath_Score() < min) {
				min = arr.get(i).getMath_Score();
			}
		}
		minMax[0] = max;
		minMax[1] = min;
		return minMax;
	}

	public String fnMode(ArrayList<ExamDao> arr) {
		String nameSub = ""; // �ֺ�
		HashMap<String, Integer> index = new HashMap<String, Integer>();
		int max = Integer.MIN_VALUE; // �ִ밪�� �����ϱ����� ���� : �ʱⰪ�� �������� �ּҰ� ����
		// 2. process
		int count = 0;
		for (int i = 0; i < arr.size(); i++) {
			String key = arr.get(i).getName().substring(0, 1);
			if (index.containsKey(key)) {
				count = index.get(key) + 1;
				index.put(key, count);
			} else {
				index.put(arr.get(i).getName().substring(0, 1), 1);
			}
		}

		for (Entry<String, Integer> d : index.entrySet()) {
			if (max < d.getValue()) {
				max = d.getValue();
				nameSub = d.getKey();
			}
		}
		return nameSub;
	}

	public ArrayList<ExamDao> fnASC(ArrayList<ExamDao> arr, String type) {

		int i = 0;
		int j = 0;

		for (i = 0; i < arr.size() - 1; i++) {
			for (j = 0; j < arr.size() - 1 - i; j++) {
				if (arr.get(j).getMath_Score() > arr.get(j + 1).getMath_Score()) {
					ExamDao tempDao1 = new ExamDao();
					ExamDao tempDao2 = new ExamDao();
					tempDao1 = arr.get(j);
					tempDao2 = arr.get(j + 1);
					
					arr.remove(j);
					arr.add(j, tempDao2);
					arr.remove(j + 1);
					arr.add(j + 1, tempDao1);
				}
			}
		}
		print(arr);

		return arr;
	}

	public ArrayList<ExamDao> fnDESC(ArrayList<ExamDao> arr, String type) {

		int indexMin = 0;
		int temp = 0;
		
		for (int i = 0; i < arr.size() - 1; i++) {
	        indexMin = i;
	        for (int j = i + 1; j < arr.size(); j++) {
	            if (arr.get(j).getEnglish_Score() < arr.get(indexMin).getEnglish_Score()) {
	                indexMin = j;
	            }
	        }
	        ExamDao dao1 = new ExamDao();
	        dao1 = arr.get(i);
	        ExamDao dao2 = new ExamDao();
	        dao2 = arr.get(indexMin);
	        
	        arr.remove(indexMin);
	        arr.add(indexMin, dao1);
	        
	        arr.remove(i);
	        arr.add(i, dao2);
	        
	    }
		print(arr);

		return arr;
	}

	public void print(ArrayList<ExamDao> arr) {
		for (int i = 0; i < arr.size(); i++) {
			ExamDao dao = arr.get(i);
			String name = dao.getName();
			int korean = dao.getKorean_Score();
			int english = dao.getEnglish_Score();
			int math = dao.getMath_Score();

			System.out.println("�̸� : " + name + "\t/ ���� ���� : " + korean
					+ "\t/ ���� ���� : " + english + "\t/ ���� ���� : " + math);
		}
	}
}

/**
 * �̸� ��������
 * 
 * @author falbb
 * 
 */
class NameAscCompare implements Comparator<ExamDao> {

	/**
	 * ��������(ASC)
	 */
	@Override
	public int compare(ExamDao arg0, ExamDao arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}

}
